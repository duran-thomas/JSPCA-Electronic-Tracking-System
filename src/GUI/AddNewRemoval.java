package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Classes.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddNewRemoval {

	private JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JTextField teleNum;
	private JTextField amt;
	private JTextField breed;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewRemoval window = new AddNewRemoval();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNewRemoval() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddRemoval = new JLabel("Add Removal Request");
		lblAddRemoval.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblAddRemoval.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddRemoval.setBounds(162, 12, 221, 25);
		frame.getContentPane().add(lblAddRemoval);
		
		JLabel lblClientInformation = new JLabel("Client Information");
		lblClientInformation.setFont(new Font("Lucida Bright", Font.BOLD, 17));
		lblClientInformation.setBounds(209, 104, 181, 25);
		frame.getContentPane().add(lblClientInformation);
		
		JLabel lblAnimalInformation = new JLabel("Animal Information");
		lblAnimalInformation.setFont(new Font("Lucida Bright", Font.BOLD, 17));
		lblAnimalInformation.setBounds(209, 236, 181, 25);
		frame.getContentPane().add(lblAnimalInformation);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(49, 141, 81, 15);
		frame.getContentPane().add(lblFirstName);
		
		fName = new JTextField();
		fName.setBounds(49, 157, 114, 19);
		frame.getContentPane().add(fName);
		fName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(225, 141, 87, 15);
		frame.getContentPane().add(lblLastName);
		
		lName = new JTextField();
		lName.setBounds(225, 157, 114, 19);
		frame.getContentPane().add(lName);
		lName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telephone:");
		lblNewLabel.setBounds(416, 141, 97, 15);
		frame.getContentPane().add(lblNewLabel);
		
		teleNum = new JTextField();
		teleNum.setColumns(10);
		teleNum.setBounds(416, 157, 114, 19);
		frame.getContentPane().add(teleNum);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(225, 188, 70, 15);
		frame.getContentPane().add(lblAmount);
		
		amt = new JTextField();
		amt.setBounds(225, 205, 114, 19);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
//		Float a = Float.parseFloat(amt.getText());
		
		JLabel lblPaymentType = new JLabel("Payment Type:");
		lblPaymentType.setBounds(51, 186, 113, 15);
		frame.getContentPane().add(lblPaymentType);
		
		JComboBox payType = new JComboBox();
		payType.setModel(new DefaultComboBoxModel(new String[] {"None", "Partial", "Full"}));
		payType.setBounds(49, 200, 115, 24);
		frame.getContentPane().add(payType);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(49, 273, 70, 15);
		frame.getContentPane().add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dog", "Cat", "Bird", "Horse", "Goat", "Cow"}));
		comboBox.setBounds(49, 289, 114, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblBreed = new JLabel("Breed:");
		lblBreed.setBounds(225, 273, 70, 15);
		frame.getContentPane().add(lblBreed);
		
		breed = new JTextField();
		breed.setBounds(225, 292, 114, 19);
		frame.getContentPane().add(breed);
		breed.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(49, 341, 70, 15);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(401, 291, 33, 15);
		frame.getContentPane().add(lblAge);
		
		JTextField age = new JTextField();
		age.setBounds(441, 289, 42, 19);
		frame.getContentPane().add(age);
		age.setColumns(10);
//		int age2 = Integer.parseInt(age.getText());
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(22, 386, 84, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(416, 188, 70, 15);
		frame.getContentPane().add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(416, 205, 114, 19);
		frame.getContentPane().add(dateChooser);
		
		JComboBox gndr = new JComboBox();
		gndr.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gndr.setBounds(119, 334, 81, 24);
		frame.getContentPane().add(gndr);
		
		JLabel lblInterventionNumber = new JLabel("Intervention Number:");
		lblInterventionNumber.setBounds(49, 49, 151, 15);
		frame.getContentPane().add(lblInterventionNumber);
		
		JTextField idNum = new JTextField();
		idNum.setBounds(49, 67, 114, 19);
		frame.getContentPane().add(idNum);
		idNum.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(228, 321, 70, 15);
		frame.getContentPane().add(lblReason);
		
		JTextField reason = new JTextField();
		reason.setBounds(225, 337, 114, 19);
		frame.getContentPane().add(reason);
		reason.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(404, 321, 70, 15);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(401, 337, 114, 19);
		frame.getContentPane().add(address);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(416, 49, 151, 15);
		frame.getContentPane().add(lblStatus);
		
		JComboBox stat = new JComboBox();
		stat.setModel(new DefaultComboBoxModel(new String[] {"Euthanized", "Adoption"}));
		stat.setBounds(415, 64, 137, 24);
		frame.getContentPane().add(stat);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int age2 = Integer.parseInt(age.getText());
			int id = Integer.parseInt(idNum.getText());
			Float amount = Float.parseFloat(amt.getText());
			String gender = gndr.getSelectedItem().toString();
			String animal = comboBox.getSelectedItem().toString();
			String payment = payType.getSelectedItem().toString();
			String status = stat.getSelectedItem().toString();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String date = sdf.format(dateChooser.getDate());
			
			Removal x = new Removal(fName.getText(), lName.getText(), teleNum.getText(), animal, breed.getText(), gender, age2, reason.getText(), payment, amount, address.getText(), id, date, status);
			x.createRemoval(x);
		}
	});
		btnSubmit.setBounds(477, 386, 97, 25);
		frame.getContentPane().add(btnSubmit);
	}
}
