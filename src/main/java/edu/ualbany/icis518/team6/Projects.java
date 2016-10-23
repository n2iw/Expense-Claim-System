package edu.ualbany.icis518.team6;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Table (name = "Projects")

public class Projects {
		
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "projectId")
	private int projectId;
	private int budget;
    @ManyToOne
    @JoinColumn(name="pm_id")
	private Employee Empl;
	private String projectName;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Employee getEmpl() {
		return Empl;
	}
	public void setEmpl(Employee empl) {
		Empl = empl;
	}

	
	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", budget=" + budget + ", Empl=" + Empl + ", projectName="
				+ projectName + "]";
	}
	public void add( String projectName, int budget, Employee emplin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Projects pp=new Projects();
		pp.setProjectName(projectName);
		pp.setBudget(budget);
		pp.setEmpl(emplin);


		session.save(pp);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
		
	public Projects getbyId( int projectId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Projects pro = session.get(Projects.class, projectId);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return pro;
	}

}
