package assignment;

public class Vertex extends GraphicalObject{
	double x;
	double y;
	double z;
	
	public Vertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void transform(double matrix[][]) {
		// Calculations rounded to 5 decimal places
		double newX = matrix[0][0]*this.x + matrix[0][1]*this.y + matrix[0][2]*this.z;
		double newY = matrix[1][0]*this.x + matrix[1][1]*this.y + matrix[1][2]*this.z;
		double newZ = matrix[2][0]*this.x + matrix[2][1]*this.y + matrix[2][2]*this.z;
		newX = Math.round(newX * 100000.0) / 100000.0;
		newY = Math.round(newY * 100000.0) / 100000.0;
		newZ = Math.round(newZ * 100000.0) / 100000.0;
		this.x = newX;
		this.y = newY;
		this.z = newZ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Vertex)) return false;
		
		Vertex v = (Vertex) obj;
		if(this.x==v.x && this.y==v.y && this.z==v.z) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)(this.x * this.y * this.z);
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z;
	}
}
