package edu.ualbany.icis518.team6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Projects {
		
	@Id
	private int projectId;
	private int budget;
	private String projectName;
	private int pmId;
		
	//projectID getters and setters
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	//Budget getters and setters
		public int getBudget() {
			return budget;
		}
		public void setBudget(int budget) {
			this.budget = budget;
		}
			
	//projectName getters and setters
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	//projectID getters and setters
		public int getPmId() {
			return pmId;
		}
		public void setPmId(int pmId) {
			this.pmId = pmId;
		}

}
