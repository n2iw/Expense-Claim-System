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
		
		Expense expp=new Expense();
		Employee empl=new Employee();
		Trips trip=new Trips();
		
		empl=empl.getbyId(3);
		trip=trip.getbyTripId(2);
				
		File save=new File("D:/pic1.txt");
		
		//expp.add(empl, trip, 900, "Hotel", save, "good", true);
		
		
		


		
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
