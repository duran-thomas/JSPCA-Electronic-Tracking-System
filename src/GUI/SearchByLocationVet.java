package GUI;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import Classes.*;


public class SearchByLocationVet {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchByLocationVet window = new SearchByLocationVet();
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
	public SearchByLocationVet() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 976, 292);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
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
							VetClinicReportMenuh window = new VetClinicReportMenuh();
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
		
		JComboBox lctn = new JComboBox();
		lctn.setBounds(355, 340, 191, 24);
		lctn.setModel(new DefaultComboBoxModel(new String[] {"10-Winchester-Road", "Caymanas-Track-Limited"}));
		frame.getContentPane().add(lctn);
		
		JLabel lblSearch = new JLabel("Select Location:");
		lblSearch.setBounds(235, 345, 126, 15);
		frame.getContentPane().add(lblSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Search For ID
				
				String location = lctn.getSelectedItem().toString();
				try{
					
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
					
					for(int i = 0; i<numRecords; i++){
//						String line = tableLines[i].toString().trim();
						String[] dataRow = searchAppointment(location);
						if(dataRow != null){
							model.addRow(dataRow);
						}
					}
					
				}catch(Exception f){
					f.printStackTrace();
				}
			}

		});
		btnSearch.setBounds(558, 340, 93, 25);
		frame.getContentPane().add(btnSearch);
		
		
	}
	
	public String[] getAppointment(int sid){
		//Read record as appointment and convert to string array
		RandomAccessFile file = null;
		
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
	
	
	
	//MODIFIED SEARCH FUNCTION
	public String[] searchAppointment(String search){		
		RandomAccessFile file = null;
		String[] app = new String[13];
		
			try {
				
				file = new RandomAccessFile(new File("appointment.dat"), "r");	
				
				try{
					for(int idx = 1; idx < 100; idx++) {	
						
						file.seek((idx - 1) * (4+(25*2) + (25*2)));

						String fn = file.readUTF();
						String ln = file.readUTF();
						String phone = file.readUTF();
						String animalType = file.readUTF();
						String breed = file.readUTF();
						String gender= file.readUTF();
						int age = file.readInt();
						String reason = file.readUTF();
						String payType = file.readUTF();
						float amt = file.readFloat();
						String location = file.readUTF();
						int iD = file.readInt();
						String date = file.readUTF();		
		
						if(location.equals(search)) {
				
						app = new String[]{fn, ln, phone, animalType, breed, gender, String.valueOf(age), reason, payType, String.valueOf(amt), location, String.valueOf(iD), date};
	
						System.out.println(fn+ "\t" + ln+ "\t" + phone+ "\t" + animalType+ "\t" + breed+ "\t" + gender+ "\t" + age+ "\t" + reason+ "\t" + payType+ "\t" + amt+ "\t" + location+ "\t" + iD+ "\t" + date);
			}
		}
				}catch(EOFException s){
					s.printStackTrace();
				}
				
			}catch(IOException w){
				w.printStackTrace();
			}finally {
			try {
				file.close();
			}catch(IOException z){
				z.printStackTrace();
			}
		}
		return app;
	}
}
