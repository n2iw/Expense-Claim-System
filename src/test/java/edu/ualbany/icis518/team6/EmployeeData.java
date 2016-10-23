package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

		Employee emp = new Employee(); 
		emp.add("waneeee", "jinlai", "nopassword", "HR");
		emp.add("waneeee", "jinlai", "nopassword", "Manager");
		emp.add("waneeee", "jinlai", "nopassword", "oridinary");
		
		/*emp= emp.getbyId(6);
		emp.setPassword("12345678");
		emp.update(emp);
		System.out.println(emp);*/
		
		
		 List<Employee> EmployeeList=emp.getAllEmployee();// create a List to get the return result
		 Employee resEmployee=EmployeeList.get(0);// find the 1st element in the list
		 System.out.println(resEmployee);//printout the 1st userName
		
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
