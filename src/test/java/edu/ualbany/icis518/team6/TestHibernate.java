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

		User2 uu=new User2();
		uu.setUserName("asd");
		uu.setPassword("3222");
		uu.save();
		
		/*User usa=new User();
		usa.add("James+", "noPW");*/

		
		/*UserDetail user = new UserDetail();
		user.add("apple", usa);
		user.add("pen", usa);
		user.add("applepen", usa);
		session.save(user);*/
	
/*		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();		
		session.beginTransaction();
		session.getTransaction().commit();*/
		assert(true);
	}
}
