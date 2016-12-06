package edu.ualbany.icis518.team6;

import java.util.LinkedList;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
@Entity 
@Table (name = "Projects")

public class Projects {
		
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "projectId")
	private int projectId;
	private int budget;
	private int currentBudget;  //added 
	
	
    @ManyToOne
    @JoinColumn(name="pm_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
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
	
	//added later
	
	public int getCurrentBudget() {
	    
		return currentBudget;
	}
	public void setCurrentBudget(int currentBudget) {
		
		
		this.currentBudget = currentBudget;
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
		return "Projects [projectId=" + projectId + ", budget=" + budget + ", currentBudget= " + currentBudget +",Empl=" + Empl + ", projectName="
				+ projectName + "]";
	}
/**
 * 
 * @param projectManager An Employee Object
 * @param projectName String name of projectName
 * @param budget int
 * @param currentBudget int  //added later
 */
	public Projects( Employee projectManager, String projectName, int budget, int currentBudget) {
		super();
		this.budget = budget;
		this.currentBudget =currentBudget;   //added later
		this.Empl = projectManager;
		this.projectName = projectName;
	}
	/**
	 * 
	 * @param projectManager An Employee Object
	 * @param projectName String name of projectName
	 * @param budget int
	 * @param currentBudget int
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
	 * Projects{projectId, projectName, budget, currentBudget, pm_id}
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
	/**
	 * 
	 * @return a List of Projects
	 */
	public static List<Projects> getAllProjects(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects";
	    Query query=session.createQuery(hql);
	    @SuppressWarnings("unchecked")
		List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;
	}
	/**
	 * add a Employee to this project
	 * @param emplin An Employee Object
	 */
	public void setEmployee(Employee emplin){
		EmployeeProjects ep=new EmployeeProjects(this, emplin);
		ep.save();
	}
	/**
	 * get All the employee objects that in this project
	 * @return a List of Employee
	 * @author Jinlai
	 */
	public List<Employee> getAllEmployeeOfThisProject(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
		List<EmployeeProjects> EP=EmployeeProjects.getbyProject(this);

	    List<Employee> EmployeeList=new LinkedList<Employee>();
	    
	    for(EmployeeProjects EmployeeProjects:EP){// if successfully get the Data, printout every result before return
	    	EmployeeList.add(EmployeeProjects.getEmpl());
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeList;
	}
	/**
	 * 
	 * @param projectName String
	 * @return a List of Projects. There are example code in ProjectsData.java
	 * @author Jinlai
	 */
	public static List<Projects> getbyProjectName(String projectName){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects where projectName=? ";
	    Query query=session.createQuery(hql);
	    query.setString(0, projectName);
	    @SuppressWarnings("unchecked")
		List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;
	}
/**
 * 
 * @param projectManager An Employee Object
 * @return a List of Projects. There are example code in ProjectsData.java
 * @author Jinlai
 */
	public static List<Projects> getbyProjectManager(Employee projectManager){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects where pm_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projectManager.getEmployeeId());
	    @SuppressWarnings("unchecked")
		List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;
	}
	/**
	 * 
	 * @param projectManagerId the pm_id, which actually is a Employee.employeeId
	 * @return a List of Projects.
	 * @author Jinlai
	 */
	public static List<Projects> getbyProjectManagerId(int projectManagerId){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Projects where pm_id=? ";
	    Query query=session.createQuery(hql);
	    query.setInteger(0, projectManagerId);
	    @SuppressWarnings("unchecked")
		List<Projects> ProjectsList=query.list();
	    
	    for(Projects Projects:ProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(Projects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;
	}
}
