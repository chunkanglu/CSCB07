import java.util.Scanner;

public class Cmd {
	private Scanner scanner;
	private ICmd cmd;
	private IValidateArguments va;
	
	public Cmd(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void getCmd(String[] input) {
		if(input[0].equals("cat")) {
			this.cmd = new CatCmd(input);
			this.va = new CatValidateArguments(input);
		}
		else if(input[0].equals("ls")) {
			this.cmd = new LsCmd(input);
			this.va = new LsValidateArguments(input);
		}
		else if(input[0].equals("exit")) {
			this.cmd = new ExitCmd(scanner);
			this.va = new ExitValidateArguments(input);
		}
		else {
			this.cmd = null;
			System.out.println("Unsupported Command");
		}
	}
	
	public void executeCmd() {
		if(this.cmd != null && va.validate()) {
			this.cmd.execute();
		}
	}
}
