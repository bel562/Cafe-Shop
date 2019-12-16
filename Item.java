package Proj3;
/**
 * this class models a item object with a given attributes of a purchaseable Item
 * @author Manuel Beltran
 * **/
public abstract class Item {
	private String mName;
	private double mCost;
	
	/**
	 * Item initializes the name and cost
	 */
	public Item() {
		mName = "";
		mCost = 0;
	}
	/**
	 * Item sets the name and cost
	 * @param name - name of the item
	 * @param cost - cost of the item
	 */
	public Item(String name, double cost) {
		mName = name;
		mCost = cost;
	}
	/**
	 * setter method for mName
	 * @param name - name of the Item
	 */
	public void setName(String name) { mName = name; }
	/**
	 * setter method for mCost
	 * @param cost - price of the Item
	 */
	public void setCost(double cost) { mCost = cost; }
	/**
	 * getter method for mName
	 * @return mName - name of the Item
	 */
	public String getName() { return mName; }
	
	public abstract double getCost();
	
	
}
