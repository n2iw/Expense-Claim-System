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

@SuppressWarnings("unused")
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
	private boolean deleted;
	/**
	 * without expenseId
	 * @param empl An Employee Object
	 * @param trip	An Trips Object
	 * @param amount int
	 * @param type String
	 * @param receipt String of file path
	 * @param status String, e.g. Approved, Rejected..
	 * @param deleteit true or false
	 */	
public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
@Override
public String toString() {
	return "Expense [expenseId=" + expenseId + ", Empl=" + Empl + ", trip=" + trip + ", type=" + type + ", amount="
			+ amount + ", status=" + status + ", receipt=" + receipt + ", deleted=" + deleted + "]";
}
/**
 * without expenseId
 * @param empl An Employee Object
 * @param trip	An Trips Object
 * @param amount int
 * @param type String
 * @param receipt String of file path
 * @param status String, e.g. Approved, Rejected..
 * @param deleteit true or false
 */	
public Expense(Employee empl, Trips trip, String type, int amount, String status, String receipt, boolean deleted) {
	super();
	Empl = empl;
	this.trip = trip;
	this.type = type;
	this.amount = amount;
	this.status = status;
	this.receipt = receipt;
	this.deleted = deleted;
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
	public boolean getdeleted() {
		return deleted;
	}
	public void setdeleted(boolean deleted) {
		this.deleted = deleted;
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
	/**
	 * get all Expenses for An Employee in one trip
	 * @param emplin An Employee Object
	 * @param tripin A Trips Object
	 * @return
	 */
	public static List<Expense> getbyEmployeeAndTrip(Employee emplin, Trips tripin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where trip_id=? and empl_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, tripin.getTripId());
	    query.setInteger(1, emplin.getEmployeeId());
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();

		session.getTransaction().commit();
		session.close();
		factory.close();
		return ExpenseList;
	}
	/**
	 * get all expenses of this tripId
	 * @param tripId tripId
	 * @return A List of Expense
	 */
	public static List<Expense> getbyTripId(int tripId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where trip_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, tripId);
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();

		session.getTransaction().commit();
		session.close();
		factory.close();
		return ExpenseList;
	}
	/**
	 * get all expenses of this trip
	 * @param tripin A Trips Object
	 * @return A List of Expense
	 */
	public static List<Expense> getbyTrip(Trips tripin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where trip_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, tripin.getTripId());
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();

		session.getTransaction().commit();
		session.close();
		factory.close();
		return ExpenseList;
	}
	/**
	 * get all  the expenses of this employeeId
	 * @param emplId  employeeId 
	 * @return a List of expense
	 */
	public static List<Expense> getbyEmployeeId(int emplId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where empl_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, emplId);
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();

		session.getTransaction().commit();
		session.close();
		factory.close();
		return ExpenseList;
	}
	
	/**
	 * get all  the expenses of this Employee
	 * @param emplin An Employee Object
	 * @return a List of expense
	 */
	public static List<Expense> getbyEmployee(Employee emplin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where empl_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, emplin.getEmployeeId());
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();

		session.getTransaction().commit();
		session.close();
		factory.close();
		return ExpenseList;
	}
	/**
	 * 
	 * @param expenseId
	 * @return
	 */
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
	    @SuppressWarnings("unchecked")
		List<Expense> ExpenseList=query.list();
	    
	    for(Expense Expense:ExpenseList){// if successfully get the Data, printout every result before return
	    	System.out.println(Expense);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ExpenseList;// return a List of the User object 
	}

	//This method will return list of expenses based on status.
	public static List<Expense> getbyStatus(String status){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
	    String hql="from Expense where status=? ";
	    Query query=session.createQuery(hql);
	    query.setString(0, status);
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
