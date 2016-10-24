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
@Table (name = "EmployeeProjects")
public class EmployeeProjects {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "emplproId")
	private int emplproId;	
	@ManyToOne
    @JoinColumn(name="project_id")
	private Projects project;
    @ManyToOne
    @JoinColumn(name="empl_id")
	private Employee Empl;
    
	public int getEmplproId() {
		return emplproId;
	}
	public void setEmplproId(int emplproId) {
		this.emplproId = emplproId;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}
	public Employee getEmpl() {
		return Empl;
	}
	public void setEmpl(Employee empl) {
		Empl = empl;
	}

	@Override
	public String toString() {
		return "emplproId :  " +emplproId+ "  "+Empl + "" + project + "";
	}
	/**
	 * 
	 * @param project used for get projectId
	 * @param empl used for get employeeId
	 */
	public EmployeeProjects(Projects project, Employee empl) {
		super();
		this.project = project;
		this.Empl = empl;
	}
	/**
	 * 
	 * @param project used for get projectId
	 * @param empl used for get employeeId
	 */
	public EmployeeProjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void save() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		if(this.getEmplproId()==0){
			session.save(this);
		}else{
			session.update(this);
		}
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
/**
 * the primary key of this EmployeeProjects table, no meaning
 * @param emplproId int
 * @return
 */
	public static EmployeeProjects getbyPrimaryId( int emplproId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeProjects emplpro = session.get(EmployeeProjects.class, emplproId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return emplpro;
	}
	/**
	 * Find all the info by a EmployeeId
	 * @param emplin An Employee Object
	 * @return a List of EmployeeProjects
	 * @author Jinlai
	 */
	public static List<EmployeeProjects> getbyEmployee(Employee emplin){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from EmployeeProjects where empl_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, emplin.getEmployeeId());
	    List<EmployeeProjects> EmployeeProjectsList=query.list();
	    
	    for(EmployeeProjects EmployeeProjects:EmployeeProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(EmployeeProjects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeProjectsList;// return a List of the User object 
	}
	/**
	 * Find all the info by a ProjectId
	 * @param projin An Projects Object
	 * @return a List of EmployeeProjects
	 * @author Jinlai
	 */
	public static List<EmployeeProjects> getbyProject(Projects projin){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from EmployeeProjects where project_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projin.getProjectId());
	    List<EmployeeProjects> EmployeeProjectsList=query.list();
	    
	    for(EmployeeProjects EmployeeProjects:EmployeeProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(EmployeeProjects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeProjectsList;
	}
	
	public static List<EmployeeProjects> getAllEmployeeProjects(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from EmployeeProjects";
	    Query query=session.createQuery(hql);
	    List<EmployeeProjects> EmployeeProjectsList=query.list();
	    
	    for(EmployeeProjects EmployeeProjects:EmployeeProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(EmployeeProjects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeProjectsList;// return a List of the User object 
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
