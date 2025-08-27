package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doctor;
import model.Patient;


/**
 * Servlet implementation class DoctorPatientServlet
 */
@WebServlet("/DoctorPatientServlet")
public class DoctorPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public DoctorPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     HttpSession session = request.getSession();
	        Object loggedUser = session.getAttribute("loggedUser");

	        if (loggedUser == null || !(loggedUser instanceof Doctor)) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        Doctor doctor = (Doctor) loggedUser;
	        List<Patient> patients = new ArrayList<>();
	     
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("", "", "");

	            String sql = "SELECT * FROM user WHERE role = 'PATIENT' AND doctor_email = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, doctor.getEmail());

	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Patient patient = new Patient();
	                patient.setId(rs.getLong("id"));
	                patient.setUsername(rs.getString("username"));
	                patient.setEmail(rs.getString("email"));
	                patient.setFullName(rs.getString("full_name"));
	                patient.setContactNumber(rs.getString("contact_number"));
	                patient.setAllergies(rs.getString("allergies"));
	                patient.setMedicalHistory(rs.getString("medical_history"));
	                patient.setCurrentMedication(rs.getString("current_medication"));
	                patient.setBloodType(rs.getString("blood_type"));
	                patient.setDoctorEmail(rs.getString("doctor_email"));
	            
	                patients.add(patient);
	               
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        //send to jsp
	        request.setAttribute("patients", patients);
	        request.getRequestDispatcher("doctorPatients.jsp").forward(request, response); //forward
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    
	}

}
