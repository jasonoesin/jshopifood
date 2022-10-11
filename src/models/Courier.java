package models;

public class Courier {
	
	public int distance;
	public int collecting;
	public String status;
	
	public Courier() {
		this.distance = (int)(Math.random()*(10 - 5 + 1) + 5);
		this.collecting = 3;
		this.status = "C";
	}
	
	public String deliveringState() {
		return "Delivering Order ... ("+ this.distance +"km)";
	}
	
	public String collectingState() {
		return "Collecting Order ... ("+ this.collecting +"s)";
	}
	
	public void deliver() {
		if(collecting != 0) {
			collecting--;
			
			if(collecting == 0)
				this.status = "D";
			return;
		}
		
		this.distance--;
	}
}
