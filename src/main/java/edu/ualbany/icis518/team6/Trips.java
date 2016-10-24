package edu.ualbany.icis518.team6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
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
	public Clob getDescription() {
		return description;
	}
	public String getDescriptionToString() throws SQLException, IOException {
	    
			String reString;      
	        Reader is = this.description.getCharacterStream(); 
	        BufferedReader br = new BufferedReader(is);  
	        String s = br.readLine();  
	        StringBuffer sb = new StringBuffer();  
	        while (s != null) {
	            sb.append(s);  
	            s = br.readLine();  
	        }  
	        reString = sb.toString();  
	        return reString; 

	}
	public void setDescription(Clob content) {
		this.description = content;
	}

	public void setDescription(String content) {
		try {
			this.description = new javax.sql.rowset.serial.SerialClob(content.toCharArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
	public void setTripId(int tripId) {
		this.tripId = tripId;
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



	@Override
	public String toString() {
		String des="";
		String st="";
		String ed="";
		st=this.DateToString(this.getStartDate());
		ed=this.DateToString(this.getEndDate());
		try {
			des=this.getDescriptionToString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return "Trips [tripId=" + tripId + ", description=" + des + ", startDate=" + st + ", endDate="
					+ ed + ", proj=" + proj + "]";

	}
	public void add( Clob description, Date startDate, Date endDate, Projects proin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Trips trip=new Trips();
		trip.setDescription(description);
		trip.setStartDate(startDate);
		trip.setEndDate(endDate);
		trip.setProj(proin);

		session.save(trip);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public void add( String description, Date startDate, Date endDate, Projects proin) throws SerialException, SQLException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Trips trip=new Trips();
		Clob content=new javax.sql.rowset.serial.SerialClob(description.toCharArray()); 
		trip.setDescription(content);
		trip.setStartDate(startDate);
		trip.setEndDate(endDate);
		trip.setProj(proin);

		session.save(trip);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public Trips getbyTripId( int tripId) {
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
	public List<Trips> getAllTrips(){
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
