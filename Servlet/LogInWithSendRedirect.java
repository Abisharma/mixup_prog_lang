package servletjspexercises.servletclasses;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInWithSendRedirect
 */
//@WebServlet("/user")
public class LogInWithSendRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInWithSendRedirect() {
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
		//pw.println("tracking the error");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("validating the user with send redirect method");
		pw.println("</title>");
		pw.println("<body>");
		String user_name = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(user_name.equals("Abhishek") || password.equals("12345")) {
			response.sendRedirect("auth1");
		}
		else {
			response.sendRedirect("unauth");
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
