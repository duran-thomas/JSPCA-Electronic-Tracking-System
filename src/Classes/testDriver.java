package Classes;

public class testDriver {

	public static void main(String[] args) {

		
	/* Used to Initialize file */ 	
	//	Appointment Ob = new Appointment(" ", " ", "0000000", " ", " ", " ", 0, " ", "", 0f, " ",0 , " ");
	
	/*	Used to create the record*/
		Appointment O = new Appointment("Mardii", "Dking", "7162534", "Dog", "PitBull", "Male", 2, "training", "full", 22.00f, "Kingston", 3, "0603-2013");
		
			
	//	O.initiallizeAppointment(Ob);
	//	O.createAppointment(O);
		
	//	Appointment O = new Appointment();
		
	//	retrieve record using ID number
	//	O = O.retrieveAppointment(3);
		
	//	O.deleteAppointment(3);
		
		O.updateAppointment(2, O);
		
		O.display();
	}
}
