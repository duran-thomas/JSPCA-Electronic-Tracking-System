package Classes;

public class testDriver {

	public static void main(String[] args) {

		
	/* Used to Initialize file */ 	
	//	Appointment Ob = new Appointment(" ", " ", "0000000", " ", " ", " ", 0, " ", "", 0f, " ",0 , " ");
	
	/*	Used to create the record*/
	//	Appointment O = new Appointment("Mardii", "Bailey", "1726354", "Dog", "PitBull", "Male", 4, "work", "partial", 14.00f, "Portmore", 3, "12-11-2017");
		
			
	//	O.initiallizeAppointment(Ob);
	//	O.createAppointment(O);
		
		Appointment O = new Appointment();
		
		//retrieve record using ID number
	//	O = O.retrieveAppointment(2);
		
		O.deleteAppointment(3);
		
		O.display();
	}
}
