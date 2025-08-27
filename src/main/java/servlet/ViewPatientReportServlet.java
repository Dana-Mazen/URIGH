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

import model.HealthMetric;

/**
 * Servlet implementation class ViewPatientReportServlet
 */
@WebServlet("/ViewPatientReportServlet")
public class ViewPatientReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPatientReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String email = request.getParameter("email");

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("", "", "");
	            String sql = "SELECT * FROM health_metrics WHERE patient_email = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();

	            List<HealthMetric> metrics = new ArrayList<>();
	            while (rs.next()) {
	                HealthMetric metric = new HealthMetric();
	                metric.setDate(rs.getDate("record_date"));
	                metric.setHeart_rate(rs.getString("heart_rate"));
	                metric.setBlood_pressure(rs.getString("blood_pressure"));
	                metric.setBlood_sugar(rs.getString("blood_sugar"));
	                 

	                metrics.add(metric);
	            }

	            conn.close();
	            if (metrics.isEmpty()) {
	                response.sendRedirect("searchPatientReport.jsp?error=true");
	                return;
	            }

	            request.setAttribute("metrics", metrics);
	            request.setAttribute("patientEmail", email);
	            request.getRequestDispatcher("doctorViewReport.jsp").forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("searchPatientReport.jsp?error=true");
	        }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
