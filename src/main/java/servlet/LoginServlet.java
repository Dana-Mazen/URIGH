package servlet;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doctor;
import model.Patient;
import model.User.Role;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(
	                "", "", "");

	            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String roleStr = rs.getString("role");
	                Role role = Role.valueOf(roleStr.toUpperCase()); //convert role string to Role enum
	                HttpSession session = request.getSession();
	                session.setAttribute("username", rs.getString("username"));
	                session.setAttribute("role", role);

	                if (
	                		role == Role.DOCTOR
	                		) {
	                
	                    Doctor doctor = new Doctor();
	                    doctor.setId(rs.getLong("id")); 
	                    doctor.setUsername(rs.getString("username"));
	                    doctor.setPassword(rs.getString("password"));
	                    doctor.setEmail(rs.getString("email"));
	                    doctor.setRole(role); 
	                    doctor.setContactNumber(rs.getString("contact_number")); 

	                    session.setAttribute("loggedUser", doctor);
	                    response.sendRedirect("doctorDashboard.jsp");
	                    
	                } else if (role == Role.PATIENT) {
	                	
	                	Patient patient = new Patient();
	                	patient.setId((long) rs.getInt("id"));
	                	patient.setUsername(rs.getString("username"));
	                	patient.setEmail(rs.getString("email"));
	                	patient.setPassword(rs.getString("password")); // or avoid for security
	                	patient.setFullName(rs.getString("full_Name"));
	                	patient.setContactNumber(rs.getString("contact_Number"));
	                	patient.setNotificationsEnabled(rs.getBoolean("notifications_enabled"));
	                	patient.setPreferredCommunicationMethod(rs.getString("preferred_communication_method"));
	                	patient.setHealthDataVisible(rs.getBoolean("health_data_visible"));
	                	patient.setShareDataWithThirdParties(rs.getBoolean("share_data_with_third_parties"));
	                	patient.setLanguage(rs.getString("language"));
	                	patient.setDarkModeEnabled(rs.getBoolean("dark_mode_enabled"));
	                	patient.setEmergencyContact(rs.getString("emergency_contact"));
	                	patient.setActive(rs.getBoolean("is_active"));
	                	
	                 	patient.setAddress(rs.getString("address"));
	                	patient.setBloodType(rs.getString("blood_type"));
	                	patient.setAllergies(rs.getString("allergies"));
	                	patient.setMedicalHistory(rs.getString("medical_history"));
	                    patient.setCurrentMedication(rs.getString("current_medication"));
	                    patient.setDoctorEmail(rs.getString("doctor_email"));
	                    
	                	session.setAttribute("loggedUser", patient);
	                	response.sendRedirect("patientDashboard.jsp");
	
	                } else {
	                    response.sendRedirect("welcome.jsp");
	                }
	            } else {
	            
	            	    request.setAttribute("errorMessage", "Invalid email or password.");
	            	    request.getRequestDispatcher("login.jsp").forward(request, response);
	            	   
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	           response.sendRedirect("error.jsp");
	        }
	}

}
