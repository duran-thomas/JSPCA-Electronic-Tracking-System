package Classes;

public class testDriver {

	public static void main(String[] args) {


		Appointment O = new Appointment("Bailey", "Mardon", "7654321", "Dog", "PitBull", "Male", 2, "sick", "partial", 15.00f, "Portmore", 5, "12-11-2017");
		O.writeAppointment(O);
		
	//	O = O.readAppointment("4190014");
		
		O.display();
	}

}
