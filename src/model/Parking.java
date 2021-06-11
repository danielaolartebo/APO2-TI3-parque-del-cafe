package model;

public class Parking {
	private int parkingNumber;
	private int occupancy;
	private double x;
	private double y;
	private Visitor visitors;
	
	public Parking(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void moveCar(int posX, int posY) {
		x=posX;
		y=posY;
	}
	
	
	
}
