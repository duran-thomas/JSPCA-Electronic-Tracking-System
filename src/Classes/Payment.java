package Classes;

public class Payment {
	
	public String type;
	public float amt;
	
	public Payment(){
		type = "";
		amt = 0f;
	}
	
	public Payment(String type, float amt){
		this.type = type;
		this.amt = amt;
	}
	
	public Payment(Payment obj){
		this.type = obj.type;
		this.amt = obj.amt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}
	
	
}

