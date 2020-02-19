import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateDB extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ssn");
			int rollno = Integer.parseInt(request.getParameter("rollno"));
			String name = request.getParameter("name");
			int marks = Integer.parseInt(request.getParameter("marks"));
			String sql = "update student set name=?,marks=? where rollno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3,rollno);
			ps.setString(1,name);
			ps.setInt(2,marks);
			ps.execute();
			out.println("<br><br><br>Data updated successfully<br>");
		}
		catch (Exception e) {
			out.println("<br><br><br>Data not updated<br>");
         	}
         	out.println("</body></html>");
         }
}
      
        	
