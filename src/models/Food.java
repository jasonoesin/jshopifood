package models;

public class Food extends Order{
	private String type;
	private Boolean isFrozen;
	
	public Food(String name, Integer price, Integer prepareDuration, String type, Boolean isFrozen) {
		super(name,price,prepareDuration);
		this.type = type;
		this.isFrozen = isFrozen;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(Boolean isFrozen) {
		this.isFrozen = isFrozen;
	}
	
}
