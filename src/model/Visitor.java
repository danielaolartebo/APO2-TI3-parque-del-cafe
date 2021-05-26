package model;

public class Visitor {

	private String name;
	
	private String age;
	
	private String gender;
	
	private Visitor nextVisitor;
	
	public Visitor(String name,String age,String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public Visitor getNextVisitor() {
		return nextVisitor;
	}
	public void setNextVisitor(Visitor nextVisitor) {
		this.nextVisitor = nextVisitor;
	}
}
