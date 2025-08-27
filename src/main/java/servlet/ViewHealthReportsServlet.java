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

import model.Patient;

/**
 * Servlet implementation class ViewHealthReportsServlet
 */
@WebServlet("/ViewHealthReportsServlet")
public class ViewHealthReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHealthReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        Object userObj = session.getAttribute("loggedUser");

        if (userObj == null || !(userObj instanceof Patient)) {
            response.sendRedirect("login.jsp");
            return;
        }

        Patient patient = (Patient) userObj;
        List<String[]> logs = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("", "", "");

            String sql = "SELECT * FROM health_metrics WHERE patient_email = ? ORDER BY record_date DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patient.getEmail());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                logs.add(new String[]{
                    rs.getString("blood_pressure"),
                    rs.getString("heart_rate"),
                    rs.getString("blood_sugar"),
                    rs.getString("record_date")
                });
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("logs", logs);
        request.getRequestDispatcher("viewReports.jsp").forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
