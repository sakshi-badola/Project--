
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

@WebServlet("/ValidateSign")
public class ValidateSign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String first = request.getParameter("name");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String passkey = request.getParameter("password");
		String repass = request.getParameter("psw-repeat");

		try {

			final String URL = "jdbc:postgresql://localhost:5432/Git";
			final String USER = "postgres";
			final String PASS = "root";

			Class.forName("org.postgresql.Driver");
			out.println("driver");

			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			out.println("connection");
			PreparedStatement pst = conn.prepareStatement(
					"insert into  test_git (id, name, email, mobile_no ,passkey, check_admin) values(?,?,?,?,?,?)");
			pst.setInt(1, 1);
			pst.setString(2, first);
			pst.setString(3, email);
			pst.setString(4, number);
			pst.setString(5, passkey);
			pst.setString(6, " ");

			ResultSet rs = pst.executeQuery();
			if (rs.next())
				out.println("sucessfully enterd details");
			request.getRequestDispatcher("login").include(request, response);

		} catch (Exception e) {
			out.println(e);
		}
	}
}
