package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Table (name = "Projects")

public class Projects {
		
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "projectId")
	private int projectId;
	private int budget;
    @ManyToOne
    @JoinColumn(name="pm_id")
	private Employee Empl;
	private String projectName;
	
	public int getProjectId() {
		return projectId;
	}
/*	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}*///you can't change the auto increment primary key
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Employee getProjectManager() {
		return Empl;
	}
	public void setProjectManager(Employee empl) {
		Empl = empl;
	}


	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", budget=" + budget + ", Empl=" + Empl + ", projectName="
				+ projectName + "]";
	}
/**
 * 
 * @param projectManager An Employee Object
 * @param projectName String name of projectName
 * @param budget int
 */
	public Projects( Employee projectManager, String projectName, int budget) {
		super();
		this.budget = budget;
		this.Empl = projectManager;
		this.projectName = projectName;
	}
	/**
	 * 
	 * @param projectManager An Employee Object
	 * @param projectName String name of projectName
	 * @param budget int
	 */
	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void save() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		if(this.getProjectId()==0){
			session.save(this);
		}else{
			session.update(this);
		}

		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	/**
	 * Projects{projectId, projectName, budget, pm_id}
	 * @param projectId this is the primary key for table Projects
	 * @return A Projects Object
	 */
	public static Projects getbyProjectId( int projectId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Projects pro = session.get(Projects.class, projectId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return pro;
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
	public static List<Projects> getAllProjects(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects";
	    Query query=session.createQuery(hql);
	    List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;// return a List of the User object 
	}
	/**
	 * 
	 * @param projectName String
	 * @return a List of Projects. There are example code in ProjectsData.java
	 * @author Jinlai
	 */
	public static List<Projects> findbyProjectName(String projectName){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects where projectName=? ";
	    Query query=session.createQuery(hql);
	    query.setString(0, projectName);
	    List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;// return a List of the User object 
	}
/**
 * 
 * @param projectManager An Employee Object
 * @return a List of Projects. There are example code in ProjectsData.java
 * @author Jinlai
 */
	public static List<Projects> findbyPM_Id(Employee projectManager){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects where pm_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projectManager.getEmployeeId());
	    List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;// return a List of the User object 
	}
}
