package School;

import java.util.ArrayList;

public class Course {
	String code;
	Professor professor;
	ArrayList<Student> students;
	
	public Course(String code, Professor professor, ArrayList<Student> students) {
		this.code = code;
		this.professor = professor;
		this.students = students;
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
		return s.passedCSCA48 && (s.cgpa >= 3.5) && s.inCSCPOSt && (!s.passedCSC207);
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
