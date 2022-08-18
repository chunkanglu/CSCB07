
public class ExitValidateArguments implements IValidateArguments {
private String[] args;
	
	public ExitValidateArguments(String[] args) {
		this.args = args;
	}

	@Override
	public boolean validate() {
		int numArgs = args.length;
		if(numArgs > 1) {
			System.out.println("Too many arguments");
			return false;
		}
		return true;
	}

}
