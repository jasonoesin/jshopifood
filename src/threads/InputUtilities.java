package threads;

import java.util.ArrayList;
import java.util.Scanner;

import data.Data;
import models.Beverage;
import models.Dessert;
import models.Food;
import models.Order;
import models.Prepare;

public class InputUtilities implements Runnable{

	boolean isRunning;
	Scanner in = new Scanner(System.in);
	
	
	@Override
	public void run() {
		isRunning = true;
		while(isRunning) {
			
			String temp = in.nextLine();
			
			if(!Data.getInMain()) {
				Data.setInMain(true);
				continue;
			}
			
			
			if(temp.equalsIgnoreCase("P")) {
				prep();
			}
			if(temp.equalsIgnoreCase("A")) {
				assign();
			}
			if(temp.equalsIgnoreCase("E")) {
				OutputUtilities.exitLogo();
			}
			
			
		}
	}
	public void assign() {
		Data.setInMain(false);
		
		String temp;
		int inp = -1;
		
		if(Data.ready.size() == 0) {
			for(int i = 0; i < 50 ;i++)
				System.out.println("");
			
			System.out.println("\tThere are no orders ready to serve");
			System.out.println("\tPress enter continue ...");
			return;
		}
		
		if(Data.getCustomers().size() == 0) {
			for(int i = 0; i < 50 ;i++)
				System.out.println("");
			
			System.out.println("\tThere are no customers");
			System.out.println("\tPress enter continue ...");
			return;
		}
		
		OutputUtilities.showReady();
		
		
		
		do {
			temp = in.nextLine();
			try {
				inp = Integer.parseInt(temp);
			} catch (Exception e) {
			}
			
			if(inp == 0) {
				Data.setInMain(true);
				return;
			}
			
			if((inp < 1 || inp > Data.ready.size())) {
				OutputUtilities.showReady();
			}
			
		} while (inp < 1 || inp > Data.ready.size());
		
		
		int cus = -1;
		
		while(true) {
			int size = OutputUtilities.showCustomers();
			temp = in.nextLine();
			
			try {
				cus = Integer.parseInt(temp);
			} catch (Exception e) {
				break;
			}
			
			if(cus == 0) {
				Data.setInMain(true);
				return;
			}
			
			if(cus >= 1 && cus <= size) {
				if(Data.getCustomers().get(cus - 1).getOrder().getName().equals(Data.ready.get(inp - 1).getName())) {
					if(Data.getCustomers().get(cus - 1).courier == null) {
						Data.getCustomers().get(cus - 1).assignCourier();
						Data.ready.remove(inp - 1);
					}
				}
				else {
					Data.setInMain(false);
					
					OutputUtilities.orderDoesntMatch();
					in.nextLine();
					
					Data.setInMain(true);
				}
				break;
			}
		}
		
		
		
		Data.setInMain(true);
	}
	
	public void prep() {
		Data.setInMain(false);
		
		ArrayList<Prepare> cook = Data.cook;
		
		if(cook.size() == 3) {
			for(int i = 0; i < 50 ;i++)
				System.out.println("");
			
			System.out.println("\tKitchen is currently busy");
			System.out.println("\tPress enter continue ...");
			return;
		}
		
		
		String temp;
		
		do {
			OutputUtilities.showMenu();
			temp = in.nextLine();
			
			if(temp.equals("0")) {
				Data.setInMain(true);
				return;
			}
			
		} while (!temp.equalsIgnoreCase("1") 
				&& !temp.equalsIgnoreCase("2")
				&& !temp.equalsIgnoreCase("3"));
		
		int size = 0, inp = -1;
		if(temp.equals("1")) {
			size = OutputUtilities.showFood();
			
			do {
				temp = in.nextLine();
				
				try {
					inp = Integer.parseInt(temp);
				} catch (Exception e) {
				}
				
				if(inp == 0) {
					Data.setInMain(true);
					return;
				}
				
				if((inp < 1 || inp > size)) {
					OutputUtilities.showFood();
				}
				
			} while (inp < 1 || inp > size);
			
			int idx = 0;
			for (Order o : Data.kitchen) {
				if(o instanceof Food) {
					idx++;
					if(idx == inp) {
						Data.prepare(new Prepare(o));
					}
				}
			}
		}
		else if(temp.equals("2")) {
			size = OutputUtilities.showBeverage();
			
			do {
				temp = in.nextLine();
				
				try {
					inp = Integer.parseInt(temp);
				} catch (Exception e) {
				}
				
				if(inp == 0) {
					Data.setInMain(true);
					return;
				}
				
				if((inp < 1 || inp > size)) {
					OutputUtilities.showBeverage();
				}
				
			} while (inp < 1 || inp > size);
			
			int idx = 0;
			for (Order o : Data.kitchen) {
				if(o instanceof Beverage) {
					idx++;
					if(idx == inp) {
						Data.prepare(new Prepare(o));
					}
				}
			}
		}
		else if(temp.equals("3")) {
		size = OutputUtilities.showDessert();
		
		do {
			temp = in.nextLine();
			
			try {
				inp = Integer.parseInt(temp);
			} catch (Exception e) {
			}
			
			if(inp == 0) {
				Data.setInMain(true);
				return;
			}
			
			if((inp < 1 || inp > size)) {
				OutputUtilities.showDessert();
			}
			
		} while (inp < 1 || inp > size);
		
		int idx = 0;
		for (Order o : Data.kitchen) {
			if(o instanceof Dessert) {
				idx++;
				if(idx == inp) {
					Data.prepare(new Prepare(o));
				}
			}
		}
	}
		
		Data.setInMain(true);
	}

}
