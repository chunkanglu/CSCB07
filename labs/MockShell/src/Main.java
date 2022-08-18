import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserInput ui = new UserInput(scanner);
		Cmd cmd = new Cmd(scanner);
		while(true) {
			String[] input = ui.getUserInput();
			cmd.getCmd(input);
			cmd.executeCmd();
		}

	}

}
