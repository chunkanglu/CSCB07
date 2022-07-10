package assignment;

import java.lang.Math;

public abstract class GraphicalObject {
	public abstract void transform(double matrix[][]);
	
	public void rotateXAxis(double theta) {
		double cosTheta = Math.cos(theta);
		double sinTheta = Math.sin(theta);
		
		double rotateMat[][] = {{1,0,0}, {0,cosTheta,(-1)*sinTheta}, {0,sinTheta,cosTheta}};
		this.transform(rotateMat);
	}
	
	public void rotateYAxis(double theta) {
		double cosTheta = Math.cos(theta);
		double sinTheta = Math.sin(theta);
		
		double rotateMat[][] = {{cosTheta,0,sinTheta}, {0,1,0}, {(-1)*sinTheta,0,cosTheta}};
		this.transform(rotateMat);
	}
	
	public void rotateZAxis(double theta) {
		double cosTheta = Math.cos(theta);
		double sinTheta = Math.sin(theta);
		
		double rotateMat[][] = {{cosTheta,(-1)*sinTheta,0}, {sinTheta,cosTheta,0}, {0,0,1}};
		this.transform(rotateMat);
	}
}
