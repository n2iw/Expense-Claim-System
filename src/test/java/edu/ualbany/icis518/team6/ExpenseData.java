package edu.ualbany.icis518.team6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExpenseData {

	public static void main(String[] args) throws SerialException, SQLException, IOException {
		
		
/*		Employee empl=Employee.getbyEmployeeId(4);
		Trips trip=Trips.getbyTripId(5);
		Trips trip2=Trips.getbyTripId(6);
		Expense expp=new Expense(empl, trip, "food", 50, "go", "none", true);
		Expense expp1=new Expense(empl, trip, "hotel", 250, "go", "none", true);
		Expense expp11=new Expense(empl, trip, "car", 100, "go", "none", true);
		Expense expp2=new Expense(empl, trip2, "food", 20, "go", "none", true);
		Expense expp22=new Expense(empl, trip2, "hotel", 200, "go", "none", true);
		expp.save();
		expp1.save();
		expp11.save();
		expp2.setStatus("update");
		expp2.save();
		expp22.setType("flight");
		expp22.save();*/
		
		//Expense exp=Expense.getbyExpenseId(4);
		//System.out.println(exp);
		
		 List<Expense> ExpenseList=Expense.getAllExpense();// create a List to get the return result
		 Expense resExpense=ExpenseList.get(4);// find the 2nd element in the list
		 System.out.println(resExpense);//printout the 1st userName
		
		
/*		Blob b;
		FileOutputStream out=new FileOutputStream(new File("d:/pic1.jpg"));
		out.write(b.getBytes(1, (int)b.length()));
		out.close();
		
		File pic=book.getPic(); // 用来保存的
		InputStream inputStream2=new FileInputStream(pic);
		pstmt.setBinaryStream(6, inputStream2, pic.length()); 
		
		
		

		
		Book book=new Book("helloWorld", 100, "小锋", 1,context,pic);*/
		
		

	}
}
