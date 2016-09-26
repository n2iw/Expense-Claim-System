package edu.ualbany.icis518.team6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=new User(userName,password);
		if (userName.equals("empl")&(password.equals("empl1"))){
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user);
			request.getRequestDispatcher("employee.jsp").forward(request, response);
			
		}else if(userName.equals("mgr")&(password.equals("mgr1"))){
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", user);
			request.getRequestDispatcher("manager.jsp").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
	}

}
