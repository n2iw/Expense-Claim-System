package edu.ualbany.icis518.team6;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "Projects")

public class Projects {
		
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "projectId")
	private int projectId;
	private int budget;
	private String projectName;
	private int pmId;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
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
	public int getPmId() {
		return pmId;
	}
	public void setPmId(int pmId) {
		this.pmId = pmId;
	}
	
	
		


}
