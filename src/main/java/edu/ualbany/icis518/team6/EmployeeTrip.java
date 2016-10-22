package edu.ualbany.icis518.team6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeTrip {
	
	@Id
	private int projectId;
	private int employeeId;
	
	//projectID getters and setters
		public int getProjectId() {
			return projectId;
		}
		
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		
		//employeeId getters and setters
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
}
