package Classes;

public class Client {

	public String fName;
	public String lName;
	public String teleNum;
	Animal animal;
	Payment pay;
	
	public Client(){
		fName = "";
		lName = "";
		teleNum = "";
		animal = new Animal();
		pay = new Payment();
	}
	
	public Client(String fn, String ln, String tele, String type, String breed, String gender, int age, String payType, float amt){
		fName = fn;
		lName = ln;
		teleNum = tele;
		animal = new Animal(type, breed, gender, age);
		pay = new Payment(payType, amt);
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getTeleNum() {
		return teleNum;
	}

	public void setTeleNum(String teleNum) {
		this.teleNum = teleNum;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Payment getPay() {
		return pay;
	}

	public void setPay(Payment pay) {
		this.pay = pay;
	}
	
	
}
