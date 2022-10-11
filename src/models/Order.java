package models;

public class Order {
	private String name;
	private Integer price;
	private Integer prepareDuration;
	
	public Order(String name, Integer price, Integer prepareDuration) {
		super();
		this.name = name;
		this.price = price;
		this.prepareDuration = prepareDuration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrepareDuration() {
		return prepareDuration;
	}

	public void setPrepareDuration(Integer prepareDuration) {
		this.prepareDuration = prepareDuration;
	}

}
