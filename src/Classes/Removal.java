package Classes;

public class Removal extends Intervention{

	public String address;
	
	public Removal(){
		address = "";
	}
	
	public Removal(String adrs){
		address = adrs;
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
	
}
