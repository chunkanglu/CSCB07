package School;

public abstract class Person {
	private int sin;
	private String name;
	
	public Person(int sin, String name) {
		this.sin = sin;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Person)) return false;
		Person p = (Person) obj;
		return this.sin == p.sin;
	}
	
	@Override
	public int hashCode() {
		return this.sin + 42069;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public int compareName(Person p) throws IllegalArgumentException{
		if(p == null) throw new IllegalArgumentException();
		return this.name.compareTo(p.name);
	}
}
