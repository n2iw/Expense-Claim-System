package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeProjectData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

		EmployeeProjects EP=new EmployeeProjects();
/*		Employee empl=new Employee();
		Projects pro=new Projects();
		
		empl=empl.getbyId(4);		
		pro=pro.getbyProjectId(3);*/
		
		
		//EP.add(empl, pro);



		
		
		 List<EmployeeProjects> EmployeeProjectsList=EP.getAllEmployeeProjects();// create a List to get the return result
		 EmployeeProjects resEmployeeProjects=EmployeeProjectsList.get(1);// find the 2nd element in the list
		 System.out.println(resEmployeeProjects);//printout the 1st userName

	
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