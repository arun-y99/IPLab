import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Update extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<form method=\'get\' action=\'updatedb\'>");
            	out.println("<table border='0' cellspacing='2' cellpadding='5'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan='2'>Update Student</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                out.println("<tr>");
                out.println("<td><label>rollno</label></td>");
                out.println("<td><input type='text' name='rollno'/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><label>Name</label></td>");
                out.println("<td><input type='text' name='name'/></td>");
                out.println("</tr>");
		out.println("<tr>");
                out.println("<td><label>marks</label></td>");
                out.println("<td><input type='text' name='marks'/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><input type='submit' value='Save' /></td>");
                out.println("<td><input type='reset' value='reset'/></td>");
                out.println("</tr>");
                out.println("</tbody>");
            	out.println("</table>");
        	out.println("</form></body></html>");
        
        }
}
