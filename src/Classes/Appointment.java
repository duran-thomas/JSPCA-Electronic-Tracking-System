package Classes;

import java.awt.Component;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


import javax.swing.JOptionPane;

public class Appointment extends Intervention{
	
	public String location;
	Client owner;
	public String reason;

	public Appointment(){
		location = "";
		owner = new Client();
		reason = "";
	}
	

	public Appointment(String fn, String ln, String tele, String type, String breed, String gender, int age, String reason, String payType, float amt, String location, int idnum, String date) {

		this.location = location;
		owner = new Client(fn, ln, tele, type, breed, gender, age, payType, amt);
		this.date = date;
		idNumber = idnum;
		this.reason = reason;
	}
	
	public Appointment(Appointment obj){
		this.location = obj.location;
		this.owner = obj.owner;
		this.client = obj.client;
		this.idNumber = obj.idNumber;
		this.reason = obj.reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	//Create a file and initialize byte space for 100 records
	public void initiallizeAppointment(Appointment obj) {
		
		int max = 100;
		RandomAccessFile file = null;
		
		try {
			
				file = new RandomAccessFile(new File("appointment.dat"),"rw");
				for(int idx = 1; idx <=max; idx++) {
					
				file.seek((idx - 1) * (4+(25*2) + (25*2)));
							
				file.writeUTF(obj.owner.getfName());
				file.writeUTF(obj.owner.getlName());
				file.writeUTF(obj.owner.getTeleNum());
				file.writeUTF(obj.owner.animal.getType());
				file.writeUTF(obj.owner.animal.getBreed());
				file.writeUTF(obj.owner.animal.getGender());
				file.writeInt(obj.owner.animal.getAge());
				file.writeUTF(obj.getReason());
				file.writeUTF(obj.owner.pay.getType());
				file.writeFloat(obj.owner.pay.amt);
				file.writeUTF(obj.location);
				file.writeInt(obj.idNumber);
				file.writeUTF(obj.date);
				}
			
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					file.close();
				}catch(IOException x){
					x.printStackTrace();
				}
			}
	}
	
	
	public void createAppointment(Appointment obj) {
			
			RandomAccessFile file = null;
			
			try {
				
					file = new RandomAccessFile(new File("appointment.dat"),"rw");
						
					file.seek((obj.idNumber - 1) * (4+(25*2) + (25*2)));
								
					file.writeUTF(obj.owner.getfName());
					file.writeUTF(obj.owner.getlName());
					file.writeUTF(obj.owner.getTeleNum());
					file.writeUTF(obj.owner.animal.getType());
					file.writeUTF(obj.owner.animal.getBreed());
					file.writeUTF(obj.owner.animal.getGender());
					file.writeInt(obj.owner.animal.getAge());
					file.writeUTF(obj.getReason());
					file.writeUTF(obj.owner.pay.getType());
					file.writeFloat(obj.owner.pay.amt);
					file.writeUTF(obj.location);
					file.writeInt(obj.idNumber);
					file.writeUTF(obj.date);
					
				}catch(IOException e){
					
				}finally{
					try{
						file.close();
					}catch(IOException x){
						x.printStackTrace();
					}
				}
		}
	
	public Appointment retrieveAppointment(int sid) {
		
		RandomAccessFile file = null;
		Appointment app = new Appointment();
				
		try {
			
			file = new RandomAccessFile(new File("appointment.dat"),"rw");
			file.seek((sid - 1) * (4+(25*2) + (25*2)));
			
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
		
			app = new Appointment(fn, ln, phone, animalType, breed, gender, age, reason, payType, amt, location, iD, date);

		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				file.close();
			}catch(IOException x){
				x.printStackTrace();
			}
		}
		return app;
	}
	
	public void updateAppointment(int id, Appointment ob) {
		
		retrieveAppointment(id);
		createAppointment(ob);
		
		
	}
	
	public void deleteAppointment(int sid){
		
		RandomAccessFile file = null;
		Appointment obj = new Appointment();
				
		try {
			
			file = new RandomAccessFile(new File("appointment.dat"),"rw");
			file.seek((sid - 1) * (4+(25*2) + (25*2)));
			
			file.writeUTF(obj.owner.getfName());
			file.writeUTF(obj.owner.getlName());
			file.writeUTF(obj.owner.getTeleNum());
			file.writeUTF(obj.owner.animal.getType());
			file.writeUTF(obj.owner.animal.getBreed());
			file.writeUTF(obj.owner.animal.getGender());
			file.writeInt(obj.owner.animal.getAge());
			file.writeUTF(obj.getReason());
			file.writeUTF(obj.owner.pay.getType());
			file.writeFloat(obj.owner.pay.amt);
			file.writeUTF(obj.location);
			file.writeInt(obj.idNumber);
			file.writeUTF(obj.date);
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				file.close();
			}catch(IOException x){
				x.printStackTrace();
			}
		}
	}
	
	
	public void display() {
		
		String rec;
		
		rec = "\nFirstname: "+ owner.getfName() + "\tLastname: " + owner.getlName();
		rec += "\tTelephone: " + owner.getTeleNum() + "\nAnimal Type: " + owner.animal.getType();
		rec += "\tBreed: " + owner.animal.getBreed() + "\tGender: " + owner.animal.getGender();
		rec += "\tAnimal Age: " + owner.animal.getAge() + "\tReason: " + getReason();
		rec += "\nPay Type: " + owner.pay.getType() + "\tAmount: " + owner.pay.amt;
		rec += "\tLocation: " + location + "\tId: " + idNumber + "\tDate: " + date + "\n";
		
		System.out.println(rec);
	}
	
	//This method accepts an object array of records to print each record.
	//NOTE - We can use this as an overriding method and override the display method
	public void show(Appointment[] g) {
		
		String rec;
		
		//loop through all elements of the array
		for (int i=1; i<g.length; i++) {
			
			rec = "\nFirstname: " + g[i].owner.getfName() + "\tLastname: " + g[i].owner.getlName();
			rec += "\tTelephone: " + g[i].owner.getTeleNum() + "\nAnimal Type: " + g[i].owner.animal.getType();
			rec += "\tBreed: " + g[i].owner.animal.getBreed() + "\tGender: " + g[i].owner.animal.getGender();
			rec += "\tAnimal Age: " + g[i].owner.animal.getAge() + "\tReason: " + g[i].getReason();
			rec += "\nPay Type: " + g[i].owner.pay.getType() + "\tAmount: " + g[i].owner.pay.amt;
			rec += "\tLocation: " + g[i].location + "\tId: " + g[i].idNumber + "\tDate: " + g[i].date + "\n";
			
			System.out.println(rec);
		}
	}
	
	//method returns an object array of records
	public Appointment[] searchAppointment(String search){

		 
		Appointment[] y = new Appointment[100];
		RandomAccessFile file = null;
		int count = 0;
		
			try {
				
				file = new RandomAccessFile(new File("appointment.dat"), "r");	
				
				for(int idx = 1; idx < file.length(); idx++) {	
					
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
							//counts how many time the location matches to set the array index
							count++;
						y[count] = new Appointment(fn, ln, phone, animalType, breed, gender, age, reason, payType, amt, location, iD, date);
	
			//			System.out.println(fn+ "\t" + ln+ "\t" + phone+ "\t" + animalType+ "\t" + breed+ "\t" + gender+ "\t" + age+ "\t" + reason+ "\t" + payType+ "\t" + amt+ "\t" + location+ "\t" + iD+ "\t" + date);
						
			}
						
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
			//returns the object array
			return y;	
	}
}
