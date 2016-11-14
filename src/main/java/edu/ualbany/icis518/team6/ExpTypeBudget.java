package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
@Entity 
@Table (name = "ExpTypeBudget")
public class ExpTypeBudget {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "Exp_typeId")
	private int Exp_typeId;	// primary key use only, no meaning
	private String role;
	private String type;
	private int budget;

	/**
	 * this is the primary key
	 * @return int
	 */
	public int getExp_typeId() {
	return Exp_typeId;
}

public String getType() {
	return type;
}
public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public void setType(String type) {
	this.type = type;
}
public int getBudget() {
	return budget;
}
public void setBudget(int budget) {
	this.budget = budget;
}

@Override
public String toString() {
	return "ExpTypeBudget [Exp_typeId=" + Exp_typeId + ", role=" + role + ", type=" + type + ", budget=" + budget + "]";
}

/**
 * 
 * @param role String
 * @param type String
 * @param budget int
 */
public ExpTypeBudget(String role, String type, int budget) {
	super();
	this.role = role;
	this.type = type;
	this.budget = budget;
}
/**
 * 
 * @param role String
 * @param type String
 * @param budget int
 */
public ExpTypeBudget() {
	super();
	// TODO Auto-generated constructor stub
}

public void save() {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	if(this.getExp_typeId()==0){
		session.save(this);
	}else{
		session.update(this);
	}
	
	session.getTransaction().commit();
	session.close();
	factory.close();
}

/**
 * Exp_typeId is the primary key, no meaning
 * @param Exp_typeId
 * @return
 */
	public static ExpTypeBudget getbyPrimarykey( int Exp_typeId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		ExpTypeBudget expty = session.get(ExpTypeBudget.class, Exp_typeId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return expty;
	}
	public static List<ExpTypeBudget> getAllExpTypeBudget(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from ExpTypeBudget";
	    Query query=session.createQuery(hql);
	    @SuppressWarnings("unchecked")
		List<ExpTypeBudget> ExpTypeBudgetList=query.list();
	    
	    for(ExpTypeBudget ExpTypeBudget:ExpTypeBudgetList){// if successfully get the Data, printout every result before return
	    	System.out.println(ExpTypeBudget);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ExpTypeBudgetList;// return a List of the User object 
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
}
