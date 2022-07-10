package assignment;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.regex.*;

public class PLYMeshReader implements MeshReader {
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException, FileNotFoundException, IOException {
		HashSet<Polygon> hs = new HashSet<Polygon>();
		
		
		BufferedReader headerReader = new BufferedReader(new FileReader(filename));
		String line;
		// TODO check the header is correct
		String[] headerRegex = {
			"ply",
			"format ascii 1.0",
			"element vertex [\\d]+",
			"property float32 x",
			"property float32 y",
			"property float32 z",
			"element face [\\d]+",
			"property list uint8 int32 vertex_indices",
			"end_header"
		};
		
		int numVertex = 0;
		int numFaces = 0;
		
		for(int i=0; i < 9; i++) {
			String currRegex = headerRegex[i];
			Pattern currPattern = Pattern.compile(currRegex);
			line = headerReader.readLine();
			if(line == null) {
				headerReader.close();
				throw new WrongFileFormatException("Null header line");
			}
			line = line.strip();
			
			Matcher currMatcher = currPattern.matcher(line);
			if(!currMatcher.matches()) {
				headerReader.close();
				throw new WrongFileFormatException("Invalid header");
			}
			// Num vertex line
			if(i == 2) {
				numVertex = Integer.parseInt(line.split("[\\s]+")[2]);
			}
			// Num faces line
			else if(i == 6) {
				numFaces = Integer.parseInt(line.split("[\\s]+")[2]);
			}
		}
		
		headerReader.close();
		
		Pattern fStart = Pattern.compile("3([\\s]+[\\d]+){3}");
		Pattern vStart = Pattern.compile("([\\-]?([\\d]+[\\.])?[\\d]+(E[+\\-][\\d]+)?[\\s]+){2}[\\-]?([\\d]+[\\.])?[\\d]+(E[+\\-][\\d]+)?");
		
		// Go to start of faces lines
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		for(int i=0; i < 9+numVertex; i++) {
			line = reader.readLine();
		}
		
		for(int i=0; i < numFaces; i++) {
			line = reader.readLine(); 
			if(line == null) {
				reader.close();
				throw new WrongFileFormatException("Null face line");
			}
			line = line.strip();
			
			Matcher fMatch = fStart.matcher(line);
			if(!fMatch.matches()) {
				reader.close();
				throw new WrongFileFormatException("Invalid face line");
			}
			
			String[] fArr = line.split("[\\s]+");
			
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
			
			// For each vertex line
			for(int j=1; j < 4; j++) {
				int lineNum = Integer.parseInt(fArr[j]);
				
				BufferedReader vReader = new BufferedReader(new FileReader(filename));
				String vline;
				for(int k=0; k < 9+lineNum; k++) {
					vline = vReader.readLine();
				}
				
				vline = vReader.readLine();
				if(vline == null) {
					vReader.close();
					throw new WrongFileFormatException("Null vertex line");
				}
				vline = vline.strip();
				
				Matcher vMatch = vStart.matcher(vline);
				if(!vMatch.matches()) {
					vReader.close();
					throw new WrongFileFormatException("Invalid vertex line");
				}
				
				String[] vArr = vline.split("[\\s]+");
				double x = Double.parseDouble(vArr[0]);
				double y = Double.parseDouble(vArr[1]);
				double z = Double.parseDouble(vArr[2]);
				x = Math.round(x * 100000.0) / 100000.0;
				y = Math.round(y * 100000.0) / 100000.0;
				z = Math.round(z * 100000.0) / 100000.0;
				Vertex v = new Vertex(x, y, z);
				vertices.add(v);
				
				vReader.close();
			}
			
			Polygon p = new Polygon(vertices);
			hs.add(p);
		}
		
		// Checks after all known lines for extras
		line = reader.readLine();
		while(line != null) {
			if(line.strip() != "") {
				reader.close();
				throw new WrongFileFormatException("More lines than listed");
			}
			line = reader.readLine();
		}
		
		reader.close();
		
		return hs;
	}
	
}
