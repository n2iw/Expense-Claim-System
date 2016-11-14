package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unused")
public class ExpTypeBudgetData {

	public static void main(String[] args) {
	//Instantiate details of Employee class

/*		ExpTypeBudget etb=new ExpTypeBudget("HR", "Hotel", 500);
		ExpTypeBudget etb2=new ExpTypeBudget("HR", "Flight", 800);
		ExpTypeBudget etb3=new ExpTypeBudget("Manager", "Food", 50);
		etb.save();
		etb2.setBudget(1000);
		etb2.save();
		etb3.setType("Car");
		etb3.save();*/
		
		//ExpTypeBudget etb=ExpTypeBudget.getbyPrimarykey(2);
		//System.out.println(etb);
		
		
		
		 List<ExpTypeBudget> ExpTypeBudgetList=ExpTypeBudget.getAllExpTypeBudget();// create a List to get the return result
		 ExpTypeBudget resExpTypeBudget=ExpTypeBudgetList.get(1);// find the 2nd element in the list
		 System.out.println(resExpTypeBudget);//printout the 1st userName

		
		
		
	}

}
