
public class Student {
	String name;
	int grade;
	
	Student(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void print() {
		System.out.println(name + " has " + grade);
	}
	
}
