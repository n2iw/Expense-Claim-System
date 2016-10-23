package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class
		Employee emp = new Employee(); 
		emp.setEmployeeId(1);
		emp.setFirstName("Samantha");
		emp.setLastName("Ceasar");
		emp.setPassword("###");
		emp.setRole("Developer");
		
	
		//Use hibernate API //can add error handling later
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Manage transaction
		session.beginTransaction();
		session.save(emp);
		
		session.getTransaction().commit();
		//assert(true);
		session.close();
		
		//Retrieving objects using session.get
		emp = null;
		//new session object and start transaction
		session = factory.openSession();
		session.beginTransaction();
		emp = (Employee)session.get(Employee.class,1);
		System.out.println("Employee FirstName is" + emp.getFirstName()); //optional
		System.out.println("Employee LastName is" + emp.getLastName()); //optional
		System.out.println("Employee Role is" + emp.getRole()); //optional
		
		
	}

}
