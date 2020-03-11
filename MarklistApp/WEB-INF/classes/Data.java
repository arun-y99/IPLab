import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Data extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>WELCOME</head><body>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ssn");
			out.println("<p>Connected</p><br><br>");
			
			String rid = request.getParameter("rid");
			//out.println(rid);

			Statement stmt = con.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			String id,marks,sub;
			String name;
			out.println("<table border='1'>");
			out.println("<tr><th>Rollno</th><th>Name</th><th>Subject</th><th>Marks</th></tr>");	
			while(rs.next()) {
				id = rs.getString("rollno");
				//out.println(id);
				name = rs.getString("name");
				marks = rs.getString("marks");
				sub = rs.getString("sub");
				if(Integer.parseInt(id) == Integer.parseInt(rid)) { 
					out.println("<tr><td>"+id+"</td><td>"+ name+"</td><td>"+sub+"</td><td>"+marks+"</td></tr>");
				}
			}
			out.println("</table></body></html>");
			con.close();
		} catch (Exception e) {
			out.println("<p>Not Connected</p><br><br>");
			out.println("</body></html>");
		}
	}
}

