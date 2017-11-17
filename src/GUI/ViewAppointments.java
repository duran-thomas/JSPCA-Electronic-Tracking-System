package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Classes.Appointment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewAppointments {

	JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblSearch;
	private JTextField textField;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointments window = new ViewAppointments();
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
	public ViewAppointments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 976, 292);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh Table");
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
		btnRefresh.setBounds(856, 316, 132, 25);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNewButton = new JButton("Back");
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
		btnNewButton.setBounds(23, 380, 74, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblSearch = new JLabel("Search ID:");
		lblSearch.setBounds(280, 345, 103, 15);
		frame.getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(362, 343, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search For ID
				
			}
		});
		btnSearch.setBounds(486, 340, 93, 25);
		frame.getContentPane().add(btnSearch);
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
