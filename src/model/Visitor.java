package model;

public class Visitor {

	private String name;
	
	private String age;
	
	private String gender;
	
	private String plan;
	
	private Visitor nextVisitor;
	
	public Visitor(String name,String age,String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		plan = " ";
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
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public void setManyPlans(String newPlan) {
		
		if(plan=="") {
			
			setPlan(newPlan);
			
		}else {
			plan+= ", " + newPlan;
			System.out.println("Llego aqui" + plan);
		}
		
	}
}
