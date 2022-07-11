package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void newVertex() {
		Vertex v = new Vertex(1, 2, 3);
		assertTrue(v.x==1 && v.y==2 && v.z==3);
	}
	
	@Test
	void vertexEquals() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(1, 2, 3);
		assertTrue(v1.equals(v2));
	}
	
	@Test
	void vertexNotEqualsObj() {
		Vertex v1 = new Vertex(1, 2, 3);
		Object v2 = new Object();
		assertFalse(v1.equals(v2));
	}
	
	@Test
	void vertexNotEqualsNull() {
		Vertex v = new Vertex(1, 2, 3);
		assertFalse(v.equals(null));
	}
	
	@Test
	void vertexNotEqualsVertex() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(2, 2, 3);
		assertFalse(v1.equals(v2));
	}
	
	@Test
	void vertexHashEqual() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(1, 2, 3);
		assertTrue(v1.hashCode() == v2.hashCode());
	}
	
	@Test
	void vertexHashNotEqual() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(2, 2, 3);
		assertFalse(v1.hashCode() == v2.hashCode());
	}
	
	@Test
	void vertexToString() {
		Vertex v = new Vertex(1, 2, 3);
		String s = v.toString();
		assertTrue(s.equals("1.0 2.0 3.0"));
	}
	
	@Test
	void polygonEquals() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(4, 5, 6);
		Vertex v3 = new Vertex(7, 8, 9);
		LinkedHashSet<Vertex> l = new LinkedHashSet<Vertex>();
		l.add(v1); l.add(v2); l.add(v3);
		Polygon p1 = new Polygon(l);
		Polygon p2 = new Polygon(l);
		assertTrue(p1.equals(p2));
	}
	
	@Test
	void polygonNotEqualsObj() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(4, 5, 6);
		Vertex v3 = new Vertex(7, 8, 9);
		LinkedHashSet<Vertex> l = new LinkedHashSet<Vertex>();
		l.add(v1); l.add(v2); l.add(v3);
		Polygon p1 = new Polygon(l);
		Object o = new Object();
		assertFalse(p1.equals(o));
	}
	
	@Test
	void polygonNotEqualsNull() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(4, 5, 6);
		Vertex v3 = new Vertex(7, 8, 9);
		LinkedHashSet<Vertex> l = new LinkedHashSet<Vertex>();
		l.add(v1); l.add(v2); l.add(v3);
		Polygon p1 = new Polygon(l);
		assertFalse(p1.equals(null));
	}
	
	@Test
	void polygonNotEqualsPolygon() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(4, 5, 6);
		Vertex v3 = new Vertex(7, 8, 9);
		LinkedHashSet<Vertex> l1 = new LinkedHashSet<Vertex>();
		LinkedHashSet<Vertex> l2 = new LinkedHashSet<Vertex>();
		l1.add(v1); l1.add(v2); l1.add(v3);
		l2.add(v1); l2.add(v2);
		Polygon p1 = new Polygon(l1);
		Polygon p2 = new Polygon(l2);
		assertFalse(p1.equals(p2));
	}
	
	@Test
	void polygonHashEquals() {
		Vertex v1 = new Vertex(1, 2, 3);
		Vertex v2 = new Vertex(4, 5, 6);
		Vertex v3 = new Vertex(7, 8, 9);
		LinkedHashSet<Vertex> l = new LinkedHashSet<Vertex>();
		l.add(v1); l.add(v2); l.add(v3);
		Polygon p1 = new Polygon(l);
		Polygon p2 = new Polygon(l);
		assertTrue(p1.hashCode() == p2.hashCode());
	}
	
	@Test
	void meshEquals() throws WrongFileFormatException, IOException {
		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/box.obj");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("./test_files/box.obj");

		assertTrue(mesh1.equals(mesh2));
	}
	
	@Test
	void meshNotEqualsObj() throws WrongFileFormatException, IOException {
		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/box.obj");
		
		Object o = new Object();

		assertFalse(mesh1.equals(o));
	}
	
	@Test
	void meshNotEqualsNull() throws WrongFileFormatException, IOException {
		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/box.obj");

		assertFalse(mesh1.equals(null));
	}
	
	@Test
	void meshNotEqualsMesh() throws WrongFileFormatException, IOException {
		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/box.obj");
		
		Mesh mesh2 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/boxHalf.obj");

		assertFalse(mesh1.equals(mesh2));
	}
	
	@Test
	void meshHashEquals() throws WrongFileFormatException, IOException {
		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile("./test_files/box.obj");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("./test_files/box.obj");

		assertTrue(mesh1.hashCode() == mesh2.hashCode());
	}
	
	// Transform
	
	@Test
	void objTransformX() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("./test_files/boxHalf.obj");
		mesh.rotateXAxis(Math.PI);
		mesh.rotateYAxis(0);
		mesh.rotateZAxis(0);
