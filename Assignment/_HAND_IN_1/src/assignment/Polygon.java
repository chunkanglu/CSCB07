package assignment;

import java.util.LinkedHashSet;

public class Polygon extends GraphicalObject{
	LinkedHashSet<Vertex> vertices;
	
	public Polygon(LinkedHashSet<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public void transform(double matrix[][]) {
		for(Vertex v: this.vertices) {
			v.transform(matrix);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Polygon)) return false;
		Polygon p = (Polygon) obj;
		return this.vertices.equals(p.vertices);
	}
	
	@Override
	public int hashCode() {
		return this.vertices.size();
	}
	
}
