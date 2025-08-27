package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;

/**
 * Servlet implementation class SaveHealthMetricsServlet
 */
@WebServlet("/SaveHealthMetricsServlet")
public class SaveHealthMetricsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveHealthMetricsServlet() {
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
		   HttpSession session = request.getSession();
	        Object userObj = session.getAttribute("loggedUser");

	        if (userObj == null || !(userObj instanceof Patient)) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        Patient patient = (Patient) userObj;
	        String bloodPressure = request.getParameter("bloodPressure");
	        String heartRate = request.getParameter("heartRate");
	        String bloodSugar = request.getParameter("bloodSugar");

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("", "", "");

	            String sql = "INSERT INTO health_metrics (patient_email, blood_pressure, heart_rate, blood_sugar) VALUES (?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, patient.getEmail());
	            stmt.setString(2, bloodPressure);
	            stmt.setString(3, heartRate);
	            stmt.setString(4, bloodSugar);

	            stmt.executeUpdate();
	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("patientDashboard.jsp"); // go back to dashboard
	    
	}

}
