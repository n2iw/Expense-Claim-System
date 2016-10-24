package edu.ualbany.icis518.team6;

import java.util.HashSet;
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
/*	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}*///you can't change the auto increment primary key
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
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + "]";
	}
	/**
	 * e.g. (fisrtname, "%") (firstname, lastname)
	 * 
	 * @param firstname if you don't need this condition, input "%"
	 * @param lastname if you don't need this condition, input "%"
	 * @return a List of Employee. There are example code in EmployeeData.java
	 * @author Jinlai
	 */
	public List<Employee> findbyName(String firstname, String lastname){
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
	    return EmployeeList;// return a List of the User object 
	}
	/**
	 * 
	 * @param role String	 
	 * @return a List of Employee. There are example code in EmployeeData.java
	 * @author Jinlai
	 */
	public List<Employee> findbyRole(String role){
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
	    return EmployeeList;// return a List of the User object 
	}
	
	public void add( String firstName, String lastName, String password, String role) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Employee empl = new Employee();
		empl.setFirstName(firstName);
		empl.setLastName(lastName);
		empl.setPassword(password);
		empl.setRole(role);

		session.save(empl);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	/**
	 * Update the Employee's information to the Database
	 */
	public void update() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.update(this);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	/**
	 * insert the employee Object into database
	 * @param Employee 
	 * */
	public void save(Employee Employee ) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		
		session.save(Employee);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	/**
	 * the employeeId is the primary key
	 * @param employeeId int
	 * @return an Employee Object
	 */
	public Employee getbyId( int employeeId) {
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
	public List<Employee> getAllEmployee(){
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
	    return EmployeeList;// return a List of the User object 
	}
	}
