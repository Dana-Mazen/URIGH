<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Patient" %>

<%
    User pa = (User) session.getAttribute("loggedUser");
    if (pa == null || !(pa instanceof Patient)) {
        response.sendRedirect("login.jsp");
        return;
    }
    Patient p = (Patient) pa;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Patient Info</title>
    <link rel="stylesheet" href="editPatient.css">
</head>
<body>
    <header>
        <div class="header-content">
            <img src="th.jpg" alt="Platform Logo" class="logo" />
            <h1>Doctor & Patient Platform</h1>
        </div>
    </header>

    <main>
        <h2>Edit Patient</h2>

        <form action="UpdatePatientServlet" method="post" class="form-container">
            <input type="hidden" name="id" value="<%= p.getId() %>" />

            <label>Username:</label>
            <input type="text" name="username" value="<%= p.getUsername() %>" required />

            <label>Password:</label>
            <input type="password" name="password" value="<%= p.getPassword() %>" required />

            <label>Email:</label>
            <input type="email" name="email" value="<%= p.getEmail() %>" required />

            <label>Full Name:</label>
            <input type="text" name="fullName" value="<%= p.getFullName() %>" />

            <label>Contact Number:</label>
            <input type="text" name="contactNumber" value="<%= p.getContactNumber() %>" />

            <label>Notifications Enabled:</label>
            <select name="notificationsEnabled">
                <option value="true" <%= p.isNotificationsEnabled() ? "selected" : "" %>>Yes</option>
                <option value="false" <%= !p.isNotificationsEnabled() ? "selected" : "" %>>No</option>
            </select>

            <label>Preferred Communication:</label>
            <input type="text" name="preferredCommunicationMethod" value="<%= p.getPreferredCommunicationMethod() %>" />

            <label>Language:</label>
            <input type="text" name="language" value="<%= p.getLanguage() %>" />

            <label>Dark Mode Enabled:</label>
            <select name="darkModeEnabled">
                <option value="true" <%= p.isDarkModeEnabled() ? "selected" : "" %>>Yes</option>
                <option value="false" <%= !p.isDarkModeEnabled() ? "selected" : "" %>>No</option>
            </select>

            <label>Emergency Contact:</label>
            <input type="text" name="emergencyContact" value="<%= p.getEmergencyContactNumber() %>" />

            <label>Address:</label>
            <input type="text" name="address" value="<%= p.getAddress() %>" />

            <label>Blood Type:</label>
            <input type="text" name="blood_type" value="<%= p.getBloodType() %>" />

            <label>Allergies:</label>
            <input type="text" name="allergies" value="<%= p.getAllergies() %>" />

            <label>Medical History:</label>
            <input type="text" name="medical_history" value="<%= p.getMedicalHistory() %>" />

            <label>Current Medication:</label>
            <input type="text" name="current_medication" value="<%= p.getCurrentMedication() %>" />

            <label>Doctor's Email:</label>
            <input type="text" name="doctor_email" value="<%= p.getDoctorEmail() %>" />

            <button type="submit" class="primary-button">Update</button>
        </form>

        <br/>
        <a href="patientDashboard.jsp" class="back-link">← Back to home</a>
    </main>

    <footer>
        <p>© 2025 Doctor & Patient Platform. All rights reserved.</p>
    </footer>
</body>
</html>
