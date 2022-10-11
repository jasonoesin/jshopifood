package models;

public class Prepare {
	
	Order order;
	public Integer time_remaining;
	
	public Prepare(Order o) {
		this.order = o;
		this.time_remaining = o.getPrepareDuration();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getTime_remaining() {
		return time_remaining;
	}

	public void setTime_remaining(Integer time_remaining) {
		this.time_remaining = time_remaining;
	}
	
	
	
	
}
