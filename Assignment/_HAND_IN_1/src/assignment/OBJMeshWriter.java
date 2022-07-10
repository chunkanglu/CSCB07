package assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class OBJMeshWriter implements MeshWriter {
	public void write(String filename, HashSet<Polygon> hs) throws IOException {
		// Create LinkedHashSet with all vertices (automatically ignoring duplicates)
		LinkedHashSet<Vertex> lhsVertex = new LinkedHashSet<Vertex>();
		for(Polygon p: hs) {
			for(Vertex v: p.vertices) {
				lhsVertex.add(v);
			}
		}
		// Convert LinkedHashSet to ArrayList to allow for searching of index (of vertex)
		List<Vertex> liVertex = new ArrayList<Vertex>(lhsVertex);
		
		List<String> polyLiVertex = new ArrayList<String>();
		// For each Polygon in hs
		for(Polygon p: hs) {
			// get corresponding indices for the vertices
			// concat them into single string and store in ArrayList
			String indices = "";
			for(Vertex v: p.vertices) {
				// Indices start at 1 for OBJ format
				indices += Integer.toString(liVertex.indexOf(v) + 1) + " ";
			}
			indices = indices.substring(0, indices.length()-1);
			polyLiVertex.add(indices);
		}
		
		FileWriter fw = new FileWriter(filename, false);
			
		// For each vertex in the ArrayList
		for(Vertex v: liVertex) {
			// Write "v" and the toString() version of vertices
			fw.write("v " + v.toString() + System.lineSeparator());
		}
			
		// For each polygon's vertices' indices in its ArrayList
		for(String polyInd: polyLiVertex) {
			// Write "f" and the string 
			fw.write("f " + polyInd + System.lineSeparator());
		}
		
		fw.close();
			
	}
}
