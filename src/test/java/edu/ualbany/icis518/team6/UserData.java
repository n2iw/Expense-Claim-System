package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserData {
	
	public static void main(String[] args) {
	
	User usa=new User();
	usa.add("huluobo", "213");
	// User have 4 functions, add, update, delete, getAllUser
	//a User have 3 property, userId, userName, password.
	//userId: you can't change this ,because it is a primary key with auto increment
	//userName you can call user.update to change this value
	//password you can call user.update to change this value
	//also there are 3 ways to call update(), check the code

	

	usa.setUserName("lailai");
	usa.setPassword("67890");
	usa.update("jinlai","nopw");
	//usb.update(usa);
	//usa.add(4, "kewu", "chishi");
	 
	//Example of getAllUser, notice: you need to have some Users in table first!
	/* List<User> UserList=usa.getAllUser();// create a List to get the return result
	 User resuser=UserList.get(0);// find the 1st element in the list
	 System.out.println("my name is: " + resuser.getUserName());//printout the 1st userName
*/
	 
	}	
}
