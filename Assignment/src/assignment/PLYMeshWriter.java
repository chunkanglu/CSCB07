package assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class PLYMeshWriter implements MeshWriter {
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
				indices += Integer.toString(liVertex.indexOf(v)) + " ";
			}
			indices = indices.substring(0, indices.length()-1);
			polyLiVertex.add(indices);
		}
		
		FileWriter fw = new FileWriter(filename, false);
		fw.write("ply" + System.lineSeparator());
		fw.write("format ascii 1.0" + System.lineSeparator());
		fw.write("element vertex " + Integer.toString(liVertex.size()) + System.lineSeparator());
		fw.write("property float32 x" + System.lineSeparator());
		fw.write("property float32 y" + System.lineSeparator());
		fw.write("property float32 z" + System.lineSeparator());
		fw.write("element face " + Integer.toString(polyLiVertex.size()) + System.lineSeparator());
		fw.write("property list uint8 int32 vertex_indices" + System.lineSeparator());
		fw.write("end_header" + System.lineSeparator());
		
		for(Vertex v: liVertex) {
			fw.write(v.toString() + System.lineSeparator());
		}
		
		for(String polyInd: polyLiVertex) {
			fw.write("3 " + polyInd + System.lineSeparator());
		}
		
		fw.close();
	}
}
