package servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDAO;
import model.Patient;
import model.User;


/**
 * Servlet implementation class UpdatePatientServlet
 */
@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
	 private userDAO userDAO;

	    public void init() {
	        userDAO = new userDAO(); 
	    }
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
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
		  // Parse ID
		  HttpSession session = request.getSession(false);//false so it doest create new sesh if none exists

		    if (session == null || session.getAttribute("loggedUser") == null) {
		        response.sendRedirect("login.jsp");
		        return;
		    }
		    User patient = (User) session.getAttribute("loggedUser");  //retrieve logged in user from sesh
		 //update fields
		patient.setUsername(request.getParameter("username"));
		patient.setPassword(request.getParameter("password"));
		patient.setEmail(request.getParameter("email"));
		patient.setFullName(request.getParameter("fullName"));
		patient.setContactNumber(request.getParameter("contactNumber"));
		patient.setNotificationsEnabled(Boolean.parseBoolean(request.getParameter("notificationsEnabled")));
		patient.setPreferredCommunicationMethod(request.getParameter("preferredCommunicationMethod"));
		patient.setHealthDataVisible(Boolean.parseBoolean(request.getParameter("healthDataVisible")));
		patient.setShareDataWithThirdParties(Boolean.parseBoolean(request.getParameter("shareDataWithThirdParties")));
		patient.setLanguage(request.getParameter("language"));
		patient.setDarkModeEnabled(Boolean.parseBoolean(request.getParameter("darkModeEnabled")));
		patient.setEmergencyContact(request.getParameter("emergencyContact"));
		patient.setActive(Boolean.parseBoolean(request.getParameter("isActive")));
		
		((Patient) patient).setAddress(request.getParameter("address"));
		((Patient) patient).setBloodType(request.getParameter("blood_type"));
		((Patient) patient).setAllergies(request.getParameter("allergies"));
		((Patient) patient).setMedicalHistory(request.getParameter("medical_history"));
		((Patient) patient).setCurrentMedication(request.getParameter("current_medication"));
		((Patient) patient).setDoctorEmail(request.getParameter("doctor_email"));

		//now save to databaase
		boolean updated = userDAO.updateUser(patient);
		
		if (updated) {
			 session.setAttribute("loggedUser", patient); //refresh session data
		    response.sendRedirect("profile.jsp?success=true");
		} else {
		    request.setAttribute("error", "Update failed.");
		    request.getRequestDispatcher("editPatient.jsp").forward(request, response);
		}

}
}
