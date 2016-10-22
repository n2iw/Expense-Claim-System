package edu.ualbany.icis518.team6;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "EMPLOYEE")
public class Employee {
	@Id
	private int employeeId;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	
	//employeeID getters and setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
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
