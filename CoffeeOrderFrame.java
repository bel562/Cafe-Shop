package Proj3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 * this class models a CoffeeOrderFrame object for ordering coffee
 * @author Manuel Beltran
 * **/
public class CoffeeOrderFrame extends JFrame{
	
	private JLabel instructions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugarTsp;
	private JComboBox<String> flavorOptions;
	private JComboBox<String> milkOptions;
	private JComboBox<String> temperatureOptions;
	private JTextField specialInstructionsField;
	private JButton save;
	private JButton cancel;
	private NewOrderFrame newOrderFrame;
	
	public CoffeeOrderFrame(NewOrderFrame frameObject) {
		newOrderFrame = frameObject;
		//create the components
		createComponents();
		
		//set frame properties
		this.setTitle("New Coffee Order");
		this.setSize(800,400);
		//this hides the frame on close without terminating the program
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void createComponents() {
		//instantiate the components
		instructions = new JLabel("Specify the coffee order: ");
		String[] sizes = {"S","M","L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String[] tsp = {"1","2","3","4","5","6","7","8","9","10"};
		sugarTsp = new JComboBox<String>(tsp);
		
		String[] flavors = {"regular","mocha","hazelnut","vanilla"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String[] milk = {"whole milk","half-and-half","no milk"};
		milkOptions = new JComboBox<String>(milk);
		
		String[] temperature = {"hot","cold","blended"};
		temperatureOptions = new JComboBox<String>(temperature);
		
		specialInstructionsField = new JTextField(20);
		
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
		panel.add(new JLabel("flavor: "));
		panel.add(flavorOptions);
		panel.add(new JLabel("size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("sugar tsp: "));
		panel.add(sugarTsp);
		panel.add(new JLabel("milk: "));
		panel.add(milkOptions);
		panel.add(new JLabel("type: "));
		panel.add(temperatureOptions);
		panel.add(new JLabel("special instructions: "));
		panel.add(specialInstructionsField);
		panel.add(save);
		panel.add(cancel);
		
		//add panel to frame
		this.add(panel);

	}
	
	//INNER EVENt LISTENER CLASS FOR SAVE BUTTON
	class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			
			String size = (String) sizeOptions.getSelectedItem();
			String flavor = (String) flavorOptions.getSelectedItem();
			String sweetness = (String) sugarTsp.getSelectedItem(); 
			String milk = (String) milkOptions.getSelectedItem(); 
			String temperature = (String) temperatureOptions.getSelectedItem();
			String specialInstructions = specialInstructionsField.getText();
			Item coffee = new CoffeeItem(size, flavor, sweetness, milk, temperature,specialInstructions);
			newOrderFrame.addItem(coffee);
			newOrderFrame.addSubtotal( coffee.getCost());
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
