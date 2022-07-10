package assignment;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.regex.*;

public class OBJMeshReader implements MeshReader {
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException, FileNotFoundException, IOException {
		
		HashSet<Polygon> hs = new HashSet<Polygon>();
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		String prevLine = "";
		
		Pattern fStart = Pattern.compile("^f([\\s]+[\\d]+){3}");
		Pattern vStart = Pattern.compile("^v([\\s]+[\\-]?([\\d]+[\\.])?[\\d]+){3}"); 
		
		while(line != null) {
			line = line.strip();
			
			Matcher fMatchPrev = fStart.matcher(prevLine);
			
			Matcher vMatch = vStart.matcher(line);
			Matcher fMatch = fStart.matcher(line);
			
			// if neither formats match throw error
			if(!line.equals("")) {
				if(!(fMatch.matches() || vMatch.matches())) {
					reader.close();
					throw new WrongFileFormatException("Unrecognized line format");
				}
			}
			
			// If Vertex line below face line throw error 
			if(fMatchPrev.matches() && vMatch.matches()) {
				reader.close();
				throw new WrongFileFormatException("Vertex line below face line");
			}
			
			// Read lines starting with f
			if(fMatch.matches()) {
				// Read specified lines starting with v
				
				// Parse polygon line
				LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
				String[] fArr = line.split("[\\s]+");
				
				// Parse vertices on face line
				for (int i=1; i < 4; i++) {
					
					int lineNum = Integer.parseInt(fArr[i]);
					
					// Read vertex line
					BufferedReader vReader = new BufferedReader(new FileReader(filename));
					String vline;
					for(int j=0; j < lineNum-1; j++) {
						vline = vReader.readLine();
					}
					vline = vReader.readLine();
					if(vline == null) {
						vReader.close();
						throw new WrongFileFormatException("Null vertex line");
					}
					vline = vline.strip();
					
					vMatch = vStart.matcher(vline);
					
					if(!vMatch.matches()) {
						vReader.close();
						throw new WrongFileFormatException("Invalid vertex line");
					}
					
					// Parse doubles on vertex line (rounded to 5 decimal places)
					String[] vArr = vline.split("[\\s]+");
					double x = Double.parseDouble(vArr[1]);
					double y = Double.parseDouble(vArr[2]);
					double z = Double.parseDouble(vArr[3]);
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
			
			prevLine = line;
			line = reader.readLine();
			
		}
		
		reader.close();
		return hs;
	}
}
