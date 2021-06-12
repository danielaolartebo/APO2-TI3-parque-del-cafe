package thread;

import model.ParqueDelCafe;
import ui.ParqueDelCafeGUI;

public class ParqueDelCafeThread2 extends Thread{
	
	private ParqueDelCafe pdc;
	
	private ParqueDelCafeGUI pdcG;
	
	private long sleepTime;
	
	public ParqueDelCafeThread2(ParqueDelCafe pdc, ParqueDelCafeGUI pdcG, long sleepTime) {
		this.pdc = pdc;
		this.pdcG = pdcG;
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		
		for(int i=0;i < 200;i++) {
		pdc.addPeopleToGame();
		System.out.println("Esta en el hilo2");
		pdcG.initializeOccupancyTableView();
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		}
		
	}
}
