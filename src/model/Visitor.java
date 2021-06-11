package model;

public class Visitor {

	private String name;
	
	private String age;
	
	private String gender;
	
	private String plan;
	
	private Boolean playing;
	
	private long code;
	
	private Visitor nextVisitor;
	
	private Visitor nextVisitorInGame;
	
	private Game inGame;
	
	public Visitor(String name,String age,String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		playing = false;
		inGame = null;
		code = (long)((Math.random()*(1000000-00000001))+00000001);
		
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
		
		if(plan==null) {
			
			//setPlan(newPlan);
			plan = newPlan;
	
		}else {
			plan+= ", " + newPlan;
			
		}
		
	}
	public Visitor getNextVisitorInGame() {
		return nextVisitorInGame;
	}
	public void setNextVisitorInGame(Visitor nextVisitorInGame) {
		this.nextVisitorInGame = nextVisitorInGame;
	}
	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}
	public Boolean getPlaying() {
		return playing;
	}
	public void setInGame(Game newGame) {
		inGame = newGame;
	}
	public Game getInGame() {
		return inGame;
	}
	public long getCode() {
		return code;
	}
}
