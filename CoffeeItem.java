package Proj3;
/**
 * this class models a coffee drink object with a given attributes of a drinkItem and coffee drink
 * @author Manuel Beltran
 * **/
public class CoffeeItem extends DrinkItem {
	public String mTemperature;
	public String mSpecialInstructions;
	
	/**
	 * creates a coffee drink with a name,size, flavor, sweetness, milk, temperature, and special instruction
	 */
	public CoffeeItem() {
		super("coffee", "M", "regular", "1", "half-and-half");
		mTemperature = "cold";
		mSpecialInstructions = "none";
	}
	/**
	 * creates a coffee drink with a name,size, flavor, sweetness, milk, temperature, and special instruction
	 * @param size - size of the coffee
	 * @param flavor - flavor of the coffee
	 * @param sweetness - sweetness in tsp
	 * @param milk - milk base of coffee
	 * @param temperature - temperature of drink
	 * @param specialInstructions - special requests for drink
	 */
	
	public CoffeeItem(String size,String flavor, String sweetness, String milk, String temperature, String specialInstructions) {
		super("coffee", size, flavor,  sweetness, milk);
		mTemperature = temperature;
		mSpecialInstructions = specialInstructions;
	}
	
	@Override
	/**
	 * Calculates the cost of the coffee and returns it
	 */
	public double getCost() {
		double cost; 	
		if (getSize()== "S") { cost = 1;}
		else if (getSize() == "M") { cost = 1.50; }
		else {cost = 2;}
		if (mTemperature == "blended") { cost += .25; }
		if (getMilk() != "no milk") { cost += .25; }
		return cost;
	}

	/**
	 * Prints receipt ready coffee details. All attributes of a coffee are displayed.
	 */
	public String toString(){ 
		return ("--" + getFlavor() +" " + getName() + " (" + getSize() + "):\t\t$" + String.format("%.2f",getCost()) +
				"\n\tSweetness: " + getSweetness() + "\n\tMilk:" + getMilk() + "\n\tTemp:" + mTemperature + 
				"\n\tSpecial Instructions: " + mSpecialInstructions);
	}
}
