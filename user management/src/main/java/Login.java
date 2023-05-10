
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>" + "");
		out.println("<html><head><link rel='stylesheet'     href= ' css.css'>");
		out.println("<boby><form  id='f1' action='LoginValidate' method='post''></form>");
		out.println("<form id='f2' action='signup' method='post'></form>");

		out.println("<centre><h1 >Welcome to User Management Systems</h1></center>");
		out.println("<table class='t1'>"
				+ "<tr><td><b>Email Address</b>:</td><td><input type='email' name='email' required><br></td></tr>"
				+ "<tr><td><b>Password</b>:</td><td> <input type='password'  name='password' required><br></td></tr>"
				+ "<tr><td><input type='checkbox' checked='checked' name='remember' style='margin-bottom:15px color:blue'> Remember me</td>"
				+ "<tr ><td><button  form='f1' class='button' style='padding: 5px 10px;  '>Log In</button><center></td></tr>"
				+ "<tr><td><b>forgot  ?</b><A HREF='password.html'><b>password</b></A></td></tr>");

		out.println(
				"<tr><td><button  form='f2' class='button' style='padding: 5px 10px;  '>new user ? Sign Up</button><center></td></tr>");
		out.println("</table></form></body></html>");

	}
}
