package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
public class EmployeeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

		//Employee emp1 = new Employee("gautam","trisha", "trisha", "HR");
		/*Employee emp2 = new Employee("wan2","jinlai", "meiyou", "Manager");
		Employee emp3 = new Employee("wan3","jinlai", "meiyou", "Developer");
		Employee emp4 = new Employee("wan4","jinlai", "meiyou", "Developer");
		Employee emp5 = new Employee("wan5","jinlai", "meiyou", "Developer");
		*/
		//emp1.save();

		//emp1.setPassword("youlalalala");
		//emp1.save();
		
//		System.out.println(emp1.getEmployeeId());*/
		//System.out.println(Employee.getbyEmployeeId(3).getAllMyProjects().get(2));
		
/*		Employee empp=Employee.getbyEmployeeId(2);
		Projects proe=Projects.getbyProjectId(3);
		empp.setProject(proe);*/
		
/*		Employee empp=Employee.getbyEmployeeId(3);
		Trips trip=Trips.getbyTripId(2);
		System.out.println(empp.getAllMyTrips().get(0));
		//empp.setTrip(trip);
*/		
	
//		Employee empp=Employee.getbyEmployeeId(4);
//		System.out.println(empp.getAllMyExpense().get(0));
//		System.out.println(emp1.toString());
//		emp1.setPassword("meiyou");
//		emp1.save();
//		emp1=emp1.getbyId(1);
//		emp1.setRole("222");
//		emp1.save();
//		

		
/*		emp= emp.getbyId(3);
		emp.setPassword("gailetest");
		emp.save(emp);*/

		
//		 List<Employee> EmployeeList=emp.findbyName("%", "jinlai");// create a List to get the return result
//		 Employee resEmployee=EmployeeList.get(1);// find the 2nd element in the list
//		 System.out.println(resEmployee);//printout the 1st userName
		
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
