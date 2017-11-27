package Classes;

public class testDriver {

	public static void main(String[] args) {

		
	/* Used to Initialize file */ 	
	//	Appointment Ob = new Appointment(" ", " ", "0000000", " ", " ", " ", 0, " ", "", 0f, " ",0 , " ");
	
	//	Used to create the record
	//	Appointment O = new Appointment("Shemar", "Henry", "7162534", "Puppy", "PitBull", "Male", 2, "training", "full", 22.00f, "Kingston", 10, "0603-2013");
		
			
	//	O.initiallizeAppointment(O);
	//	O.createAppointment(O);
		
	//	Appointment O = new Appointment();

		

	//	Appointment O = new Appointment();
	//	Appointment Ob = new Appointment();

		
	//	retrieve record using ID number
	//	O = O.retrieveAppointment(1);
		
	//	O.deleteAppointment(3);
		
//		O.updateAppointment(2, O);
		

	//	Ob = O.searchAppointment(2);

	//	O.display();
		
		
		  
		  
		  
		  
		/************************************ Removal *****************************************/ 
		 
		 /* Used to Initialize file */ 	
		//Removal re = new Appointment(" ", " ", "0000000", " ", " ", " ", 0, " ", "", 0f, " ",0 , " ");
	
	/*	Used to create the record*/

		
			
	//	re.initiallizeAppointment(re);
	//	re.createRemoval(re);
		
	//	Removal re = new Removal();
		
	//	retrieve record using ID number
	//	re.retrieveRemoval(3);
		
	//	re.deleteRemoval(3);
		
	//	re.updateRemoval(2, re);
		
	//	re.display();
		 
		

		//O.display();		
		String var1 = "10-Winchester-Road";
		String var2 = "Caymanas-Track-Limited";
				
		Appointment x = new Appointment();	
		
		//declare an object array that holds 100 records
		Appointment[] y = new Appointment[100];
		
		//stores the object array result in an object array
		y = x.searchAppointment(var1);

		//Show method is called passing in an object array
		x.show(y);
	}
}
