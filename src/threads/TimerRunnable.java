package threads;

import data.Data;

public class TimerRunnable implements Runnable{

	int timer = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Data.addCustomer();
		while(true)
		{
			timer++;
			Data.timer = timer;
			Data.decreasePatience();
			Data.decreasePrepareTime();
			Data.decreaseCourier();
			
			if(timer % 15 == 0) {
				//Customer Add
				Data.addCustomer();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
	public int getTimer() {
		return timer;
	}
}
