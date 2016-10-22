package edu.ualbany.icis518.team6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExpenseData {

	public static void main(String[] args) {
		
		//Instantiate details of Expense class
				Expense exp = new Expense(); 
				
				exp.setExpenseId(5001);
				exp.setEmployeeId(001);
				exp.setTripId(701);
				exp.setExpenseType("Food Expense");
				exp.setExpenseAmount(81);
				exp.setReceiptLink("Link/path of receipt");
				exp.setExpenseStatus("Approved");
				exp.setExpenseEditFlag(false);
							
				//Use hibernate API
				SessionFactory factory = new Configuration().configure().buildSessionFactory();
				Session session = factory.openSession();
				
				//Manage transaction
				session.beginTransaction();
				session.save(exp);
				session.getTransaction().commit();
				assert(true);		
	}

}
