package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class
		Employee emp1 = new Employee(); 
		//emp1.setEmployeeId(001);
		emp1.setFirstName("Samantha");
		emp1.setLastName("Ceasar");
		emp1.setPassword("###");
		emp1.setRole("Developer");
		
	//	Employee emp2= new Employee(); 
	/*	emp2.setEmployeeId();
		emp2.setFirstName("Martin");
		emp2.setLastName("Chase");
		emp2.setPassword("###");
		emp2.setRole("Web Designer");
		
		Employee emp3= new Employee(); 
	//	emp2.setEmployeeId(001);
		emp3.setFirstName("Cheng");
		emp3.setLastName("Feng");
		emp3.setPassword("###");
		emp3.setRole("Programmer");
		
		*/
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Manage transaction
		session.beginTransaction();
		session.save(emp1);
		//session.save(emp2);
		//session.save(emp3);
		session.getTransaction().commit();
		assert(true);
	}

}
