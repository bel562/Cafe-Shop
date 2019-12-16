package Proj3;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * this class models a FinalOrderFrame object for finalizing the order payment
 * @author Manuel Beltran
 * **/
public class FinalOrderFrame extends JFrame{
	private JLabel instructions;
	private JButton payButton;
	private JButton exitButton;
	private JLabel paymentLabel;
	private double paymentDue;
	private JTextField inputField;
	private JTextArea receiptTextArea;
	private JScrollPane scrollPane;
	private NewOrderFrame newOrderFrame;
	
	public FinalOrderFrame(NewOrderFrame newOrderFrameObject) {
		newOrderFrame = newOrderFrameObject;

		paymentDue = newOrderFrame.getSubtotal() + newOrderFrame.getSubtotal() * newOrderFrame.TAX;
		//call private helper method to create the components
		createComponents();
		//set frame properties
		this.setTitle("Finalize Order");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void createComponents() {
		//Find amount due
		
		receiptTextArea = new JTextArea(20,40);
		receiptTextArea.setText(newOrderFrame.getReceiptString());
		receiptTextArea.setEditable(false);
		scrollPane = new JScrollPane(receiptTextArea);
		
		instructions = new JLabel("Amount Due: $"+ String.format("%.2f",paymentDue));
		paymentLabel = new JLabel("Payment: $");
		payButton = new JButton("Pay");
		exitButton = new JButton("Exit");
		inputField = new JTextField(20);
		ActionListener payListener = new PayButtonListener();
		payButton.addActionListener(payListener);
		ActionListener exitListener = new ExitButtonListener();
		exitButton.addActionListener(exitListener);
		
		//create panel and add components
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(scrollPane);
		panel.add(paymentLabel);
		panel.add(inputField);
		panel.add(payButton);
		panel.add(exitButton);
	

		//add the panel to this frame
		this.add(panel);
		
		exitButton.setVisible(false);
	}
	//INNER ACTION LISTENER CLASS FOR COFFEE BUTTON
	class PayButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			paymentDue = paymentDue - Double.parseDouble(inputField.getText());
			//Pay the amount due
			if (paymentDue <= 0) {
				instructions.setText("Thank You!");
				receiptTextArea.append("\nPament: $" + inputField.getText() + "\nChange Due: $" + String.format("%.2f",-1 * paymentDue) + "\n\t--THANK YOU--");
				exitButton.setVisible(true);
				payButton.setVisible(false);
				paymentLabel.setVisible(false);
				inputField.setVisible(false);
			}
			else {
				instructions.setText("Insufficient payment! Amount Still Due: $"+ String.format("%.2f",paymentDue));
			}
			
		}
		
	}
	//INNER ACTION LISTENER CLASS FOR TEA BUTTON

	class ExitButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			//Terminates the program
			System.exit(0);
		}
		
	}
}
