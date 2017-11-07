package Classes;

import java.io.*;


import java.util.Scanner;

public class Appointment extends Intervention{
	
	private static final int FileSize = 0;

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
	

	public void writeAppointment(Appointment obj) {
		
		RandomAccessFile file = null;
		
		try {
			
				file = new RandomAccessFile(new File("appointment.dat"),"rw");
				long FileSize = file.length();
				file.seek((obj.getIdNumber() - 500) * Appointment.FileSize);
				
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
	
	
	

	public void saveAppointment(Appointment obj){
		FileWriter aFile = null;
		try{
			aFile = new FileWriter("appointment.txt", true);
			String appoint = obj.owner.getfName() + "\t" + obj.owner.getlName() + "\t" + obj.owner.getTeleNum() + "\t" + obj.owner.animal.getType() + "\t" + obj.owner.animal.getBreed() + "\t" + obj.owner.animal.getGender() + "\t" + obj.owner.animal.getAge() + "\t" + obj.getReason() + "\t" + obj.owner.pay.getType() + "\t" + obj.owner.pay.amt + "\t" + obj.location + "\t" + obj.idNumber + "\t" + obj.date + "\n";
			aFile.write(appoint);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				aFile.close();
			}catch(IOException x){
				x.printStackTrace();
			}
		}
	}
	

	public Appointment readAppointment(String phone) {
		
		String fname;
		String lname;
		String telephone;
		String animalType;
		String breed;
		String gender;
		int age;
		String reason;
		String payType;
		float amt;
		String location;
		String id;
		String date;
		
		Appointment app = new Appointment();
		Scanner pull = null;
		
		try {
		
			pull = new Scanner(new File("appointment.dat"));
			
			while(pull.hasNext()) {
				
				fname = pull.next();
				lname = pull.next();
				telephone = pull.next();
				animalType = pull.next();
				breed = pull.next();
				gender = pull.next();
				age = pull.nextInt();
				reason = pull.next();
				payType = pull.next();
				amt = pull.nextFloat();
				location = pull.next();
				id = pull.next();
				date = pull.next();
				
				//app = new Appointment(fname, lname, telephone, animalType, breed, gender, age, reason, payType, amt, location, id, date);
				
				if(telephone.equals(phone)) {
					
					break;
				}
			}
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			System.err.println("Error retrieving file");
		}finally{
			pull.close();
		}
		
		return app;
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
}
