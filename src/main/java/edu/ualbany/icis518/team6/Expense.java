package edu.ualbany.icis518.team6;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EXPENSE")
public class Expense {
	@Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int expenseId;
	
	private int employeeId;
	private int tripId;
	private String expenseType;
	private int expenseAmount;
	private String receiptLink;
	private String expenseStatus;
	private Boolean expenseEditFlag;

	

	//expenseID getters and setters
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	//employeeID getters and setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	//tripId getters and setters
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	
	//expenseType getters and setters
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	//expenseAmount getters and setters
	public int getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(int expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
		
	//receiptLink getters and setters
	public String getReceiptLink() {
		return receiptLink;
	}
	public void setReceiptLink(String receiptLink) {
		this.receiptLink = receiptLink;
	}
	
	//expenseStatus getters and setters
	public String getExpenseStatus() {
		return expenseStatus;
	}
	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}
		
	//expenseEditFlag getters and setters
	public Boolean getExpenseEditFlag() {
		return expenseEditFlag;
	}
	public void setExpenseEditFlag(Boolean expenseEditFlag) {
		this.expenseEditFlag = expenseEditFlag;
	}
				
}
