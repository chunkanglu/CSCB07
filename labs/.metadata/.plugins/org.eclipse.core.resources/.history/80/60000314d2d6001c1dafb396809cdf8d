package geometry;

public class Point{
	double x;
	double y;

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point other) {
		return Math.pow(x-other.x, 2) + Math.pow(y-other.y, 2);
	}
	
	public boolean isInsideCircle(Point center, double radius) {
		return distance(center) > radius;
	}
}