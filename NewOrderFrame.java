package Proj3;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
/**
 * this class models a NewOrderFrame object for creating a main ordering menu
 * @author Manuel Beltran
 * **/
public class NewOrderFrame extends JFrame {
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
	private JTextArea receiptTextArea;
	private JScrollPane scrollPane;
	private ArrayList<Item> items;
	private ArrayList<TeaItem> teas;
	private JPanel panel;
	private double subTotal;
	static final double TAX = .09;
	private CoffeeOrderFrame c;
	private TeaOrderFrame t;
	private PastryOrderFrame p;
	private FinalOrderFrame f;
	
	public NewOrderFrame() {
		subTotal = 0;
		items = new ArrayList<Item>();
		teas = new ArrayList<TeaItem>();
		c = new CoffeeOrderFrame(this);
		t = new TeaOrderFrame(this);
		p = new PastryOrderFrame(this);


		
		//call private helper method to create the components
		createComponents();
		//set frame properties
		this.setTitle("New Order");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createComponents() {
		//Instantiate the components
		receiptTextArea = new JTextArea(20,40);
		receiptTextArea.setEditable(false);
		scrollPane = new JScrollPane(receiptTextArea);
		instructions = new JLabel("Select an Item to purchase: ");
		coffeeButton = new JButton("Coffee");
		teaButton = new JButton("Tea");
		pastryButton = new JButton("Pastry");
		doneButton = new JButton("Done");
		ActionListener coffeeListener = new CoffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
		ActionListener teaListener = new TeaButtonListener();
		teaButton.addActionListener(teaListener);
		ActionListener pastryListener = new PastryButtonListener();
		pastryButton.addActionListener(pastryListener);
		ActionListener doneListener = new DoneButtonListener();
		doneButton.addActionListener(doneListener);
		
		doneButton.setVisible(false);
		scrollPane.setVisible(false);
		//create panel and add components
		panel = new JPanel();
		panel.add(instructions);
		panel.add(coffeeButton);
		panel.add(teaButton);
		panel.add(pastryButton);
		panel.add(scrollPane);
		panel.add(doneButton);

		//add the panel to this frame
		this.add(panel);
		
		
	}
	/**
	 * adds an additional item to an arrayList of items for NewOrderFrame
	 * @param item - an item object
	 */
	public void addItem(Item item) { items.add(item); }
	/**
	 * adds an additional tea item to an arrayList of items for NewOrderFrame
	 * @param tea - an TeaItem object
	 */
	public void addTea(TeaItem tea) { teas.add(tea); }
	/**
	 * adds to the total subTotal value
	 * @param value - amount to ad to subTotal
	 */
	public void addSubtotal(double value) { subTotal += value; }
	
	/**
	 * Getter method for subtotal
	 * @return subTotal - double amount of total costs before tax
	 */
	public double getSubtotal() {return subTotal;}
	/**
	 * getter method for retrieving this object outerclass
	 * @return this - this NewOrderFrame object
	 */
	public NewOrderFrame outer() {
		   return this;
		}
	
	public String getReceiptString() {
		String string = "\t-Current order-"+"\n";
		for(int i = 0; i < items.size(); i++) {
			string += "\n;";
			string += items.get(i);	
			}
		for(int i = 0; i < teas.size(); i++) { 
			string += "\n;";
			string += teas.get(i);
			}
		string  += "\nSubtotal: \t$" + String.format("%.2f",subTotal) + "\n";
		string +=  "tax: \t$" + String.format("%.2f",subTotal*TAX);
		string += "\nGrand Total: $" + String.format("%.2f",subTotal + subTotal*TAX);
		return string;
	}
	/**
	 * Updates the the NewOrderFrame
	 */
	public void update() {
		doneButton.setVisible(true);
		if (items.size() != 0 || teas.size() != 0) {
			receiptTextArea.setText(getReceiptString());
			scrollPane.setVisible(true);
		}
		
		
	}
	
	//INNER ACTION LISTENER CLASS FOR COFFEE BUTTON
	class CoffeeButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			//make a new coffee order frame visible
			c.setVisible(true);
		}
		
	}
	//INNER ACTION LISTENER CLASS FOR TEA BUTTON

	class TeaButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			//make a new tea order frame visible
			t.setVisible(true);
		}
		
	}
	//INNER ACTION LISTENER CLASS FOR PASTRY BUTTON
	class PastryButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			//make a new pastry order frame visible
			p.setVisible(true);
		}
		
	}
	//INNER ACTION LISTENER CLASS FOR PASTRY BUTTON
		class DoneButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent click) {
				f = new FinalOrderFrame(outer());

				if (items.size() != 0 || teas.size() != 0) { 
					f.setVisible(true);
				}
				else { System.exit(0); }
			}
			
		}
	
	public static void main(String[] args) {
		NewOrderFrame n = new NewOrderFrame();
		n.setVisible(true); //this makes the frame visible
		
	}
}

