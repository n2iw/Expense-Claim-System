package edu.ualbany.icis518.team6;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity 
@Table (name = "EmployeeProjects")
public class EmployeeProjects {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "emplproId")
	private int emplproId;	
	@ManyToOne
    @JoinColumn(name="project_id")
	private Projects project;
    @ManyToOne
    @JoinColumn(name="empl_id")
	private Employee Empl;
    
	public int getEmplproId() {
		return emplproId;
	}
	public void setEmplproId(int emplproId) {
		this.emplproId = emplproId;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}
	public Employee getEmpl() {
		return Empl;
	}
	public void setEmpl(Employee empl) {
		Empl = empl;
	}
	@Override
	public String toString() {
		return "EmployeeProjects [project=" + project + ", Empl=" + Empl + "]";
	}
	public void add(Employee emplin, Projects proin) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeProjects EP=new EmployeeProjects();
		EP.setProject(proin);
		EP.setEmpl(emplin);


		session.save(EP);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public void update() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.update(this);

		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	public EmployeeProjects getbyId( int Id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		EmployeeProjects emplpro = session.get(EmployeeProjects.class, Id);

		session.getTransaction().commit();
		session.close();
		factory.close();
		return emplpro;
	}
	public List<EmployeeProjects> getAllEmployeeProjects(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    
	    String hql="from EmployeeProjects";
	    Query query=session.createQuery(hql);
	    List<EmployeeProjects> EmployeeProjectsList=query.list();
	    
	    for(EmployeeProjects EmployeeProjects:EmployeeProjectsList){// if successfully get the Data, printout every result before return
	    	System.out.println(EmployeeProjects);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    factory.close();
	    return EmployeeProjectsList;// return a List of the User object 
	}
	public void delete(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
	    	    
	    session.delete(this);   
	    session.getTransaction().commit();
	    session.close();
		factory.close();
	}
}
