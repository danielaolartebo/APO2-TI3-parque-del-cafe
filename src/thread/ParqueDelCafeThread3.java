package thread;

import model.Parking;

public class ParqueDelCafeThread3 extends Thread{
	private double x;
	private double y;
	private Parking parking;
	
	public ParqueDelCafeThread3(double x, double y) {
		this.x=x;
		this.y=y;
		parking = new Parking(x,y);
	}
	
	@Override
	public void run() {
		
	}
	
	public synchronized void moveCar() {
		
	}
	
}
