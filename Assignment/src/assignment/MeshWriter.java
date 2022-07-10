package assignment;

import java.io.IOException;
import java.util.HashSet;

public interface MeshWriter {
	public abstract void write(String filename, HashSet<Polygon> hs) throws IOException;
}
