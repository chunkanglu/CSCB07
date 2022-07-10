package assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public interface MeshReader {
	public abstract HashSet<Polygon> read(String filename) throws FileNotFoundException,WrongFileFormatException,IOException;
}
