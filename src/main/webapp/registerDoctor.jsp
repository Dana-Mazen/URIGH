<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Registration</title>
    <link rel="stylesheet" href="registerPatient.css">
</head>
<body>

<div class="container">
    <div class="home-button">
        <form action="welcome.jsp" method="get">
            <button type="submit">Home</button>
        </form>
    </div>

    <h2>Doctor Registration Form</h2>
    <form action="RegisterDoctorServlet" method="post">
        <label>Full Name:</label>
        <input type="text" name="fullName" required>

        <label>Contact Number:</label>
        <input type="text" name="contactNumber" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Register Doctor">
    </form>
</div>

</body>
</html>
