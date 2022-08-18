import java.util.Scanner;

public class UserInput {
	private Scanner scanner;
	
	public UserInput(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public String[] getUserInput() {
		String input = scanner.nextLine();
		return input.split("[\\s]");
	}

}
