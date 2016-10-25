package edu.ualbany.icis518.team6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectsData {

	public static void main(String[] args) {
//		//Instantiate details of Projects class
//		Projects prj = new Projects(); 
//		prj.setProjectId(51);
//		prj.setBudget(8000);
//		prj.setProjectName("ATM");
//		prj.setPmId(1001);
//			
//		//Use hibernate API
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//		
//		//Manage transaction
//		session.beginTransaction();
//		session.save(prj);
//		session.getTransaction().commit();
//		assert(true);
/*		Employee emp = new Employee(); 
		emp=emp.getbyEmployeeId(2);
		Projects pnew=new Projects(emp, "Sys2", 4000);
		pnew.save();*/
		
		Projects pro=Projects.getbyProjectId(2);
		System.out.println(pro.getAllEmployeeOfThisProject().get(3));

//		pnew.save();
//		pnew.setBudget(10000);
//		pnew.save();
//		pnew=pnew.getbyProjectId(1);
//		pnew.setBudget(4321);
//		pnew.update();
		//pnew.add("System four", 100500, emp);		
//		pnew=pnew.getbyProjectId(5);
//		pnew.delete();*/
//		pnew.setpm_id(emp);
//		pnew.setBudget(760000);
//		pnew.update();*/*/
//		EmployeeProjects Epp=new EmployeeProjects();
//		Epp.add(emp, pnew);

//		 List<Projects> ProjectsList=pnew.findbyEmployeeId(emp);// create a List to get the return result
//		 Projects resProjects=ProjectsList.get(0);// find the 2nd element in the list
//		 System.out.println(resProjects);//printout the 1st userName
		
		
	}
		
}
