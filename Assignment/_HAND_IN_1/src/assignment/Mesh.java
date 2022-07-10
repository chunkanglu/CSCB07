package assignment;

import java.io.IOException;
import java.util.HashSet;

public class Mesh extends GraphicalObject{
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	public void setReader(MeshReader reader) {
		this.reader = reader;
	}
	
	public void setWriter(MeshWriter writer) {
		this.writer = writer;
	}
	
	public void readFromFile(String filename) throws IOException, WrongFileFormatException {
		this.polygons = this.reader.read(filename);
	}
	
	public void writeToFile(String filename) throws IOException{
		this.writer.write(filename, polygons);
	}
	
	@Override
	public void transform(double matrix[][]) {
		for(Polygon p: polygons) {
			p.transform(matrix);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Mesh)) return false;
		Mesh m = (Mesh) obj;
		return this.polygons.equals(m.polygons);
	}
	
	@Override
	public int hashCode() {
		return this.polygons.size();
	}

}
