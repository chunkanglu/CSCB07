import java.io.File;

public class LsCmd implements ICmd{
	private String[] args;
	
	public LsCmd(String[] args) {
		this.args = args;
	}

	@Override
	public void execute() {
		File f;
		if(args.length == 1) {
			f = new File(".");
		}
		else {
			f = new File(args[1]);
		}

		if(f.isFile()) {
			System.out.println(f.getName());
		}
		else if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(File file: files) {
				System.out.println(file.getName());
			}
		}
	}
	
}
