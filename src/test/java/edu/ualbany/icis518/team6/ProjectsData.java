package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectsData {

	public static void main(String[] args) {
		//Instantiate details of Projects class
		Projects prj = new Projects(); 
		prj.setProjectId(51);
		prj.setBudget(5000);
		prj.setProjectName("ATM");
		prj.setPmId(1001);
			
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//Manage transaction
		session.beginTransaction();
		session.save(prj);
		session.getTransaction().commit();
		assert(true);
	}
		
}
