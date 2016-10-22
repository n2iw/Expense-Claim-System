package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeTripData {

	public static void main(String[] args) {
		
		//Instantiate details of EmployeeTrip class
		EmployeeTrip emp_trp = new EmployeeTrip(); 
		emp_trp.setProjectId(51);
		emp_trp.setEmployeeId(001);
							
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
				
		//Manage transaction
		session.beginTransaction();
		session.save(emp_trp);
		session.getTransaction().commit();
		assert(true);
	}

}
