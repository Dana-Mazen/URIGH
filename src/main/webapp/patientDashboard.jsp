<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Dashboard</title>
<link rel="stylesheet" href="patientDashboard.css">
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="Clinic Logo" class="logo" />
        <h1>Patient Dashboard</h1>
    </div>
</header>

<main>
    <form action="AddHealthMetricsServlet" method="get" class="button-form">
        <button type="submit" class="primary-button">Add Health Metrics</button>
    </form>
    
<form action="profile.jsp" method="get" class="button-form">
        <button type="submit" class="primary-button">My Profile</button>
    </form>
    
    <form action="ViewHealthReportsServlet" method="get" class="button-form">
        <button type="submit" class="primary-button">View My Reports</button>
    </form>

    <form action="LogoutServlet" method="get" style="display:inline;" class="button-form">
        <button type="submit" class="logout-button">Logout</button>
    </form>
</main>

<footer>
    &copy; 2025 HealthCare Platform | All rights reserved
</footer>

</body>
</html>
