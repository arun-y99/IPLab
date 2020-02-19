import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsertDB extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ssn");
			int rollno = Integer.parseInt(request.getParameter("rollno"));
			String name = request.getParameter("name");
			int marks = Integer.parseInt(request.getParameter("marks"));
			String sql = "insert into student values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,rollno);
			ps.setString(2,name);
			ps.setInt(3,marks);
			ps.execute();
			out.println("<br><br><br>Data inserted successfully<br>");
		}
		catch (Exception e) {
			out.println("<br><br><br>Data not updated<br>");
         	}
         	out.println("</body></html>");
         }
}
      
        	
