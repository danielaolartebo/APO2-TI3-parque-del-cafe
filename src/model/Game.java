package model;

public class Game{

	private String name;
	private int occupancy;
	private Visitor visitors;
	
	private Game nextGame;
	
	public Game(String name) {
		this.name = name;
	}
	public Game getnextGame() {
		return nextGame;
	}
	public void setNextGame(Game nextGame) {
		this.nextGame = nextGame;
	}
}
