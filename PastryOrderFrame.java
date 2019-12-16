package Proj3;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 * this class models a PastryOrderFrame object for ordering pastries
 * @author Manuel Beltran
 * **/
public class PastryOrderFrame extends JFrame{

	private JComboBox<String> pastryOptions;
	private JComboBox<String> muffinFlavorOptions;
	private JComboBox<String> cookieFlavorOptions;
	private JComboBox<String> cheesecakeFlavorOptions;
	private JComboBox<String> danishFlavorOptions;
	private JCheckBox heated;
	private JButton save;
	private JButton cancel;
	private NewOrderFrame newOrderFrame;
	
	public PastryOrderFrame(NewOrderFrame frameObject) {
		newOrderFrame = frameObject;
		//create the components
		createComponents();
		
		//set frame properties
		this.setTitle("New Pastry Order");
		this.setSize(800,400);
		//this hides the frame on close without terminating the program
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void createComponents() {
		//instantiate the components
		String[] flavors = {"muffin","cheesecake slice","cookie","danish"};
		pastryOptions = new JComboBox<String>(flavors);
		
		String[] muffinFlavors = {"bannan nut","blueberry","chocolate chip","coffee cake"};
		muffinFlavorOptions = new JComboBox<String>(muffinFlavors);
		
		String[] cheesecakeFlavors = {"regular","cherry","blueberry"};
		cheesecakeFlavorOptions = new JComboBox<String>(cheesecakeFlavors);
		
		String[] cookieFlavors = {"oatmeal","white choco & macadamias","chocolate chip","double fudge"};
		cookieFlavorOptions = new JComboBox<String>(cookieFlavors);
		
		String[] danishFlavors = {"apple cinnamon","strawberry & cheese","douBle cheese"};
		danishFlavorOptions = new JComboBox<String>(danishFlavors);

		heated = new JCheckBox("Heated");
		
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		
		//set invisible
		muffinFlavorOptions.setVisible(false);
		cheesecakeFlavorOptions.setVisible(false);
		cookieFlavorOptions.setVisible(false);
		danishFlavorOptions.setVisible(false);
		heated.setVisible(false);	
		save.setVisible(false);
		//creating the event listener object
		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		ActionListener pastryListener = new pastryOptionsListener();
		//using the listener object to design button reaction
		save.addActionListener(saveListener);
		cancel.addActionListener(cancelListener);
		pastryOptions.addActionListener(pastryListener);
		//Create the panel and add components
		JPanel panel = new JPanel();
		panel.add(pastryOptions);
		panel.add(muffinFlavorOptions);
		panel.add(cheesecakeFlavorOptions);
		panel.add(cookieFlavorOptions);
		panel.add(danishFlavorOptions);
		panel.add(heated);
		panel.add(save);
		panel.add(cancel);
		
		//add panel to frame
		this.add(panel);

	}
	
	//INNER EVEN LISTENER CLASS FOR SAVE BUTTON
	class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			
			String pastryName = (String) pastryOptions.getSelectedItem();
			
			ArrayList<JComboBox<String>> pastryFlavorList = new ArrayList<JComboBox<String>>();
			pastryFlavorList.add(muffinFlavorOptions);
			pastryFlavorList.add(cheesecakeFlavorOptions);
			pastryFlavorList.add(cookieFlavorOptions);
			pastryFlavorList.add(danishFlavorOptions);
			
			int pastryChoiceIndex = pastryOptions.getSelectedIndex();
			JComboBox<String> flavorChoices = pastryFlavorList.get(pastryChoiceIndex);
			String flavor = (String) flavorChoices.getSelectedItem();
			boolean isHeated =  heated.isSelected();
			Item pastry = new Pastry(pastryName,flavor, isHeated);
			newOrderFrame.addItem(pastry);
			newOrderFrame.addSubtotal( pastry.getCost());
			newOrderFrame.update();
		}
		
	}
	//INNER EVEN LISTENER CLASS FOR CANCEL BUTTON
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
		//INNER EVEN LISTENER CLASS FOR SAVE pastryOptions COMBOBOX
		class pastryOptionsListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent click) {
				// getting access to the comboBox that generated the click event
				JComboBox<String> cb = (JComboBox<String>) click.getSource();
				int choice = cb.getSelectedIndex();
				heated.setVisible(true);
				save.setVisible(true);

				ArrayList<JComboBox<String>> pastryFlavors = new ArrayList<JComboBox<String>>();
				pastryFlavors.add(muffinFlavorOptions);
				pastryFlavors.add(cheesecakeFlavorOptions);
				pastryFlavors.add(cookieFlavorOptions);
				pastryFlavors.add(danishFlavorOptions);
				
				for(int i = 0; i < pastryFlavors.size(); i++) { pastryFlavors.get(i).setVisible(false); }
				pastryFlavors.get(choice).setVisible(true);				
		
				
			}
			
		}
}
