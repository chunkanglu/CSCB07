import java.io.File;

public class CatValidateArguments implements IValidateArguments {
	private String[] args;
	
	public CatValidateArguments(String[] args) {
		this.args = args;
	}

	@Override
	public boolean validate() {
		int numArgs = args.length;
		if(numArgs < 2) {
			System.out.println("Too few arguments");
			return false;
		}
		else if(numArgs > 2) {
			System.out.println("Too many arguments");
			return false;
		}
		String filepath = args[1];
		File f = new File(filepath);
		if(!f.exists()) {
			System.out.println("Ivalid filepath");
			return false;
		}
		return true;
	}

}