//		mesh.setWriter(new OBJMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiXActual.obj");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new OBJMeshReader());
		meshExpected.readFromFile("./test_files/boxHalfRotPiX.obj");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	@Test
	void plyTransformY() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile("./test_files/boxHalf.ply");
		mesh.rotateYAxis(Math.PI);
		mesh.rotateXAxis(0);
		mesh.rotateZAxis(0);
//		mesh.setWriter(new PLYMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiYActual.ply");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new PLYMeshReader());
		meshExpected.readFromFile("./test_files/boxHalfRotPiY.ply");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	@Test
	void offTransformZ() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		mesh.readFromFile("./test_files/boxHalf.off");
		mesh.rotateZAxis(Math.PI);
		mesh.rotateXAxis(0);
		mesh.rotateYAxis(0);
//		mesh.setWriter(new OFFMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiZActual.off");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new OFFMeshReader());
		meshExpected.readFromFile("./test_files/boxHalfRotPiZ.off");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	@Test
	void objTransformXEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("./test_files/boxHalf.obj");
		mesh.rotateXAxis(Math.PI);
//		mesh.setWriter(new OBJMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiXActual.obj");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("./test_files/boxHalf.obj");
		mesh2.rotateXAxis(Math.PI);
		
		assertTrue(mesh.equals(mesh2));
	}
	
	@Test
	void objTransformXEquals2() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("./test_files/boxHalf.obj");
//		mesh.rotateXAxis(Math.PI);
//		mesh.setWriter(new OBJMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiXActual.obj");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("./test_files/boxHalf.obj");
		mesh2.rotateXAxis(2*Math.PI);
		
		assertTrue(mesh.equals(mesh2));
	}
	
	@Test
	void plyTransformYEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile("./test_files/boxHalf.ply");
		mesh.rotateYAxis(Math.PI);
//		mesh.setWriter(new PLYMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiYActual.ply");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new PLYMeshReader());
		mesh2.readFromFile("./test_files/boxHalf.ply");
		mesh2.rotateYAxis(Math.PI);
		
		assertTrue(mesh.equals(mesh2));
	}
	
	@Test
	void offTransformZEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		mesh.readFromFile("./test_files/boxHalf.off");
		mesh.rotateZAxis(Math.PI);
