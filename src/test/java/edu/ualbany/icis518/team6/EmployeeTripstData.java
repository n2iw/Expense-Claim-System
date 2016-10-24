package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeTripstData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

		EmployeeTrips ET=new EmployeeTrips();
		Employee emplin=new Employee();
		Trips tripin=new Trips();
		
		emplin=emplin.getbyId(2);
		tripin=tripin.getbyTripId(1);
		
		ET=ET.getbyId(1);
		ET.add(emplin, tripin);
		//ET.delete();


		
		
		 List<EmployeeTrips> EmployeeTripsList=ET.getAllEmployeeTrips();// create a List to get the return result
		 EmployeeTrips resEmployeeTrips=EmployeeTripsList.get(1);// find the 2nd element in the list
		 System.out.println(resEmployeeTrips);//printout the 1st userName
		 resEmployeeTrips.delete();
		 
	
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
