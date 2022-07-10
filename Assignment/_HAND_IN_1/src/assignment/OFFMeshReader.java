package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.*;

public class OFFMeshReader implements MeshReader {
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException, FileNotFoundException, IOException {
		HashSet<Polygon> hs = new HashSet<Polygon>();
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		if(line == null) {
			reader.close();
			throw new WrongFileFormatException("Null OFF line");
		}
		line = line.strip();
		
		if(!line.equals("OFF")) {
			reader.close();
			throw new WrongFileFormatException("Invalid OFF start");
		}
		
		line = reader.readLine();
		if(line == null) {
			reader.close();
			throw new WrongFileFormatException("Null header line");
		}
		line = line.strip();
		
		Pattern head = Pattern.compile("[\\d]+[\\s]+[\\d]+[\\s]+[\\d]+");
		Matcher hMatch = head.matcher(line);
		if(!hMatch.matches()) {
			reader.close();
			throw new WrongFileFormatException("Invalid header line");
		}
		
		int numVertex = Integer.parseInt(line.split("[\\s]+")[0]);
		int numFaces = Integer.parseInt(line.split("[\\s]+")[1]);
		
		// Go to start of faces lines
		for(int i=0; i < numVertex; i++) {
			line = reader.readLine();
		}
		
		Pattern fStart = Pattern.compile("3([\\s]+[\\d]+){3}(([\\s]+[\\d]+){3})?");
		Pattern vStart = Pattern.compile("([\\-]?([\\d]+[\\.])?[\\d]+(E[+\\-][\\d]+)?[\\s]+){2}[\\-]?([\\d]+[\\.])?[\\d]+(E[+\\-][\\d]+)?");
		
		// For each face line
		for(int i=0; i < numFaces; i++) {
			// TODO: regex check
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
			// Has rgb values, check if between 0-255
			if(fArr.length == 7) {
				for(int k=4; k < 7; k++) {
					double rgbVal = Integer.parseInt(fArr[k]);
					if(rgbVal < 0 || rgbVal > 255) {
						reader.close();
						throw new WrongFileFormatException("Invalid RGB values");
					}
				}
			}
			
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
			// For each vertex
			for(int j=1; j < 4; j++) {
				int lineNum = Integer.parseInt(fArr[j]);
				
				BufferedReader vReader = new BufferedReader(new FileReader(filename));
				String vline;
				for(int k=0; k < 2+lineNum; k++) {
					vline = vReader.readLine();
				}
				vline = vReader.readLine(); // Vertex line
				if(vline == null) {
					vReader.close();
					throw new WrongFileFormatException("Null vertex line");
				}
				vline = vline.strip();
				
				Matcher vMatch = vStart.matcher(vline);
				if(!vMatch.matches()) {
					vReader.close();
					reader.close();
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
