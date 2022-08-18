import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class CatCmd implements ICmd{
	private String[] args;
	
	public CatCmd(String[] args) {
		this.args = args;
	}
	
	@Override
	public void execute() {
		File f = new File(args[1]);
		if(f.isFile()) {
			try {
				BufferedReader b = new BufferedReader(new FileReader(args[1]));
				String str = b.readLine();
				while(str != null) {
					System.out.println(str);
				    str = b.readLine();
				}
				b.close();
			}
			catch(IOException e) {
				System.out.println("Error occured in reading file");
			}
		}
		else if(f.isDirectory()) {
			System.out.println(args[1] + " is a directory");
		}
	}
}
