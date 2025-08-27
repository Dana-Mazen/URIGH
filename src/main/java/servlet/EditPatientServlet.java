package servlet;

import java.io.IOException;
import java.util.Optional;
import dao.userDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class EditPatientServlet
 */
@WebServlet("/EditPatientServlet")
public class EditPatientServlet extends HttpServlet {
	private userDAO userDAO = new userDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String idStr = request.getParameter("id");

	        if (idStr != null) {
	            try {
	                long id = Long.parseLong(idStr);
	                Optional<User> userOpt = userDAO.findById(id);
	                if (userOpt.isPresent()) {
	                    request.setAttribute("user", userOpt.get());
	                    request.getRequestDispatcher("/editPatient.jsp").forward(request, response);
	                } else {
	                    response.sendRedirect("error.jsp"); // or show error
	                }
	            } catch (NumberFormatException e) {
	                response.sendRedirect("error.jsp");
	            }
	        } else {
	            response.sendRedirect("error.jsp");
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
