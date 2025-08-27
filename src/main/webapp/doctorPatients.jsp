<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Doctor" %>
<%@ page import="model.Patient" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    Object userObj = session.getAttribute("loggedUser");

    if (userObj instanceof Doctor) {
        Doctor doctor = (Doctor) userObj;
        String doctorEmail = doctor.getEmail();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Patients</title>
    <link rel="stylesheet" href="doctorPatients.css" />
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="UR Good Health Logo" class="logo">
        <h1>Welcome Dr. <%= doctor.getUsername() %></h1>
    </div>
</header>

<main>
    <div class="info-block">
        <p class="email">Email: <%= doctorEmail %></p>
    </div>

    <h2>Your Patients</h2>

    <%
        List<Patient> patients = (List<Patient>)request.getAttribute("patients");
        if (patients != null && !patients.isEmpty()) {
    %>

    <div class="table-wrapper">
    <table>
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Blood Type</th>
            <th>Allergies</th>
            <th>Medical History</th>
            <th>Current Medication</th>
        </tr>
        <%
            for (Patient p : patients) {
        %>
        <tr>
            <td><%= p.getFullName() %></td>
            <td><%= p.getEmail() %></td>
            <td><%= p.getContactNumber() %></td>
            <td><%= p.getBloodType() %></td>
            <td><%= p.getAllergies() %></td>
            <td><%= p.getMedicalHistory() %></td>
            <td><%= p.getCurrentMedication() %></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>

    <%
        } else {
    %>
        <p class="no-patients">No patients assigned to you yet.</p>
    <%
        }
    %>

    <form action="doctorDashboard.jsp" method="get">
        <button class="back-button" type="submit">Back</button>
    </form>
</main>

<footer>
    <p>&copy; 2025 UR Good Health. All rights reserved.</p>
</footer>

</body>
</html>

<%
    } else {
        response.sendRedirect("login.jsp"); 
    }
%>
