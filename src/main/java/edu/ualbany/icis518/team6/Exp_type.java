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

@Entity 
@Table (name = "Exp_type")
public class Exp_type {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "Exp_typeId")
	private int Exp_typeId;	// primary key use only, no meaning
	private int employee_type_id;// this is the employee_type_id you need
	private String type;
	private int budget;

	/**
	 * this is the primary key
	 * @return int
	 */
	public int getExp_typeId() {
	return Exp_typeId;
}
/*public void setExp_typeId(int exp_typeId) {
	Exp_typeId = exp_typeId;
}*/
public int getEmployee_type_id() {
	return employee_type_id;
}
public void setEmployee_type_id(int employee_type_id) {
	this.employee_type_id = employee_type_id;
}
public String getType() {
	return type;
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

public void add(int employee_type_id, String type, int budget) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	Exp_type Ety=new Exp_type();
	Ety.setEmployee_type_id(employee_type_id);
	Ety.setType(type);
	Ety.setBudget(budget);

	session.save(Ety);
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
	public Exp_type getbyPrimarykey( int Exp_typeId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Exp_type expty = session.get(Exp_type.class, Exp_typeId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return expty;
	}
	public List<Exp_type> getAllExp_type(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Exp_type";
	    Query query=session.createQuery(hql);
	    List<Exp_type> Exp_typeList=query.list();
	    
	    for(Exp_type Exp_type:Exp_typeList){// if successfully get the Data, printout every result before return
	    	System.out.println(Exp_type);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return Exp_typeList;// return a List of the User object 
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
