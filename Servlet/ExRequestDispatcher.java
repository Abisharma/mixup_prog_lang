package servletjspexercises.servletclasses;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExRequestDispatcher
 */
//@WebServlet("/reqdispatch")
public class ExRequestDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExRequestDispatcher() {
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
		String ur;
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/reqdisinclude");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("uses of request dispatcher include");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		request.setAttribute("Rate of Unit", new Double(8.5));
		rd.include(request, response);
		pw.println("control coming back from ");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
