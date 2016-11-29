package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
public class EmployeeTripstData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

		
/*		Employee emplin=Employee.getbyEmployeeId(5);
		Trips trip=Trips.getbyTripId(6);
		EmployeeTrips et=new EmployeeTrips(trip, emplin);
		et.setEmpl(Employee.getbyEmployeeId(4));
		et.save();*/
		
		//System.out.println(EmployeeTrips.getbyprimarykey(2));
		
		//Employee emp=Employee.getbyEmployeeId(4);
		//System.out.println(EmployeeTrips.getbyEmployee(emp).get(1));



		
		
/*		 List<EmployeeTrips> EmployeeTripsList=EmployeeTrips.getAllEmployeeTrips();// create a List to get the return result
		 EmployeeTrips resEmployeeTrips=EmployeeTripsList.get(1);// find the 2nd element in the list
		 System.out.println(resEmployeeTrips);//printout the 1st userName
*/		 //resEmployeeTrips.delete();
		 
	
/*		//Retrieving objects using session.get
		emp = null;
		//new session object and start transaction
		session = factory.openSession();
		session.beginTransaction();
		emp = (Employee)session.get(Employee.class,1);
	
		System.out.println("Employee FirstName is" + emp.getFirstName()); //optional
		System.out.println("Employee LastName is" + emp.getLastName()); //optional
		System.out.println("Employee Role is" + emp.getRole()); //optional
		
		*/
		
	}

}
