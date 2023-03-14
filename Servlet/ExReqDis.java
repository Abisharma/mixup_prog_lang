package servletjspexercises.servletclasses;

import java.io.IOException;
import javax.servlet.ServletException;
//import java.x.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExReqDis
 */
//@WebServlet("/RequestDispatcherfr")
public class ExReqDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExReqDis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("forwarding the request for another servlet");
		RequestDispatcher rd = request.getRequestDispatcher("requestDispatcherForward");
		request.setAttribute("unit of rate", new Double(9.5));
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
