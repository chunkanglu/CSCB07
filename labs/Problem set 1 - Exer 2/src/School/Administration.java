package School;

import java.util.LinkedHashSet;

final public class Administration {
	private static Administration administration;
	private LinkedHashSet<Professor> professors;
	private LinkedHashSet<Student> students;
	private LinkedHashSet<Course> courses;
	
	private Administration() {
		this.professors = new LinkedHashSet<Professor>();
		this.students = new LinkedHashSet<Student>();
		this.courses = new LinkedHashSet<Course>();
	}
	
	public static Administration getInstance() {
		if(administration == null) {
			administration = new Administration();
		}
		return administration;
	}
	
	public void addProfessor(Professor p) {
		this.professors.add(p);
	}
	public void addStudent(Student s) {
		this.students.add(s);
	}
	public void addCourse(Course c) {
		this.courses.add(c);
	}
}
