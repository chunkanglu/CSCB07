package School;

public class Professor extends Person {
	private Administration administration = Administration.getInstance();
	
	public Professor(int sin, String name) {
		super(sin, name);
		administration.addProfessor(this);
	}
	
	@Override
	public String toString() {
		return "Prof. " + super.toString();
	}
}
