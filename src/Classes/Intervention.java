package Classes;

public class Intervention {

	Client client;

	protected int idNumber;
	public String date;
	
	public Intervention(){
		client = new Client();

		idNumber = 0;
		date = "";
	}
	
	public Intervention(String fn, String ln, String tele, String type, String breed, String gender, int age, String payType, float amt, String idNum, String dt){

		idNumber = 1;
		date = "";
	}
	
	public Intervention(String fn, String ln, String tele, String type, String breed, String gender, int age, String payType, float amt, int idNum, String dt){

		client = new Client(fn, ln, tele, type, breed, gender, age, payType, amt);
		idNumber = idNum;
		date = dt;
	}
	
	public Intervention(Intervention obj){
		this.client = obj.client;
		this.idNumber = obj.idNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
