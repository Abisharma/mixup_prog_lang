package servletjspexercises.servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllNamesFromHtmlFile
 */
//@WebServlet("/GetAllNamesFromHtmlFile")
public class GetAllNamesFromHtmlFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllNamesFromHtmlFile() {
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
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("get all names from html file");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		Enumeration all_Names= request.getParameterNames();
		while(all_Names.hasMoreElements()) {
			String name = (String)all_Names.nextElement();
			pw.println("html name is  :"+ name + " value of the name is  :" + request.getParameter(name)
			+"<br/>");
					
		}
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
