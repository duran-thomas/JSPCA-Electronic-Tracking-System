package Classes;

import java.io.*;

public class Appointment extends Intervention{
	
	public String location;
	Client owner;
	public String reason;

	public Appointment(){
		location = "";
		owner = new Client();
		reason = "";
	}
	
	public Appointment(String fn, String ln, String tele, String type, String breed, String gender, int age, String reason, String payType, float amt, String location, String idnum, String date) {
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
	
}
