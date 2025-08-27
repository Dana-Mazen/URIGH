<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Dashboard</title>
<link rel="stylesheet" href="doctorDahsboards.css" />
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="UR Good Health Logo" class="logo">
        <h1>Doctor Dashboard</h1>
    </div>
</header>

<main>
    <div class="dashboard-container">
        <a class="dashboard-link" href="DoctorPatientServlet">View Patients</a>
        <a class="dashboard-link" href="SearchPatientReportServlet">View Patient Reports</a>
        
        <form action="LogoutServlet" method="get">
            <button class="logout-button" type="submit">Logout</button>
        </form>
    </div>
</main>

<footer>
    <p>&copy; 2025 UR Good Health. All rights reserved.</p>
</footer>

</body>
</html>
