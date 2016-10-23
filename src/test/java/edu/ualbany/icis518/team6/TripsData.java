package edu.ualbany.icis518.team6;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TripsData {

	public static void main(String[] args) {
		

		
		//		//Instantiate details of Trips class
		Trips trp = new Trips();
//		trp.setTripId(701);
//		trp.setProjectId(51);
//		trp.setDescription("This is a trip to New York for ATM project");
//	    trp.setStartDate("2016-12-1");
//	    trp.setEndDate("2017-10-1");
//					
		//Use hibernate API
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		//java.util.Date dt=new java.util.Date();
		//SimpleDateFormat sdf=new SimpleDateFormat("2015-10-22 ");

		trp.setStartDate("2016-10-22");
		
		//Manage transaction
		session.beginTransaction();
		session.save(trp);
		session.getTransaction().commit();
		assert(true);
			
	}

}
