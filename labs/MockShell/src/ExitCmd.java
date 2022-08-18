import java.util.Scanner;

public class ExitCmd implements ICmd{
	private Scanner scanner;
	
	public ExitCmd(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void execute() {
		scanner.close();
		System.exit(0);
	}
}
