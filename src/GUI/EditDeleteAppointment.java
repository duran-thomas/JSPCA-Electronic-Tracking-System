package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class EditDeleteAppointment {

	JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField telephone;
	private JTextField payment;
	private JTextField amount;
	private JTextField date;
	private JTextField type;
	private JTextField breed;
	private JTextField age;
	private JTextField gender;
	private JTextField reason;
	private JTextField location;
	private JLabel lblUpdateAppointment;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDeleteAppointment window = new EditDeleteAppointment();
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
	public EditDeleteAppointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 976, 292);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				String fname = table.getValueAt(table.getSelectedRow(), 0).toString();
				String lname = table.getValueAt(table.getSelectedRow(), 1).toString();
				String tele = table.getValueAt(table.getSelectedRow(), 2).toString();
				String atype = table.getValueAt(table.getSelectedRow(), 3).toString();
				String abreed = table.getValueAt(table.getSelectedRow(), 4).toString();
				String agender = table.getValueAt(table.getSelectedRow(), 5).toString();
				String aage = table.getValueAt(table.getSelectedRow(), 6).toString();
				String rsn = table.getValueAt(table.getSelectedRow(), 7).toString();
				String pay = table.getValueAt(table.getSelectedRow(), 8).toString();
				String amnt = table.getValueAt(table.getSelectedRow(), 9).toString();
				String lctn = table.getValueAt(table.getSelectedRow(), 10).toString();
				String dt = table.getValueAt(table.getSelectedRow(), 12).toString();
				
				firstName.setText(fname);
				lastName.setText(lname);
				telephone.setText(tele);
				type.setText(atype);
				breed.setText(abreed);
				gender.setText(agender);
				age.setText(aage);
				reason.setText(rsn);
				payment.setText(pay);
				amount.setText(amnt);
				location.setText(lctn);
				date.setText(dt);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(899, 13, 89, 25);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					/*
					BufferedReader populate = new BufferedReader(new FileReader("appointment.dat"));
					String[] column = ("First Name, Last Name, Tele, Type, Breed, Gender, Age, Reason, Pay Type, Amount, Location, ID, Date").split(",");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setColumnIdentifiers(column);
					model.setRowCount(0);
					
					Object[] tableLines = populate.lines().toArray();
					for(int i = 0; i<tableLines.length; i++){
						String line = tableLines[i].toString().trim();
						String[] dataRow = line.split("|");
						model.addRow(dataRow);
					}
					*/
					
					File rFile = new File("appointment.dat");
					int recordSize =(4+(25*2) + (25*2));
					rFile.length();
					
//					System.out.println("Length Of File: " + rFile.length());
					long numRecords = rFile.length()/recordSize;
//					System.out.println("Record Size: " + recordSize);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String[] column = ("First Name, Last Name, Tele, Type, Breed, Gender, Age, Reason, Pay Type, Amount, Location, ID, Date").split(",");
					model.setColumnIdentifiers(column);
					model.setRowCount(0);
					
					for(int i = 0; i<=numRecords; i++){
//						String line = tableLines[i].toString().trim();
						String[] dataRow = getAppointment(i+1);
						if(dataRow != null){
							model.addRow(dataRow);
						}
						
					}
					
				}catch(Exception f){
					f.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(22, 523, 74, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AppointmentMenu window = new AppointmentMenu();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Appointment Has Been Updated");
			}
		});
		btnUpdate.setBounds(888, 523, 89, 25);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(100, 354, 89, 15);
		frame.getContentPane().add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setBounds(100, 369, 114, 19);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 400, 95, 15);
		frame.getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setBounds(100, 415, 114, 19);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setBounds(100, 446, 89, 15);
		frame.getContentPane().add(lblTelephone);
		
		telephone = new JTextField();
		telephone.setBounds(100, 461, 114, 19);
		frame.getContentPane().add(telephone);
		telephone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Payment Type:");
		lblNewLabel.setBounds(323, 354, 105, 15);
		frame.getContentPane().add(lblNewLabel);
		
		payment = new JTextField();
		payment.setBounds(323, 369, 114, 19);
		frame.getContentPane().add(payment);
		payment.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(323, 400, 70, 15);
		frame.getContentPane().add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(323, 415, 114, 19);
		frame.getContentPane().add(amount);
		amount.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(323, 446, 70, 15);
		frame.getContentPane().add(lblDate);
		
		date = new JTextField();
		date.setBounds(323, 461, 114, 19);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(543, 354, 70, 15);
		frame.getContentPane().add(lblType);
		
		JLabel lblBreed = new JLabel("Breed:");
		lblBreed.setBounds(543, 400, 70, 15);
		frame.getContentPane().add(lblBreed);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(543, 446, 70, 15);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(775, 354, 70, 15);
		frame.getContentPane().add(lblGender);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(775, 400, 70, 15);
		frame.getContentPane().add(lblReason);
		
		type = new JTextField();
		type.setBounds(543, 369, 114, 19);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		breed = new JTextField();
		breed.setBounds(543, 415, 114, 19);
		frame.getContentPane().add(breed);
		breed.setColumns(10);
		
		age = new JTextField();
		age.setBounds(543, 461, 114, 19);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(775, 369, 114, 19);
		frame.getContentPane().add(gender);
		gender.setColumns(10);
		
		reason = new JTextField();
		reason.setBounds(775, 415, 114, 19);
		frame.getContentPane().add(reason);
		reason.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(775, 446, 70, 15);
		frame.getContentPane().add(lblLocation);
		
		location = new JTextField();
		location.setBounds(775, 461, 202, 19);
		frame.getContentPane().add(location);
		location.setColumns(10);
		
		lblUpdateAppointment = new JLabel("Update/Delete Appointment");
		lblUpdateAppointment.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblUpdateAppointment.setBounds(376, 11, 285, 25);
		frame.getContentPane().add(lblUpdateAppointment);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Appointment Deleted");
			}
		});
		btnDelete.setBounds(784, 523, 89, 25);
		frame.getContentPane().add(btnDelete);
	}

	public String[] getAppointment(int sid){
		//Read record as appointment and convert to string array
		RandomAccessFile file = null;
		//Appointment app = new Appointment();
		String[] details = new String[13];
		
		
		try {
			
			file = new RandomAccessFile(new File("appointment.dat"),"rw");
			file.seek((sid - 1) * (4+(25*2) + (25*2)));
			
			String fn = file.readUTF();
			String ln = file.readUTF();
			String phone = file.readUTF();
			String animalType = file.readUTF();
			String breed = file.readUTF();
			String gender = file.readUTF();
			int age = file.readInt();
			String reason = file.readUTF();
			String payType = file.readUTF();
			float amt = file.readFloat();
			String location = file.readUTF();
			int iD = file.readInt();
			String date = file.readUTF();
			
			details = new String[]{fn, ln, phone, animalType, breed, gender, age+"", reason, payType, String.valueOf(amt), location, String.valueOf(iD), date};
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				file.close();
			}catch(IOException x){
				x.printStackTrace();
			}
		}
		return details;
	}
}
