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

@WebServlet("/Pass")
public class Pass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String passkey = request.getParameter("password");
		try {

			final String URL = "jdbc:postgresql://localhost:5432/Git";
			final String USER = "postgres";
			final String PASS = "root";

			Class.forName("org.postgresql.Driver");
			out.println("driver");

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			out.println("connection");
			PreparedStatement pst = conn.prepareStatement("update test_git set passkey=?  where email=?");
			ResultSet rs = pst.executeQuery();
			out.print("<b></b><A HREF='login'><b>Click Back To Login</b></A>");

		} catch (Exception e) {
			out.print(e);
		}
	}

}
