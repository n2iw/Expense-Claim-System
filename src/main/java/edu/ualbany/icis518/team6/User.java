package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="user")
public class User {
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)//  auto increment primary key
	private long userId;
	@Column(nullable = false, unique = false) //let userName not unique &  not nullable
	private String userName;
	private String password;	

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
	public User(long userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password) {
		super();
		//this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	public void add( String userName, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public void delete(long userId){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    User User=(User)session.get(User.class, Long.valueOf(userId));
	    
	    session.delete(User);   
	    session.getTransaction().commit();
	    session.close();
		factory.close();
	}
	
	public void update(User userin) {		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user=session.get(User.class, Long.valueOf(this.userId));
		user.setUserName(userin.getUserName());
		user.setPassword(userin.getPassword());
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void update() {		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user=session.get(User.class, Long.valueOf(this.userId));
		user.setUserName(this.userName);
		user.setPassword(this.password);
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void update(String userName, String password) {		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		User user=session.get(User.class, Long.valueOf(this.userId));
		user.setUserName(userName);
		user.setPassword(password);
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public List<User> getAllUser(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from User";
	    Query query=session.createQuery(hql);
	    List<User> UserList=query.list();
	    
	    for(User User:UserList){// if successfully get the Data, printout every result before return
	    	System.out.println(User);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return UserList;// return a List of the User object 
	}
}
