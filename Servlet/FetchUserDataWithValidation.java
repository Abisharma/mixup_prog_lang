package servletjspexercises.servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchUserDataWithValidation
 */
//@WebServlet("/UserValidation")
public class FetchUserDataWithValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchUserDataWithValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null && password != null) {
			
			if(username.equals("pradeep")) {
			//pw.println("user name : "+ request.getParameter("username"));
			//pw.println("password : " + request.getParameter("password"));
				
				pw.println("you are a valid user");
			}
			else
			{
				pw.println("you are not a valid user");
			}
			
		}
		
		else {
			pw.println("enter the both value");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
