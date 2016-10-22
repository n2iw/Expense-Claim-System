package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TripsData {

	public static void main(String[] args) {
		
		//Instantiate details of Trips class
		Trips trp = new Trips();
		trp.setTripId(701);
		trp.setProjectId(51);
		trp.setDescription("This is a trip to New York for ATM project");
	    trp.setStartDate("10-02-2016");
	    trp.setEndDate("10-01-2017");
					
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
				
		//Manage transaction
		session.beginTransaction();
		session.save(trp);
		session.getTransaction().commit();
		assert(true);
			
	}

}
