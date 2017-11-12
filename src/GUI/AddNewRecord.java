package GUI;

import Classes.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;

public class AddNewRecord {

	private JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JTextField teleNum;
	private JTextField amt;
	private JTextField breed;
	private JTextField age;
	private JTextField idNum;
	private JTextField reason;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewRecord window = new AddNewRecord();
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
	public AddNewRecord() {
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
		
		JLabel lblAddAppointment = new JLabel("Add Appointment");
		lblAddAppointment.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblAddAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAppointment.setBounds(199, 12, 181, 25);
		frame.getContentPane().add(lblAddAppointment);
		
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
		
		age = new JTextField();
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
		
		idNum = new JTextField();
		idNum.setBounds(49, 67, 114, 19);
		frame.getContentPane().add(idNum);
		idNum.setColumns(10);
		
		JLabel lblClinicLocation = new JLabel("Clinic Location:");
		lblClinicLocation.setBounds(341, 49, 114, 15);
		frame.getContentPane().add(lblClinicLocation);
		
		JComboBox lctn = new JComboBox();
		lctn.setModel(new DefaultComboBoxModel(new String[] {"10-Winchester-Road", "Caymanas-Track-Limited"}));
		lctn.setBounds(341, 64, 192, 24);
		frame.getContentPane().add(lctn);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(269, 323, 70, 15);
		frame.getContentPane().add(lblReason);
		
		reason = new JTextField();
		reason.setBounds(266, 339, 114, 19);
		frame.getContentPane().add(reason);
		reason.setColumns(10);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int age2 = Integer.parseInt(age.getText());
			int id = Integer.parseInt(idNum.getText());
			Float amount = Float.parseFloat(amt.getText());
			String gender = gndr.getSelectedItem().toString();
			String animal = comboBox.getSelectedItem().toString();
			String payment = payType.getSelectedItem().toString();
			String location = lctn.getSelectedItem().toString();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String date = sdf.format(dateChooser.getDate());
			
			

			Appointment x = new Appointment(fName.getText(), lName.getText(), teleNum.getText(), animal, breed.getText(), gender, age2, reason.getText(), payment, amount, location, id, date);
			x.createAppointment(x);
		}
	});
		btnSubmit.setBounds(477, 386, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		
		
		
		

	}
}
