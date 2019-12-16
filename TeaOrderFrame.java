package Proj3;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 * this class models a TeaOrderFrame object for ordering tea
 * @author Manuel Beltran
 * **/
public class TeaOrderFrame extends JFrame{
	
	private JLabel instructions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sweetness;
	private JComboBox<String> flavorOptions;
	private JComboBox<String> milkOptions;
	private JButton save;
	private JButton cancel;
	private JCheckBox topping1;
	private JCheckBox topping2;
	private JCheckBox topping3;
	private JCheckBox topping4;
	private JCheckBox topping5;
	private JCheckBox topping6;
	private NewOrderFrame newOrderFrame;

	public TeaOrderFrame(NewOrderFrame newOrderFrameObject) {
		newOrderFrame = newOrderFrameObject;
		//create the components
		createComponents();
		
		//set frame properties
		this.setTitle("New Tea Order");
		this.setSize(850,400);
		//this hides the frame on close without terminating the program
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void createComponents() {
		//instantiate the components
		instructions = new JLabel("Specify the tea order: ");
		String[] sizes = {"S","M","L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String[] sweetnesses = {"full","3/4 sweet","1/2 sweet","1/4 sweet","unsweetened"};
		sweetness = new JComboBox<String>(sweetnesses);
		
		String[] flavors = {"Green Tea","Black Tea","Jasmine Tea","Rose Tea","Oolong Tea"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String[] milk = {"whole milk","half-and-half","no milk"};
		milkOptions = new JComboBox<String>(milk);
		
		topping1 = new JCheckBox("boba");
		topping2 = new JCheckBox("popping Boba");
		topping3 = new JCheckBox("grass jelly");
		topping4 = new JCheckBox("lychee jelly");
		topping5 = new JCheckBox("coconut jelly");
		topping6 = new JCheckBox("mini mochi");
				
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		
		//creating the event listener object
		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		//using the listener object to design button reaction
		save.addActionListener(saveListener);
		cancel.addActionListener(cancelListener);
		//Create the panel and add components
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(flavorOptions);
		panel.add(new JLabel("size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("sweetness: "));
		panel.add(sweetness);
		panel.add(new JLabel("milk: "));
		panel.add(milkOptions);
		
		panel.add(save);
		panel.add(cancel);
		
		panel.add(topping1);
		panel.add(topping2);
		panel.add(topping3);
		panel.add(topping4);
		panel.add(topping5);
		panel.add(topping6);

		//add panel to frame
		this.add(panel);

	}
	
	//INNER EVEN LISTENER CLASS FOR SAVE BUTTON
	class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			
			String size = (String) sizeOptions.getSelectedItem();
			String flavor = (String) flavorOptions.getSelectedItem();
			String sweetLevel = (String) sweetness.getSelectedItem(); 
			String milk = (String) milkOptions.getSelectedItem(); 
			TeaItem tea = new TeaItem(size, flavor, sweetLevel, milk);
			JCheckBox [] toppings = {topping1, topping2, topping3, topping4, topping5, topping6};
			for (int i = 0; i< toppings.length; i++) {
					if(toppings[i].isSelected()) {tea.addTopping(toppings[i].getText());}
				}
			newOrderFrame.addTea(tea);
			newOrderFrame.addSubtotal( tea.getCost());
			newOrderFrame.update();
		}
		
	}
	//INNER EVEN LISTENER CLASS FOR SAVE BUTTON
		class CancelButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent click) {
				// getting access to the button that generated the click event
				Component button = (Component) click.getSource();
				
				//getting access to the frame in which the button is found
				JFrame frame = (JFrame) SwingUtilities.getRoot(button);
				newOrderFrame.update();
				frame.setVisible(false); //close this frame
			}
			
		}
}
