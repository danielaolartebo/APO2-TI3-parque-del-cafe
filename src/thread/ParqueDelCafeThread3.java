package thread;
import model.ParqueDelCafe;


public class ParqueDelCafeThread3 extends Thread{

private ParqueDelCafe pdc;
	
	
	private long sleepTime;
	
	public ParqueDelCafeThread3(ParqueDelCafe pdc, long sleepTime) {
		this.pdc = pdc;
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(18000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		for(int i=0;i < 200;i++) {
			pdc.removePeopleOfGame();
			System.out.println("Esta en el hilo3");
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}
		}
	}
