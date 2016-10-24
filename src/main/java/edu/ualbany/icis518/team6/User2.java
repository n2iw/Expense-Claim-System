package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="user2")
public class User2 {
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)//  auto increment primary key
	private long userId;
	@Column(nullable = false, unique = false) //let userName not unique &  not nullable
	private String userName;
	private String password;	
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public long getUserId() {
		return userId;
	}
	/*public void setUserId(long id) {
		this.userId = id; // auto increment primary key, can't change
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User2(long userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User2(String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	public void delete(){
		Session session = factory.openSession();
		try {
			session.beginTransaction();

			session.delete(this);   
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
	}
	
	public void save() {		
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			
			session.save(this);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
	}
	
	public static User2 find(long userId) {
		//find user with userId and return that object
		return null;
	}
	
	public static List<User2> getAllUser(){
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from User";
	    Query query=session.createQuery(hql);
	    List<User2> UserList=query.list();
	    
	    for(User2 User:UserList){// if successfully get the Data, printout every result before return
	    	System.out.println(User);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    return UserList;// return a List of the User object 
	}
}
