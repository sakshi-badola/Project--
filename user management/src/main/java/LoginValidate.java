
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String passkey = request.getParameter("password");

		try {

			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Git", "postgres", "root");
			PreparedStatement ps = con
					.prepareStatement("select email, passkey from test_git  where email=? and passkey=?");
			ps.setString(1, email);
			ps.setString(2, passkey);
			ResultSet rs = ps.executeQuery();
			boolean st = rs.next();
			if (st) {
				request.getRequestDispatcher("uportal").forward(request, response);
			} else {
				out.println("Inavalid Email or Password ");
				request.getRequestDispatcher("login").include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
