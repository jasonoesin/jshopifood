package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import models.*;

public class Data {
	static Scanner in = new Scanner(System.in);
	
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static ArrayList<Order> kitchen = new ArrayList<Order>();
	public static ArrayList<Order> ready = new ArrayList<Order>();
	public static Integer totalMoneyEarned = 0;
	
	private static Integer id = 1; // CustomerID 
	public static Integer timer = 0;
	private static boolean inMain = true;
	public static ArrayList<Prepare> cook = new ArrayList<Prepare>();
	
	public synchronized static boolean getInMain() {
		return inMain;
	}
	
	public synchronized static void setInMain(boolean b) {
		inMain = b;
	}
	
	public synchronized static ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public synchronized static void addOrder(Order o) {
		kitchen.add(o);
	}
	
	public synchronized static void prepare(Prepare p) {
		cook.add(p);
	}
	
	public synchronized static void addCustomer() {
		
		if(customers.size() < 3)
			customers.add(new Customer(id++));
	}
	
	public synchronized static void decreaseCourier() {
		if(customers.isEmpty())
			return;
		
		Iterator<Customer> it = customers.iterator();
		
		while(it.hasNext()) {
			Customer c = it.next();
			
			if(c.courier != null) {
				c.courier.deliver();
				
				if(c.courier.distance == 0) {
					totalMoneyEarned += c.getOrder().getPrice();
					it.remove();
				}
			}
		}
	}
	
	public synchronized static void decreasePatience() {
		
		Iterator<Customer> it = customers.iterator();
		
		while(it.hasNext()) {
			Customer c = it.next();
			c.patience--;
			
			if(c.patience == 0) {
				
				for(int i = 0; i < 32 ;i++)
					System.out.println("");
				
				System.out.println("\tCustomer "+c.getId() +" has canceled the order ...");
				Data.inMain = false;
				System.out.println("\tPress enter to continue ...");
				it.remove();
			}
				
		}
	}
	
	public synchronized static void decreasePrepareTime() {
		
		Iterator<Prepare> it = cook.iterator();
		
		while(it.hasNext()) {
			Prepare c = it.next();
			c.time_remaining--;
			
			if(c.time_remaining == 0) {
				ready.add(c.getOrder());
				it.remove();
			}
				
		}
	}

}
