package Proj3;
/**
 * this class models a tea object with a given attributes of a tea item
 * @author Manuel Beltran
 * **/
import java.util.ArrayList;

public class TeaItem extends DrinkItem {
	private ArrayList<String> mToppings;
	/**
	 * initializes all fields for tea
	 */
	public TeaItem(){
		super("Tea", "", "", "", "");
		mToppings = new ArrayList<String>();
	}
	/**
	 * sets the size, flavor, name, sweetness, and milk of a tea Item
	 * @param size - size of tea
	 * @param flavor - flavor of tea
	 * @param sweetness - sweetness of tea
	 * @param milk - milk base of tea
	 */
	public TeaItem(String size, String flavor,  String sweetness, String milk) {
		super("Tea", size, flavor,  sweetness, milk);
		mToppings = new ArrayList<String>();
	}
	/**
	 * Adds topping item to toppings arraylist
	 * @param topping - one topping of tea item
	 */
	public void addTopping(String topping) { mToppings.add(topping); }

	@Override
	/**
	 * getter method for cost
	 * @return cost - cost for the drink
	 */
	public double getCost() {
		double cost = getBasePrice(getSize()); 
		if (mToppings.size() != 0) { cost += .25 * mToppings.size(); }
		if (getMilk().equals("no milk")) { cost += .25; }
		return cost;
	}
	/**
	 * calculates the base price and returns it
	 * @param name - name of the tea
	 * @return baseCost - the base price of the tea Item
	 */
	public static double getBasePrice(String name) {
		double baseCost;
		if (name.equals("S")) { baseCost = 2;}
		else if (name.equals("M")) { baseCost = 2.50; }
		else {baseCost = 3;}
		return baseCost;
	}
	
	/**
	 * Prints receipt ready coffee details. All attributes of a coffee are displayed.
	 */
	public String toString(){ 
		return ("--" + getFlavor()  + " (" + getSize() + "):\t\t$" + String.format("%.2f",getCost()) +
				"\n\tSweetness: " + getSweetness() + "\n\tMilk:" + getMilk() + "\n\tToppings:" + mToppings);
	}
}
