import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class First extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>WELCOME</head><body>Surprise!</body></html>");
	}
}
