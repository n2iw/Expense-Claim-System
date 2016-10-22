package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class
		Employee emp = new Employee(); 
		emp.setEmployeeId(001);
		emp.setFirstName("Samantha");
		emp.setLastName("Ceasar");
		emp.setPassword("###");
		emp.setRole("Developer");
		
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Manage transaction
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		assert(true);
	}

}
