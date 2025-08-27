<%@ page import="java.util.List" %>
<%@ page import="model.HealthMetric" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Report</title>
    <link rel="stylesheet" href="doctorPatients.css" />
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="UR Good Health Logo" class="logo">
        <h1>Patient Health Report</h1>
    </div>
</header>

<main>
    <h2>Report for: <%= request.getAttribute("patientEmail") %></h2>

    <%
        List<HealthMetric> metrics = (List<HealthMetric>) request.getAttribute("metrics");
        if (metrics != null && !metrics.isEmpty()) {
    %>

    <table>
        <tr>
            <th>Date</th>
            <th>Heart Rate</th>
            <th>Blood Pressure</th>
            <th>Blood Sugar</th>
        </tr>
        <%
            for (HealthMetric m : metrics) {
        %>
        <tr>
            <td><%= m.getDate() %></td>
            <td><%= m.getHeart_rate() %></td>
            <td><%= m.getBlood_pressure() %></td>
            <td><%= m.getBlood_sugar() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        } else {
    %>
        <p>No reports found for this patient.</p>
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
