<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%
    List<String[]> logs = (List<String[]>) request.getAttribute("logs");
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="viewReports.css">
    <title>Health Reports</title>
</head>
<body>
    <h1>My Health Reports</h1>

    <%
        if (logs != null && !logs.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Blood Pressure</th>
                <th>Heart Rate</th>
                <th>Blood Sugar</th>
                <th>Date</th>
            </tr>
            <% for (String[] log : logs) { %>
            <tr>
                <td><%= log[0] %></td>
                <td><%= log[1] %></td>
                <td><%= log[2] %></td>
                <td><%= log[3] %></td>
            </tr>
            <% } %>
        </table>
    <%
        } else {
    %>
        <p>No reports available yet.</p>
    <%
        }
    %>
    <form action="patientDashboard.jsp" method="get" style="margin-bottom: 10px;">
      <button type="submit">Back</button>
    </form>
</body>
</html>
