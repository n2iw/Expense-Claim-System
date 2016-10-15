package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {

	public static void main(String[] args) {
	}
	
	@Test
	public void testHibernate() {
		UserDetail user = new UserDetail();
		user.setUserID(533);
		user.setUserName("James");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		assert(true);
	}
}
