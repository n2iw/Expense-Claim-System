package edu.ualbany.icis518.team6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
@Table (name = "Trips")
public class Trips {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "tripId")
	private int tripId;
	private Clob description;
	private Date startDate;
	private Date endDate;
    @ManyToOne
    @JoinColumn(name="proj_id")
	private Projects proj;
    
public Projects getProj() {
		return proj;
	}
	public void setProj(Projects proj) {
		this.proj = proj;
	}
/**
 * transform a String into a Date
 * @param stringin format"MM-dd-yyyy" e.g "10-24-2016"
 * 
 * @return a Date
 * @author Jinlai
 */
	public Date StringToDate(String stringin){

	    SimpleDateFormat stod = new SimpleDateFormat("MM-dd-yyyy"); 

	    Date dateexample=new Date();
		try {
			dateexample = stod.parse(stringin);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dateexample;
	      

	}
	/**
	 * transform a Date into a String.
	 * @param a Date format"MM-dd-yyyy" e.g "10-24-2016"
	 * @return a String, format"MM-dd-yyyy" e.g "10-24-2016"
	 * @author Jinlai
	 */
	public String DateToString(Date datein){

	    SimpleDateFormat Date = new SimpleDateFormat("MM-dd-yyyy");
	    
	    return Date.format(datein);

	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTripId() {
		return tripId;
	}

/*	public Clob getDescriptionInClob() {
		return description;
	}
	public void setDescription(Clob content) {
	this.description = content;
	}*/
	public String getDescription(){
	    
	    StringBuilder sb = new StringBuilder();
	    try {
	        Reader reader = description.getCharacterStream();
	        BufferedReader br = new BufferedReader(reader);

	        String line;
	        while(null != (line = br.readLine())) {
	            sb.append(line);
	        }
	        br.close();
	    } catch (SQLException e) {
	        // handle this exception
	    } catch (IOException e) {
	        // handle this exception
	    }
	    return sb.toString();
	}

	public void setDescription(String content) {
		try {
			this.description = new javax.sql.rowset.serial.SerialClob(content.toCharArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

/**
 * 
 * @param proj	A Projects Object, used for get projectId
 * @param startDate	A Date type
 * @param endDate A Date type
 * @param description String
 */
	public Trips( Projects proj, Date startDate, Date endDate, String description ) {
		super();
		this.setDescription(description);
		this.startDate = startDate;
		this.endDate = endDate;
		this.proj = proj;
	}
	/**
	 * 
	 * @param proj	A Projects Object, to get projectId
	 * @param startDate	A Date type
	 * @param endDate A Date type
	 * @param description String
	 */	
	public Trips() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String des="";
		String st="";
		String ed="";
		st=this.DateToString(this.getStartDate());
		ed=this.DateToString(this.getEndDate());
		des=this.getDescription();

			return "Trips [tripId=" + tripId + ", description=" + des + ", startDate=" + st + ", endDate="
					+ ed + ", proj=" + proj + "]";

	}
	/**
	 * get All the employee objects that in this trip
	 * @return a List of Employee
	 * @author Jinlai
	 */
	public List<Employee> getAllEmployeeOfThisTrip(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
		
		List<EmployeeTrips> ET=EmployeeTrips.getbyTrip(this);

	    List<Employee> EmployeeList=new LinkedList<Employee>();
	    
	    for(EmployeeTrips EmployeeTrips:ET){// if successfully get the Data, printout every result before return
	    	EmployeeList.add(EmployeeTrips.getEmpl());
	    }

	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeList;
	}
	
	public void save(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		if(this.getTripId()==0){
			session.save(this);
		}else{
			session.update(this);
		}
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public static Trips getbyTripId( int tripId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Trips tri = session.get(Trips.class, tripId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return tri;
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
	/**
	 * get all trips of this project
	 * @param projin A project Object
	 * @return a List of Trip
	 */
	public static List<Trips> getbyProject(Projects projin){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Trips where project_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projin.getProjectId());
	    List<Trips> TripsList=query.list();
	    
	    for(Trips Trips:TripsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Trips);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return TripsList;
	}
	/**
	 * get all trips of this projectId
	 * @param projectId A projectId
	 * @return  a List of Trip
	 */
	public static List<Trips> getbyProjectId(int projectId){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Trips where project_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projectId);
	    List<Trips> TripsList=query.list();
	    
	    for(Trips Trips:TripsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Trips);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return TripsList;
	}
	public static List<Trips> getAllTrips(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Trips";
	    Query query=session.createQuery(hql);
	    List<Trips> TripsList=query.list();
	    
	    for(Trips Trips:TripsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Trips);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return TripsList;// return a List of the User object 
	}
}
