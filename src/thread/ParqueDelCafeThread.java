package thread;

import model.ParqueDelCafe;
import ui.ParqueDelCafeGUI;

public class ParqueDelCafeThread extends Thread{

	private ParqueDelCafe pdc;
	
	private ParqueDelCafeGUI pdcG;
	
	private long sleepTime;
	
	public ParqueDelCafeThread(ParqueDelCafe pdc, ParqueDelCafeGUI pdcG, long sleepTime) {
		this.pdc = pdc;
		this.setPdcG(pdcG);
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		for(int i=0; i < 200;i++) {
			System.out.println("Entro al Hilo 1");
		pdc.takeOutFromGame();
		try {
			
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	public ParqueDelCafeGUI getPdcG() {
		return pdcG;
	}
	public void setPdcG(ParqueDelCafeGUI pdcG) {
		this.pdcG = pdcG;
	}
}
