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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class EditDeleteRemoval {

	JFrame frame;
	private JTextField address;
	private JTextField reason;
	private JTextField gender;
	private JTextField type;
	private JTextField breed;
	private JTextField age;
	private JTextField telephone;
	private JTextField date;
	private JTextField lastName;
	private JTextField amount;
	private JTextField payType;
	private JTextField firstName;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDeleteRemoval window = new EditDeleteRemoval();
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
	public EditDeleteRemoval() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 976, 292);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				String stat = table.getValueAt(table.getSelectedRow(), 13).toString();
				
				firstName.setText(fname);
				lastName.setText(lname);
				telephone.setText(tele);
				type.setText(atype);
				breed.setText(abreed);
				gender.setText(agender);
				age.setText(aage);
				reason.setText(rsn);
				payType.setText(pay);
				amount.setText(amnt);
				address.setText(lctn);
				date.setText(dt);
				status.setText(stat);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
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
					
					File rFile = new File("removal.dat");
					int recordSize =(4+(25*2) + (25*2));
					rFile.length();
					
					long numRecords = rFile.length()/recordSize;
					
					
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String[] column = ("First Name, Last Name, Tele, Type, Breed, Gender, Age, Reason, Pay Type, Amount, Address, ID, Date, Status").split(",");
					model.setColumnIdentifiers(column);
					model.setRowCount(0);
					
					for(int i = 0; i<=numRecords; i++){
						String[] dataRow = getRemovalRequest(i+1);
						
						model.addRow(dataRow);
						
					}
					
				}catch(Exception f){
					f.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(899, 12, 89, 25);
		frame.getContentPane().add(btnRefresh);
		
		JLabel lblUpdatedeleteRemovalRequests = new JLabel("Update/Delete Removal Requests");
		lblUpdatedeleteRemovalRequests.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblUpdatedeleteRemovalRequests.setBounds(338, 12, 349, 23);
		frame.getContentPane().add(lblUpdatedeleteRemovalRequests);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Removal Request Has Been Updated");
			}
		});
		btnUpdate.setBounds(899, 536, 89, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Removal Request Deleted");
			}
		});
		btnDelete.setBounds(804, 536, 81, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RemovalMenu window = new RemovalMenu();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnBack.setBounds(24, 536, 81, 25);
		frame.getContentPane().add(btnBack);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(666, 473, 114, 19);
		frame.getContentPane().add(address);
		
		JLabel Address = new JLabel("Address:");
		Address.setBounds(666, 458, 70, 15);
		frame.getContentPane().add(Address);
		
		reason = new JTextField();
		reason.setColumns(10);
		reason.setBounds(666, 427, 114, 19);
		frame.getContentPane().add(reason);
		
		JLabel label_1 = new JLabel("Reason:");
		label_1.setBounds(666, 412, 70, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Gender:");
		label_2.setBounds(666, 366, 70, 15);
		frame.getContentPane().add(label_2);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(666, 381, 114, 19);
		frame.getContentPane().add(gender);
		
		JLabel label_3 = new JLabel("Type:");
		label_3.setBounds(450, 366, 70, 15);
		frame.getContentPane().add(label_3);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(450, 381, 114, 19);
		frame.getContentPane().add(type);
		
		JLabel label_4 = new JLabel("Breed:");
		label_4.setBounds(450, 412, 70, 15);
		frame.getContentPane().add(label_4);
		
		breed = new JTextField();
		breed.setColumns(10);
		breed.setBounds(450, 427, 114, 19);
		frame.getContentPane().add(breed);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(450, 473, 114, 19);
		frame.getContentPane().add(age);
		
		JLabel label_5 = new JLabel("Age:");
		label_5.setBounds(450, 458, 70, 15);
		frame.getContentPane().add(label_5);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(24, 473, 114, 19);
		frame.getContentPane().add(telephone);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(236, 473, 114, 19);
		frame.getContentPane().add(date);
		
		JLabel label_6 = new JLabel("Date:");
		label_6.setBounds(236, 458, 70, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Telephone:");
		label_7.setBounds(24, 458, 89, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Last Name:");
		label_8.setBounds(24, 412, 95, 15);
		frame.getContentPane().add(label_8);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(24, 427, 114, 19);
		frame.getContentPane().add(lastName);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(236, 427, 114, 19);
		frame.getContentPane().add(amount);
		
		JLabel label_9 = new JLabel("Amount:");
		label_9.setBounds(236, 412, 70, 15);
		frame.getContentPane().add(label_9);
		
		payType = new JTextField();
		payType.setColumns(10);
		payType.setBounds(236, 381, 114, 19);
		frame.getContentPane().add(payType);
		
		JLabel label_10 = new JLabel("Payment Type:");
		label_10.setBounds(236, 366, 105, 15);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("First Name:");
		label_11.setBounds(24, 366, 89, 15);
		frame.getContentPane().add(label_11);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(24, 381, 114, 19);
		frame.getContentPane().add(firstName);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(846, 366, 70, 15);
		frame.getContentPane().add(lblStatus);
		
		status = new JTextField();
		status.setBounds(846, 381, 114, 19);
		frame.getContentPane().add(status);
		status.setColumns(10);
	}
	
	public String[] getRemovalRequest(int sid){
		//Read record as appointment and convert to string array
		RandomAccessFile file = null;
		//Removal rem = new Removal();
		String[] details = new String[13];
		
		try {
			
			file = new RandomAccessFile(new File("removal.dat"),"rw");
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
			String address = file.readUTF();
			int iD = file.readInt();
			String date = file.readUTF();
			String status = file.readUTF();
			
			details = new String[]{fn, ln, phone, animalType, breed, gender, age+"", reason, payType, String.valueOf(amt), address, String.valueOf(iD), date, status};
		
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
