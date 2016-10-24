package edu.ualbany.icis518.team6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity 
@Table (name = "Expense")
public class Expense {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "expenseId")
	private int expenseId;
    @ManyToOne
    @JoinColumn(name="empl_id")
	private Employee Empl;
    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trips trip; 
    private String type;
	private int amount ;	
	private String status;
	private String receipt;
	private boolean deleteit;
	
public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * without expenseId
 * @param empl An Employee Object
 * @param trip	An Trips Object
 * @param amount int
 * @param type String
 * @param receipt String of file path
 * @param status String, e.g. Approved, Rejected..
 * @param editFlag true or false
 */
public Expense( Employee empl, Trips trip, String type, int amount, String status, 
		String receipt, boolean deleteit	) {
		super();
		this.Empl = empl;
		this.trip = trip;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.deleteit = deleteit;
		this.receipt = receipt;
	}



@Override
public String toString() {
	return "Expense [expenseId=" + expenseId + ", Empl=" + Empl + ", trip=" + trip + ", type=" + type + ", amount="
			+ amount + ", status=" + status + ", receipt=" + receipt + ", deleteit=" + deleteit + "]";
}
public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isEditFlag() {
		return deleteit;
	}
	public void setEditFlag(boolean deleteit) {
		this.deleteit = deleteit;
	}
	public Employee getEmpl() {
		return Empl;
	}
	public void setEmpl(Employee empl) {
		Empl = empl;
	}
	public Trips getTrip() {
		return trip;
	}
	public void setTrip(Trips trip) {
		this.trip = trip;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public int getExpenseId() {
		return expenseId;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	/**
	 * 
	 * @param empl An Employee Object
	 * @param trip	An Trips Object
	 * @param amount int
	 * @param type String
	 * @param receipt String of file path
	 * @param status String, e.g. Approved, Rejected..
	 * @param editFlag true or false
	 */
	public void save() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		if(this.getExpenseId()==0){
			session.save(this);
		}else{
			session.update(this);
		}
		session.getTransaction().commit();
		session.close();
		factory.close();
	}	

	public static Expense getbyExpenseId( int expenseId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Expense exp = session.get(Expense.class, expenseId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return exp;
	}
	public void delete(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    	    
	    session.delete(this);   
	    session.getTransaction().commit();
	    session.close();
		factory.close();
	}
	public static List<Expense> getAllExpense(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Expense";
	    Query query=session.createQuery(hql);
	    List<Expense> ExpenseList=query.list();
	    
	    for(Expense Expense:ExpenseList){// if successfully get the Data, printout every result before return
	    	System.out.println(Expense);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ExpenseList;// return a List of the User object 
	}
}
