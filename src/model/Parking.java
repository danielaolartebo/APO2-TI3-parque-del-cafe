package model;

public class Parking {
	
	private double x;
	private double y;
	
	public Parking(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void moveCar() {
		x=x+10;
	}
	
	public void posCar(double x, double y) {
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