//		mesh.setWriter(new OFFMeshWriter());
//		mesh.writeToFile("./test_files/boxHalfRotPiZActual.off");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OFFMeshReader());
		mesh2.readFromFile("./test_files/boxHalf.off");
		mesh2.rotateZAxis(Math.PI);
		
		assertTrue(mesh.equals(mesh2));
	}
	
	// Write Equals
	
	@Test
	void objWriteEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("./test_files/boxHalf.obj");
		mesh.setWriter(new OBJMeshWriter());
		mesh.writeToFile("./test_files/boxHalfWrite.obj");
		mesh.readFromFile("./test_files/boxHalfWrite.obj");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new OBJMeshReader());
		meshExpected.readFromFile("./test_files/boxHalf.obj");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	@Test
	void plyWriteEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile("./test_files/boxHalf.ply");
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile("./test_files/boxHalfWrite.ply");
		mesh.readFromFile("./test_files/boxHalfWrite.ply");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new PLYMeshReader());
		meshExpected.readFromFile("./test_files/boxHalf.ply");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	@Test
	void offWriteEquals() throws WrongFileFormatException, IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		mesh.readFromFile("./test_files/boxHalf.off");
		mesh.setWriter(new OFFMeshWriter());
		mesh.writeToFile("./test_files/boxHalfWrite.off");
		mesh.readFromFile("./test_files/boxHalfWrite.off");
		
		Mesh meshExpected = new Mesh();
		meshExpected.setReader(new OFFMeshReader());
		meshExpected.readFromFile("./test_files/boxHalf.off");
		
		assertTrue(mesh.equals(meshExpected));
	}
	
	// -------------------------------------------------------------------
	// OBJ Reader
	
	@Test
	void objReaderNotVOrF() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail1.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Unrecognized line format")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderVAfterF() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail2.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Vertex line below face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderInvalidFaceNullVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail3.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderFaceIndexPointsFaceInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail4.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderNoVertexInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail5.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderExtraLinesEndNotVOrF() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objFail6.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Unrecognized line format")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void objReaderExtraEmptyLinesEnd() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objPass1.obj");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Unrecognized line format")) {
				error = true;
			}
		}
		assertFalse(error);
	}
	
	@Test
	void objReaderWhitespaceSeparation() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		try {
			mesh.readFromFile("./test_files/objPass2.obj");
		}
		catch (WrongFileFormatException e) {
			error = true;
		}
		assertFalse(error);
	}
	
	// -------------------------------------------------------------------
	// PLY Reader
	
	@Test
	void plyReaderEmptyFileNullHeader() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/emptyFile.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null header line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderInvalidHeader() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail1.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid header")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderLessFaceListedNullFace() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail2.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderFailRegexInvalidFace() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail3.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderMoreFaceThanListed() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail4.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("More lines than listed")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderEmptyLinesBottom() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyPass1.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("More lines than listed")) {
				error = true;
			}
		}
		assertFalse(error);
	}
	
	@Test
	void plyReaderInvalidIndexNullVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail5.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderNoVertexInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail6.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderFailRegexInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail7.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderLessVertexInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyFail8.ply");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void plyReaderWhitespaceSeparation() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		try {
			mesh.readFromFile("./test_files/plyPass2.ply");
		}
		catch (WrongFileFormatException e) {
			error = true;
		}
		assertFalse(error);
	}
	
	// -------------------------------------------------------------------
	// OFF Reader
	
	@Test
	void offReaderEmptyFileNullOFF() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/emptyFile.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null OFF line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderInvalidOFF() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail1.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid OFF start")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderNullHeader() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail2.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null header line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderInvalidHeader() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail3.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid header line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderLessFaceThanListedNullFace() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail4.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderFailRegexInvalidFace() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail5.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderMoreVertexThanListedInvalidFace() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail6.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid face line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderInvalidRGB() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail7.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid RGB values")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderMoreFaceThanListed() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail8.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("More lines than listed")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderEmptyLinesBottom() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offPass1.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("More lines than listed")) {
				error = true;
			}
		}
		assertFalse(error);
	}
	
	@Test
	void offReaderInvalidVertexIndexNullVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail9.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Null vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderLessVertexThanListedInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail10.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderFailRegexInvalidVertex() throws IOException {
		boolean correctException = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offFail11.off");
		}
		catch (WrongFileFormatException e) {
			if(e.message.equals("Invalid vertex line")) {
				correctException = true;
			}
		}
		assertTrue(correctException);
	}
	
	@Test
	void offReaderWhitespaceSeparation() throws IOException {
		boolean error = false;
		Mesh mesh = new Mesh();
		mesh.setReader(new OFFMeshReader());
		try {
			mesh.readFromFile("./test_files/offPass2.off");
		}
		catch (WrongFileFormatException e) {
			error = true;
		}
		assertFalse(error);
	}
	
}
