package geometry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void test1_distance() {
		Point A = new Point(1,1);
		Point B = new Point(2,1);
		assertEquals(A.distance(B), 1);
	}
	
	@Test
	void test2_distance() {
		Point A = new Point(1,1);
		Point B = new Point(3,1);
		assertEquals(A.distance(B), 2);
	}
	
	@Test
	void test_isInsideCircle() {
		Point A = new Point(1,0);
		Point C = new Point(0,0);
		assertTrue(A.isInsideCircle(C, 2));
	}

}
