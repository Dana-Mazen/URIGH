package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class RegisterDoctorServlet
 */
@WebServlet("/RegisterDoctorServlet")
public class RegisterDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String fullName = request.getParameter("fullName");
	        String contactNumber = request.getParameter("contactNumber");
	        String email = request.getParameter("email");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(
	                "", "", "");

	            String sql = "INSERT INTO user (full_name, contact_number, email, username, password, is_active, role) "
	                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, fullName);
	            stmt.setString(2, contactNumber);
	            stmt.setString(3, email);
	            stmt.setString(4, username);
	            stmt.setString(5, password);
	            stmt.setBoolean(6, true); // is_active
	            stmt.setString(7, "DOCTOR");

	            int rows = stmt.executeUpdate();

	            if (rows > 0) {
	                response.sendRedirect("login.jsp");
	            } else {
	                response.sendRedirect("error.jsp");
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
	    
	}

}
