package edu.ualbany.icis518.team6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table (name = "Employee")
public class Employee {
	@Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int employeeId;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + this.employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + "]";
	}
	/**
	 * 
	 * @param firstName String
	 * @param lastName String
	 * @param password String
	 * @param role String
	 */	
public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param firstName String
 * @param lastName String
 * @param password String
 * @param role String
 */
	public Employee(String firstName, String lastName, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}
	/**
	 * e.g. (fisrtname, "%") (firstname, lastname)
	 * 
	 * @param firstname if you don't need this condition, input "%"
	 * @param lastname if you don't need this condition, input "%"
	 * @return a List of Employee. There are example code in EmployeeData.java
	 * @author Jinlai
	 */
	public static List<Employee> getbyEmployeeName(String firstname, String lastname){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    Query query=session.createQuery("from Employee where firstName=? and lastName=? ");
	    query.setString(0, firstname);
	    query.setString(1, lastname);
	    if(lastname=="%"){
	    	query=session.createQuery("from Employee where firstName=? ");
	    	query.setString(0, firstname);
	    }
	    if(firstname=="%"){
	    	query=session.createQuery("from Employee where lastName=? ");
	    	query.setString(0, lastname);
	    }

	    List<Employee> EmployeeList=query.list();
	    
	    for(Employee Employee:EmployeeList){// if successfully get the Data, printout every result before return
	    	System.out.println(Employee);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeList;
	}
	public void setProject(Projects proin){
		EmployeeProjects ep=new EmployeeProjects(proin, this);
		ep.save();
	}
	/**
	 * Find this employee's projects
	 * @return A List of Project
	 * @author Jinlai
	 */
	public List<Projects> getAllMyProjects(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
		
		List<EmployeeProjects> EP=EmployeeProjects.getbyEmployee(this);
		int i=EP.size();
		int a=0;
	    List<Projects> ProjectsList=new LinkedList<Projects>();
	    
	    for(EmployeeProjects EmployeeProjects:EP){// if successfully get the Data, printout every result before return
	    	ProjectsList.add(EmployeeProjects.getProject());
	    }
	    
/*	    while(i!=0){
	    	ProjectsList.add(EP.get(a).getProject());
	    }*/
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return ProjectsList;
	}
	/**
	 * 
	 * @param role String	 
	 * @return a List of Employee. There are example code in EmployeeData.java
	 * @author Jinlai
	 */
	public static List<Employee> getbyEmployeeRole(String role){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    Query query=session.createQuery("from Employee where role=?");
	    query.setString(0, role);
	    List<Employee> EmployeeList=query.list();
	    
	    for(Employee Employee:EmployeeList){// if successfully get the Data, printout every result before return
	    	System.out.println(Employee);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeList;
	}
	
	public void save() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		
		if(this.getEmployeeId()==0){
			session.save(this);
		}else{
			session.update(this);
		}
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}


	/**
	 * the employeeId is the primary key
	 * @param employeeId int
	 * @return an Employee Object
	 */
	public static Employee getbyEmployeeId( int employeeId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Employee empl = session.get(Employee.class, employeeId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return empl;
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
	 * @return a List of Employee.
	 */
	public static List<Employee> getAllEmployee(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from Employee";
	    Query query=session.createQuery(hql);
	    List<Employee> EmployeeList=query.list();
	    
	    for(Employee Employee:EmployeeList){// if successfully get the Data, printout every result before return
	    	System.out.println(Employee);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeList;
	}
	
}
