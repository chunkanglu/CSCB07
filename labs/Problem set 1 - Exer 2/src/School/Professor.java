package School;

public class Professor extends Person {
	public Professor(int sin, String name) {
		super(sin, name);
	}
	
	@Override
	public String toString() {
		return "Prof. " + super.toString();
	}
}
