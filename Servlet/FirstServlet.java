package servletjspexercises.servletclasses;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FirstServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter pwr = response.getWriter();
		pwr.println("<html>");
		pwr.println("<head>");
		pwr.println("<title>");
		pwr.println("FirstServletProgram");
		pwr.println("</title>");
		pwr.println("</head>");
		pwr.println("<body>");
		pwr.println("first Servlet Program");
		pwr.println("</body>");
		pwr.println("</html>");
		
	}
}
