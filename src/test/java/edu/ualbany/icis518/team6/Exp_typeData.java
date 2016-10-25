package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Exp_typeData {

	public static void main(String[] args) {
	//Instantiate details of Employee class


		
		
		 List<ExpTypeBudget> ExpTypeBudgetList=ExpTypeBudget.getAllExpTypeBudget();// create a List to get the return result
		 ExpTypeBudget resExpTypeBudget=ExpTypeBudgetList.get(1);// find the 2nd element in the list
		 System.out.println(resExpTypeBudget);//printout the 1st userName

		
		
		
	}

}
