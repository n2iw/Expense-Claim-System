package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExpenseTypeData {

	public static void main(String[] args) {
		
		//Instantiate details of ExpenseType class
				ExpenseType exp_typ = new ExpenseType(); 
				exp_typ.setEmployeeTypeId(9001);
				exp_typ.setExpenseType("Food Expense");
				exp_typ.setBudget(8000);
									
				//Use hibernate API
				SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
						
				//Manage transaction
				session.beginTransaction();
				session.save(exp_typ);
				session.getTransaction().commit();
				assert(true);
	}

}
