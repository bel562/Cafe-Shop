package Proj3;
/**
 * this class models a pastry object with a given attributes of a pastry
 * @author Manuel Beltran
 * **/
public class Pastry extends Item{
	private String mFlavor;
	private boolean mIsHeated;
	private static final double HEAT_PRICE = .25;
	
	/**
	 * initiales all fields for pastry
	 */
	public Pastry(){
		super("", 0);
		mFlavor = "";
		mIsHeated = false;
	}
	
	/**
	 * sets all fields of pastry
	 * @param name - name of the pastry
	 * @param flavor - flavor of the pastry
	 * @param isHeated - boolean determining if heated
	 */
	public Pastry(String name, String flavor, boolean isHeated) {
		super(name, 0);
		mFlavor = flavor;
		mIsHeated = isHeated;
	}
	
	@Override
	/**
	 * getter method for the cost of pastry 
	 */
	public double getCost() {
		double cost = getPrice(getName(), mFlavor);
		if (mIsHeated) { cost += HEAT_PRICE;}		
		return cost;
	}
	/**
	 * determines the base price a pastry and flavor
	 * @param name - name of the pastry
	 * @param flavor - flavor of the pastry
	 * @return price - total cost of that pastry
	 */
	public static double getPrice(String name, String flavor) {
		double price;
		if (name.equals("cookie")) { price = 1.5; }
		if (name.equals("muffin")) { price = 2; }
		if (name.equals("danish")) { price = 2.5; }
		else {
			if ( flavor.equals("regular")) { price = 4; }
			else if (flavor.equals("cherry")) { price = 4.5; }
			else { price = 4.5; }
		}
		return price;
	}
	/**
	 * Prints all attributes of a pastry.
	 */
	public String toString(){ 
		if (mIsHeated) {
			return ("--" + getName()  + " (heated):\t\t" + String.format("%.2f",getCost()) +
					"\n\t" + mFlavor);
		}
		return ("--" + getName()  + "\t\t$" + String.format("%.2f",getCost()) +
				"\n\t" + mFlavor);
	}
}
