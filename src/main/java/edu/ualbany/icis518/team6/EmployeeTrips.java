package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity 
@Table (name = "EmployeeTrips")
public class EmployeeTrips {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "empltripId")
	private int empltripId;	
	@ManyToOne
    @JoinColumn(name="project_id")
	private Trips etrip;
    @ManyToOne
    @JoinColumn(name="empl_id")
	private Employee Empl;
    

	public int getEmpltripId() {
		return empltripId;
	}
	public void setEmpltripId(int empltripId) {
		this.empltripId = empltripId;
	}
	public Trips getProject() {
		return etrip;
	}
	public void setProject(Trips project) {
		this.etrip = project;
	}
	public Employee getEmpl() {
		return Empl;
	}
	public void setEmpl(Employee empl) {
		Empl = empl;
	}
	@Override
	public String toString() {
		return "EmployeeTrips [project=" + etrip + ", Empl=" + Empl + "]";
	}
	public void add(Employee emplin, Trips tripin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeTrips EP=new EmployeeTrips();
		EP.setProject(tripin);
		EP.setEmpl(emplin);


		session.save(EP);
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
	public EmployeeTrips getbyId( int Id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeTrips empltrip = session.get(EmployeeTrips.class, Id);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return empltrip;
	}
	public List<EmployeeTrips> getAllEmployeeTrips(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from EmployeeTrips";
	    Query query=session.createQuery(hql);
	    List<EmployeeTrips> EmployeeTripsList=query.list();
	    
	    for(EmployeeTrips EmployeeTrips:EmployeeTripsList){// if successfully get the Data, printout every result before return
	    	System.out.println(EmployeeTrips);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeTripsList;// return a List of the User object 
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
