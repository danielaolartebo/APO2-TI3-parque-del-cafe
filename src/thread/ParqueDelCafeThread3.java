package thread;

import javafx.application.Platform;
import model.ParqueDelCafe;
import ui.ParqueDelCafeGUI;

public class ParqueDelCafeThread3 extends Thread{
	private double x;
	private double y;
	private ParqueDelCafe parking;
	private ParqueDelCafeGUI pdcG;
	
	public ParqueDelCafeThread3(ParqueDelCafe parking, ParqueDelCafeGUI pdcG) {
		this.pdcG=pdcG;
		this.parking=parking;
		
	}
	
	@Override
	public void run() {
		
		Platform.runLater(new Thread() {
			public void run() {
				for(int i=0; i<10;i++) {
					parking.getParking().moveCar();
					pdcG.moveCarParking();
				}
			}
		});
		
	}
	

	
}
