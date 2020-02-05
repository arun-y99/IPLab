import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Second extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>WELCOME</head><body>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ssn");
			out.println("<p>Connected</p><br><br>");
			
			String sql = "insert into student values(10,'Holmes',100)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			
			Statement stmt = con.createStatement();
			sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			int id,marks;
			String name;
			while(rs.next()) {
				id = rs.getInt("rollno");
				name = rs.getString("name");
				marks = rs.getInt("marks");
				out.println("<p>Rollno " + id + "<br>Name " + name + "<br>Marks " + marks + "<br><br>");
			}
			con.close();
		} catch (Exception e) {
			out.println("<p>Not Connected</p><br><br>");
		}
	}
}
