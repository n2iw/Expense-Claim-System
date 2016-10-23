package edu.ualbany.icis518.team6;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EMPLOYEE")
public class Employee {
	@Id  @GeneratedValue (strategy = GenerationType.AUTO)
	private long employeeId;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	
	//Saving Collections
	@ElementCollection //let hibernate know to treat this object as a list
	private Set<Projects> listOfProjects =new HashSet<Projects>();
	
/*	//Join projects table data
	@ElementCollection
	@JoinTable(name = "PROJECTS",
		joinColumns=@JoinColumn(name = "EmployeeId"))
	
	private Collection<Projects> listOfProjects = new ArrayList(Projects);
	public Collection<Projects> getlistOfProjects(){
		return listOfProjects;
	}
	*/
	
	//Autogenerated  getters and setters for listOfProjects
	public Set<Projects> getListOfProjects() {
		return listOfProjects;
	}
	public void setListOfProjects(Set<Projects> listOfProjects) {
		this.listOfProjects = listOfProjects;
	}
	
	
	//employeeID getters and setters
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	//firstName getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//lastName getters and setters
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//password getters and setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//role getters and setters
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	
	}
