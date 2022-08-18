package School;

import java.util.ArrayList;

public class Course {
	private Administration administration = Administration.getInstance();
	String code;
	Professor professor;
	ArrayList<Student> students;
	EligibleStrategy eligibleStrategy;
	
	public Course(String code, Professor professor, ArrayList<Student> students, EligibleStrategy eligibleStrategy) {
		this.code = code;
		this.professor = professor;
		this.students = students;
		this.eligibleStrategy = eligibleStrategy;
		administration.addCourse(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Course)) return false;
		Course c = (Course) obj;
		return this.code == c.code;
	}
	
	@Override
	public int hashCode() {
		return this.professor.toString().length() + students.size();
	}
	
	public boolean isEligibile(Student s) {
		return eligibleStrategy.isEligibile(s);
	}
	
	public void addStudent(Student s) {
		if(this.isEligibile(s) && !students.contains(s)) {
			students.add(s);
		}
	}
	
	public void displayInfo() {
		System.out.println(this.code);
		System.out.println(this.professor);
		students.sort(null);
		System.out.println(students.toString());
	}
}
