package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeProjectData {

	public static void main(String[] args) {
		//Instantiate details of EmployeeProject class
		EmployeeProject emp_prj = new EmployeeProject(); 
		emp_prj.setProjectId(51);
		emp_prj.setEmployeeId(001);
					
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Manage transaction
		session.beginTransaction();
		session.save(emp_prj);
		session.getTransaction().commit();
		assert(true);
	}

}
