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
	private int amount ;
	private String type;
	private String status;
	private boolean editFlag;
	private String receipt;

	
	
	
	
	
public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * the expenseId is the primary key	
 * @param expenseId primary key
 * @param empl An Employee Object
 * @param trip	An Trips Object
 * @param amount int
 * @param type String
 * @param receipt String of file path
 * @param status String, e.g. Approved, Rejected..
 * @param editFlag true or false
 */

public Expense(int expenseId, Employee empl, Trips trip, int amount, String type, 
		String receipt, String status, boolean editFlag	) {
		super();
		this.expenseId = expenseId;
		this.Empl = empl;
		this.trip = trip;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.editFlag = editFlag;
		this.receipt = receipt;
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
public Expense( Employee empl, Trips trip, int amount, String type, 
		String receipt, String status, boolean editFlag	) {
		super();
		this.Empl = empl;
		this.trip = trip;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.editFlag = editFlag;
		this.receipt = receipt;
	}


@Override
public String toString() {
	return "Expense [expenseId=" + expenseId + ", Empl=" + Empl + ", trip=" + trip + ", amount=" + amount + ", type="
			+ type + ", status=" + status + ", editFlag=" + editFlag + ", receipt=" + receipt + "]";
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
		return editFlag;
	}
	public void setEditFlag(boolean editFlag) {
		this.editFlag = editFlag;
	}
///**
// * get a String path
// * @return a String
// */
//	public String getFilepathToString(){
//		return this.getReceipt().getPath();
//	}
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
	/**
	 * e.g. a filepath like d:\pic1.jpg
	 * @return a File type, contains the filepath
	 */
	public String getReceipt() {
		return receipt;
	}
/**
 * 
 * @param receipt String of file path
 */
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
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
	public void add(  Employee empl, Trips trip, int amount, String type, 
			String receipt, String status, boolean editFlag	) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Expense exp=new Expense();
		exp.setEmpl(empl);
		exp.setTrip(trip);
		exp.setAmount(amount);
		exp.setType(type);
		exp.setReceipt(receipt);
		exp.setStatus(status);
		exp.setEditFlag(editFlag);
		
		session.save(exp);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}	
	public void update() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		session.update(this);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public Expense getbyExpenseId( int expenseId) {
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
	public List<Expense> getAllExpense(){
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
