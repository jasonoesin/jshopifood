package models;

public class Dessert extends Order{

	private Boolean hasHighCalories;
	
	public Dessert(String name, Integer price, Integer prepareDuration, Boolean hasHighCalories) {
		super(name,price,prepareDuration);
		this.hasHighCalories = hasHighCalories;
	}
	public Boolean getHasHighCalories() {
		return hasHighCalories;
	}
	public void setHasHighCalories(Boolean hasHighCalories) {
		this.hasHighCalories = hasHighCalories;
	}
	
}
