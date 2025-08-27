package servlet;
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterPatientServlet
 */
@WebServlet("/RegisterPatientServlet")
public class RegisterPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPatientServlet() {
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
		 //read form data
        String fullName = request.getParameter("fullName");
        String contactNumber = request.getParameter("contactNumber");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String emergencyContact = request.getParameter("emergencyContact");
        String preferredCommunicationMethod = request.getParameter("preferredCommunicationMethod");
        String language = request.getParameter("language");

        boolean notificationsEnabled = request.getParameter("notificationsEnabled") != null;
        boolean darkModeEnabled = request.getParameter("darkModeEnabled") != null;
        boolean shareDataWithThirdParties = request.getParameter("shareDataWithThirdParties") != null;
        boolean healthDataVisible = request.getParameter("healthDataVisible") != null;
        
        String address = request.getParameter("address");
        String blood_type = request.getParameter("blood_type");
        String allergies = request.getParameter("allergies");
        String medical_history = request.getParameter("medical_history");
        String current_medication = request.getParameter("current_medication");
        String doctor_email = request.getParameter("doctor_email");
        
        try {
            // Connect to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection("", "", "");

            String sql = "INSERT INTO user (full_name, contact_number, email, username, password, emergency_contact, preferred_communication_method, language, notifications_enabled, dark_mode_enabled, share_data_with_third_parties, health_data_visible, is_active, role, address, blood_type, allergies, medical_history, current_medication, doctor_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullName);
            stmt.setString(2, contactNumber);
            stmt.setString(3, email);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, emergencyContact);
            stmt.setString(7, preferredCommunicationMethod);
            stmt.setString(8, language);
            stmt.setBoolean(9, notificationsEnabled);
            stmt.setBoolean(10, darkModeEnabled);
            stmt.setBoolean(11, shareDataWithThirdParties);
            stmt.setBoolean(12, healthDataVisible);
            stmt.setBoolean(13, true); // isActive = true
            stmt.setString(14, "PATIENT"); // user role
            stmt.setString(15, address);
            stmt.setString(16, blood_type);
            stmt.setString(17, allergies);
            stmt.setString(18, medical_history);
            stmt.setString(19, current_medication);
            stmt.setString(20, doctor_email);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

            conn.close();
        } catch (Exception e) {
        	response.setContentType("text/plain");
            response.getWriter().write("Error: " + e.getMessage());
            e.printStackTrace();
        }
    
	}

}
