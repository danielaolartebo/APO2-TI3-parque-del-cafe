package thread;

import model.ParqueDelCafe;
import ui.ParqueDelCafeGUI;

public class ParqueDelCafeThread extends Thread{

	private ParqueDelCafe pdc;
	
	private ParqueDelCafeGUI pdcG;
	
	private long sleepTime;
	
	public ParqueDelCafeThread(ParqueDelCafe pdc, ParqueDelCafeGUI pdcG, long sleepTime) {
		this.pdc = pdc;
		this.pdcG = pdcG;
		this.sleepTime = sleepTime;
	}
	public void run() {
		
		pdc.takeOutFromGame();
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
