import java.io.File;

public class LsValidateArguments implements IValidateArguments {
	private String[] args;
	
	public LsValidateArguments(String[] args) {
		this.args = args;
	}

	@Override
	public boolean validate() {
		int numArgs = args.length;
		if(numArgs > 2) {
			System.out.println("Too many arguments");
			return false;
		}
		if(numArgs == 2) {
			String filepath = args[1];
			File f = new File(filepath);
			if(!f.exists()) {
				System.out.println("Ivalid filepath");
				return false;
			}
		}
		return true;
	}

}
