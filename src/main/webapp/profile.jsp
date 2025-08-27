<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Patient" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Profile</title>
<link rel="stylesheet" href="profile.css">
</head>
<body>
<h2>Your Profile</h2>

<%
    //retrieve the loggedUser from the session
    User loggedUser = (User) session.getAttribute("loggedUser");

    //check if user is logged in and if the user is a patient
    if (loggedUser == null || !(loggedUser instanceof Patient)) {
        response.sendRedirect("login.jsp");
        return;
    }

    //cast loggedUser to access patient attributes
    Patient p = (Patient) loggedUser;
%>

<p>Email: <%= p.getEmail() %></p>
<p>Address: <%= p.getAddress() %></p>
<p>Blood Type: <%= p.getBloodType() %></p>
<p>Allergies: <%= p.getAllergies() %></p>
<p>Medical History: <%= p.getMedicalHistory() %></p>
<p>Current Medication: <%= p.getCurrentMedication() %></p>
<p>Contact Number: <%= p.getContactNumber() %></p>
<p>Doctor's Email: <%= p.getDoctorEmail() %></p>

<a href="editPatient.jsp">Edit Profile</a> |
<a href="patientDashboard.jsp">Home</a>

</body>
</html>
