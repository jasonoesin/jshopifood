package models;

import data.Data;

public class Customer {
	
	private Integer id;
	private Order order;
	public Integer patience;
	public Courier courier;
	
	
	public Customer(int id) {
		this.patience = (int)(Math.random()*(60 - 50 + 1) + 50);  
//		this.patience = (int)(Math.random()*(3 - 2 + 1) + 2);  	
		this.id = id;
		
		int index = (int)(Math.random() * Data.kitchen.size());
		this.order = Data.kitchen.get(index);
	}
	
	public void assignCourier() {
		this.courier = new Courier();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
