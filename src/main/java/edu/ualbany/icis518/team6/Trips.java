package edu.ualbany.icis518.team6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trips {

	@Id
	private int tripId;
	private int projectId;
	private String description;
	private String startDate;
	private String endDate;
	
	//tripId getters and setters
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	
	//projectId getters and setters
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	//description getters and setters
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//startDate getters and setters
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	//endDate getters and setters
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
