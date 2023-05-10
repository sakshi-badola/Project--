import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<form action='ValidateSign'  style='text-align: centre;margin-left: 10cm;'>");
		out.println("<h1 >Welcome to User Management Systems</h1>");
		out.println("<html><head><link rel='stylesheet'     href= ' css.css'>");

		out.println("<table>" + "<tr>"

				+ "<td><b> Name<b>:</td><td> <input type='text' name='first' required><br></td></tr>"
				+ "<tr><td><b>Email Address</b>:</td><td><input type='email' name='email' required><br></td></tr>"
				+ "<tr><td><b>Mobile Number</b>:</td><td><input type='number' name='number' required><br></td></tr>"
				+ "<tr><td><b>Password</b>:</td><td> <input type='password'  name='password' required><br></td></tr>"
				+ "<tr><td><b>Repeat Password</b></td><td><input type='password'   name='psw-repeat' required><br></td></tr>"
				+ "<tr><td><input type='checkbox' checked='checked' name='remember' style='margin-bottom:15px color:blue'> Remember me</td>"
				+ "<td><br><br>&emsp;&emsp;<button  class='button'><b>  Save  </b></button></td></tr>"
				+ "<tr><td><b>Already a user ?</b><A HREF='login'><b>LOGIN</b></A></td></tr>"

				+ "</table>");

		out.println("");
		out.println("</form>");

	}

}
