package model;

public class Game{

	private String name;
	private int occupancy;
	private int position;
	private Visitor visitors;
	
	private Game withLessOccupancy;
	private Game withMoreOccupancy;
	
	private Game nextGame;
	
	public Game(String name,int position) {
		this.name = name;
		occupancy = 0;
		this.position = position;
		withLessOccupancy = null;
		withMoreOccupancy = null;
	}
	public Game getnextGame() {
		return nextGame;
	}
	public void setNextGame(Game nextGame) {
		this.nextGame = nextGame;
	}
	public Visitor getVisitors() {
		return visitors;
	}
	public void setVisitors(Visitor visitors) {
		this.visitors = visitors;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Game getWithLessOccupancy() {
		return withLessOccupancy;
	}
	public void setWithLessOccupancy(Game withLessOccupancy) {
		this.withLessOccupancy = withLessOccupancy;
	}
	public Game getWithMoreOccupancy() {
		return withMoreOccupancy;
	}
	public void setWithMoreOccupancy(Game withMoreOccupancy) {
		this.withMoreOccupancy = withMoreOccupancy;
	}
	
}
