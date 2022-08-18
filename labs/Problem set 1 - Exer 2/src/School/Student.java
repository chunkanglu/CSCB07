package School;

public class Student extends Person implements Comparable<Student> {
	private Administration administration = Administration.getInstance();
	double cgpa;
	boolean inCSCPOSt;
	boolean passedCSCA48;
	boolean passedCSC207;
	
	public Student(int sin, String name, double cgpa, boolean inCSCPOSt, boolean passedCSCA48, boolean passedCSC207) {
		super(sin, name);
		this.cgpa = cgpa;
		this.inCSCPOSt = inCSCPOSt;
		this.passedCSCA48 = passedCSCA48;
		this.passedCSC207 = passedCSC207;
		administration.addStudent(this);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", cgpa: " + this.cgpa;
	}

	@Override
	public int compareTo(Student o) {
		String thisName = this.toString().split(",")[0];
		String otherName = o.toString().split(",")[0];
		if(thisName == otherName) {
			if(this.cgpa > o.cgpa) return 1;
			else if(this.cgpa < o.cgpa) return -1;
			return 0;
		}
		return this.compareName(o);
	}
	
}
