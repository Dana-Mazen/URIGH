<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Patient Report</title>
    <link rel="stylesheet" href="doctorPatients.css" />
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="UR Good Health Logo" class="logo">
        <h1>Search Patient Report</h1>
    </div>
</header>

<main>
    <form action="ViewPatientReportServlet" method="get" class="form-container">
        <label for="email">Enter Patient Email:</label>
        <input type="email" id="email" name="email" required class="input-field" />
        <input type="submit" value="View Report" class="back-button" />
    </form>

    <form action="doctorDashboard.jsp" method="get">
        <button class="back-button" type="submit">Back</button>
    </form>
</main>

<footer>
    <p>&copy; 2025 UR Good Health. All rights reserved.</p>
</footer>

</body>
</html>
