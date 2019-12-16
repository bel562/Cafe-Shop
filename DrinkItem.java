package Proj3;
/**
 * this class models a drink object with a given attributes of a drink Item
 * @author Manuel Beltran
 * **/
public abstract class DrinkItem extends Item {
	private String mSize;
	private String mFlavor;
	private String mSweetness;
	private String mMilk;
	/**
	 * creates a drink item with a name,size, flavor, sweetness, milk
	 */
	public DrinkItem() {
		super("", 0);
		mSize = "";
		mFlavor = "";
		mSweetness = "";
		mMilk = "";		
	}
	
	/**
	 * creates a drink item with a name,size, flavor, sweetness, milk
	 * @param name -  name of the drink
	 * @param size - size of the drink
	 * @param flavor - flavor of the drink
	 * @param sweetness - sweetness level of the drink
	 * @param milk - milk base of the drink
	 */
	public DrinkItem(String name, String size,String flavor, String sweetness, String milk) {
		super(name, 0);
		mSize = size;
		mFlavor = flavor;
		mSweetness = sweetness;
		mMilk = milk;
	}

	/**
	 * setter method for mFlavor
	 * @param flavor - flavor of the drinkItem
	 */
	public void setFlavor(String flavor) { mFlavor = flavor; }

	/**
	 * setter method for mMilk
	 * @param Milk - milk base for the drink
	 */
	public void setMilk(String Milk) { mMilk = Milk; }

	/**
	 * setter method for mSize
	 * @param size - size of drink
	 */
	public void setSize(String size) { mSize = size; }

	/**
	 * setter method for mSweetness
	 * @param sweetness - sweetness level of the drink Item
	 */
	public void setSweetness(String sweetness) { mSweetness = sweetness; }

	/**
	 * getter method for mFlavor
	 * @return mFlavor - flavor of the drink item
	 */
	public String getFlavor() { return mFlavor; }

	/**
	 * getter method for mMilk
	 * @return mFlavor - milk base of the drink item
	 */
	public String getMilk() {return mMilk; }

	/**
	 * getter method for mSize
	 * @return mFlavor - size of the drink item
	 */
	public String getSize() { return mSize; }

	/**
	 * getter method for mSweetness
	 * @return mFlavor - sweetness of the drink item
	 */
	public String getSweetness() { return mSweetness; }

	/**
	 * Prints all attributes of a drink item
	 */
	public String toString(){ 
		return ("Name: " + getName() + "\n\tFlavor: " + mFlavor + "\n\tSweetness: " + mSweetness + 
				"\n\tMilk: " + mMilk + "\n\tSize: " + mSize + "\nCost: " + String.format("%.2f",getCost()));
	}

}
