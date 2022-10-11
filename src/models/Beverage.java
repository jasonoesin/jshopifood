package models;

public class Beverage extends Order {
	
	private Character size;
	
	public Beverage(String name, Integer price, Integer prepareDuration, Character size) {
		super(name,price,prepareDuration);
		this.size = size;
	}
	
	public Character getSize() {
		return size;
	}
	public void setSize(Character size) {
		this.size = size;
	}
}
