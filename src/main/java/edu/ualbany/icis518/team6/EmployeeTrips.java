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
    @JoinColumn(name="trip_id")
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
		return "empltripId :  " +empltripId+ "  "+Empl + "" + etrip + "";
	}
/**
 * 
 * @param Trips A Trips Object
 * @param Employee A Employee Object
 */
	public EmployeeTrips(Trips Trips, Employee Employee) {
		super();
		this.etrip = Trips;
		this.Empl = Employee;
	}
	/**
	 * 
	 * @param Trips A Trips Object
	 * @param Employee A Employee Object
	 */
	public EmployeeTrips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void save() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		if(this.getEmpltripId()==0){
			session.save(this);
		}else{
			session.update(this);
		}
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	public static EmployeeTrips getbyprimarykey( int empltripId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeTrips empltrip = session.get(EmployeeTrips.class, empltripId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return empltrip;
	}
	public static List<EmployeeTrips> getAllEmployeeTrips(){
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
