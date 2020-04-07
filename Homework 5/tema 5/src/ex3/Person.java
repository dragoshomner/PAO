package ex3;

public class Person {
	private String firstName;
	private String secondName;
	private int age;
	
	public Person(String firstName, String secondName, int age) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	public boolean isMinor() {
		return age < 18;
	}
	
	@Override 
	public String toString() {
		return firstName + " " + secondName + " " + age;
	}
}
