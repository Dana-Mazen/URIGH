<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Patient" %>
<%
    Object userObj = session.getAttribute("loggedUser");
    if (!(userObj instanceof Patient)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="addMetrics.css">
    <title>Add Health Metrics</title>
</head>
<body>
    <h1>Add Health Metrics</h1>
    <form action="SaveHealthMetricsServlet" method="post">
        Blood Pressure: <input type="text" name="bloodPressure" required><br>
        Heart Rate: <input type="text" name="heartRate" required><br>
        Blood Sugar: <input type="text" name="bloodSugar" required><br>
        <button type="submit">Submit</button>
    </form>
    <form action="patientDashboard.jsp" method="get" style="margin-bottom: 10px;">
    <button type="submit">Back</button>
</form>
</body>

</html>
