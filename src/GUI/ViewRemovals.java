package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classes.Removal;

public class ViewRemovals {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRemovals window = new ViewRemovals();
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
	public ViewRemovals() {
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
		btnRefresh.setBounds(899, 316, 89, 25);
		frame.getContentPane().add(btnRefresh);
		
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
		btnBack.setBounds(12, 386, 74, 25);
		frame.getContentPane().add(btnBack);
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

	
