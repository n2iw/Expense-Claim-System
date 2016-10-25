package edu.ualbany.icis518.team6;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TripsData {

	public static void main(String[] args){
		
/*		//HOW TO READ the Date type
		//The Date will return a long number to represent the time
	    Date d = new Date(); 
	    System.out.println(d.getTime()); 
	    	    	    
	    //we use SimpleDateFormat to transform the Date into the format we can read
	    
	    //setup the format of the Time we prefer to read
	    SimpleDateFormat DateTime = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	    System.out.println(DateTime.format(d));
	    
	    
	    // another format:
	    SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
	    System.out.println(Date.format(d)); 
	    
	    //so in Trips, getstartDate(); will return a Date type, 
	     * now you know how to transfer Date into a String format
*/	    

/*		//HOW TO SAVE a String into Date type
		// for example we have a String format to save, October-24th-2016
		String needtosave = "10-23-2016"; 
		// setup the corresponding format 
	    SimpleDateFormat stod = new SimpleDateFormat("MM-dd-yyyy"); 

	    try { 
	      // Parse the text version of the date. 
	      //We have to perform the parse method in a 
	      //try-catch construct in case dateStringToParse 
	      //does not contain a date in the format we are expecting. 
	      Date dateexample = stod.parse(needtosave); 
	      // Now send the parsed date as a long value 
	      // to the system output. 
	      System.out.println(dateexample.getTime()); 
	    } 
	    catch (Exception ex){ 
	      System.out.println(ex.getMessage());   
	    }
		
		// the dateexample is what you got! you can save it to database!
*/		


/*		Date d = new Date();//when a Date is created, it always has the current time
		Trips trip = new Trips();	
		trip.add("New Tork", d);*/
		//Trips trip=Trips.getbyTripId(8);
		//System.out.println(trip.getDescription());


/*		 List<Trips> TripsList=Trips.getAllTrips();// create a List to get the return result
		 Trips resTrips=TripsList.get(1);// find the 2nd element in the list
		 System.out.println(resTrips);//printout the 1st userName
*/		

		Projects pro=Projects.getbyProjectId(1);
		Date dat=new Date();
		Trips trip=new Trips(pro, dat, dat, "Expense");
		trip.save();
		//System.out.println(trip.getAllEmployeeOfThisTrip().get(0));

		//trip.add("2222", dat);
		
/*		Trips trip=new Trips();
		trip=trip.getbyTripId(1);
		try {
			System.out.println(trip.getDescriptionInString());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
