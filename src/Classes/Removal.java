
package Classes;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Removal extends Intervention{

	public String address;
	Client owner;
	public String reason;
	public String status;

	public Removal(){
		address = "";
		owner = new Client();
		reason = "";
		status = "";
	}

	public Removal(String fn, String ln, String tele, String type, String breed, String gender, int age, String reason, String payType, float amt, String address, int idnum, String date, String status){
		this.address = address;
		owner = new Client(fn, ln, tele, type, breed, gender, age, payType, amt);
		idNumber = idnum;
		this.reason = reason;
		this.status = status;
	}

	public Removal(Removal obj){
		this.address = obj.address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void initiallizeRemoval(Removal obj) {

		int max = 500;
		RandomAccessFile file = null;

		try {

				file = new RandomAccessFile(new File("removal.dat"),"rw");
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
				file.writeUTF(obj.address);
				file.writeInt(obj.idNumber);
				file.writeUTF(obj.date);
				file.writeUTF(obj.status);
				
				
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Removal Request Submitted");
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
	
	public void createRemoval(Removal obj) {

			RandomAccessFile file = null;

			try {

					file = new RandomAccessFile(new File("removal.dat"),"rw");

					file.seek((obj.idNumber - 1) * (4+(25*2) + (25*2)));

					file.writeUTF(obj.owner.getfName());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.getlName());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.getTeleNum());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.animal.getType());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.animal.getBreed());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.animal.getGender());
					file.writeUTF("\t");
					file.writeInt(obj.owner.animal.getAge());
					file.writeUTF("\t");
					file.writeUTF(obj.getReason());
					file.writeUTF("\t");
					file.writeUTF(obj.owner.pay.getType());
					file.writeUTF("\t");
					file.writeFloat(obj.owner.pay.amt);
					file.writeUTF("\t");
					file.writeUTF(obj.address);
					file.writeUTF("\t");
					file.writeInt(obj.idNumber);
					file.writeUTF("\t");
					file.writeUTF(obj.date);
					file.writeUTF("\t");

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
	
	public Removal retrieveRemoval(int sid) {

		RandomAccessFile file = null;
		Removal rem = new Removal();

		try {

			file = new RandomAccessFile(new File("removal.dat"),"rw");
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
			String address = file.readUTF();
			int iD = file.readInt();
			String date = file.readUTF();
			String status = file.readUTF();

			rem = new Removal(fn, ln, phone, animalType, breed, gender, age, reason, payType, amt, address, iD, date, status);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				file.close();
			}catch(IOException x){
				x.printStackTrace();
			}
		}
		return rem;
	}
	
	
	public void updateRemoval(int id, Removal ob) {

		retrieveRemoval(id);
		createRemoval(ob);
	}
	

	public void deleteRemoval(int sid){

		RandomAccessFile file = null;
		Removal obj = new Removal();

		try {

			file = new RandomAccessFile(new File("removal.dat"),"rw");
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
			file.writeUTF(obj.address);
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
		rec += "\tLocation: " + address + "\tId: " + idNumber + "\tDate: " + date + "\n";

		System.out.println(rec);
	}

}