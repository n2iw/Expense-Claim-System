package edu.ualbany.icis518.team6;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ExpenseType {
	
	@Id
	private int employeeTypeId;
	private String expenseType;
	private int budget;
	
	//employeeTypeId getters and setters
		public int getEmployeeTypeId() {
			return employeeTypeId;
		}
		
		public void setEmployeeTypeId(int employeeTypeId) {
			this.employeeTypeId = employeeTypeId;
		}
		
		//expenseType getters and setters
		public String getExpenseType() {
			return expenseType;
		}
		public void setExpenseType(String expenseType) {
			this.expenseType= expenseType;
		}
		//expenseType getters and setters
		public int getBudget() {
			return budget;
		}
		public void setBudget(int budget) {
			this.budget= budget;
		}
}
