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
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewAppointments {

	JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

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
					File rFile = new File("appointment.dat");
					int recordSize =(4+(25*2) + (25*2));
					rFile.length();
					

					long numRecords = rFile.length()/recordSize;

					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String[] column = ("First Name, Last Name, Tele, Type, Breed, Gender, Age, Reason, Pay Type, Amount, Location, ID, Date").split(",");
					model.setColumnIdentifiers(column);
					model.setRowCount(0);
					
					for(int i = 0; i<=numRecords; i++){
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
