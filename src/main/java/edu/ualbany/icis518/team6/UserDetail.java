package edu.ualbany.icis518.team6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="userDetail")
public class UserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userDetailId")
	private long userDetailId;
	@Column(name = "userhasAnItem")
	private String userhasAnItem;
    @ManyToOne
    @JoinColumn(name="userId")
	private User user;
	public long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getUserhasAnItem() {
		return userhasAnItem;
	}
	public void setUserhasAnItem(String userhasAnItem) {
		this.userhasAnItem = userhasAnItem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", userDepartment=" + userhasAnItem + ", user=" + user
				+ "]";
	}
	public void add( String userhasAnItem, User userin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		UserDetail ud=new UserDetail();
		ud.setUserhasAnItem(userhasAnItem);
		ud.setUser(userin);

		session.save(ud);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
