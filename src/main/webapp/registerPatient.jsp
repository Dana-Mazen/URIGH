<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Patient</title>
    <link rel="stylesheet" href="registerPatient.css">
</head>
<body>
    <div class="container">
        <form action="welcome.jsp" method="get" class="home-button">
            <button type="submit">Home</button>
        </form>

        <h2>Patient Registration Form</h2>

        <form action="RegisterPatientServlet" method="post" class="registration-form">
            <label>Full Name: <input type="text" name="fullName" required></label>
            <label>Contact Number: <input type="text" name="contactNumber"></label>
            <label>Email: <input type="email" name="email" required></label>
            <label>Username: <input type="text" name="username" required></label>
            <label>Password: <input type="password" name="password" required></label>
            <label>Emergency Contact: <input type="text" name="emergencyContact"></label>
            <label>Preferred Communication: <input type="text" name="preferredCommunicationMethod"></label>
            <label>Language: <input type="text" name="language"></label>
            <label>Address: <input type="text" name="address"></label>
            <label>Blood Type: <input type="text" name="blood_type"></label>
            <label>Allergies: <input type="text" name="allergies"></label>
            <label>Medical History: <input type="text" name="medical_history"></label>
            <label>Current Medication: <input type="text" name="current_medication"></label>
            <label>Doctor Email: <input type="text" name="doctor_email"></label>
            <label><input type="checkbox" name="darkModeEnabled"> Dark Mode</label>
            <label><input type="checkbox" name="notificationsEnabled"> Notifications Enabled</label>
            <label><input type="checkbox" name="shareDataWithThirdParties"> Share Data with Third Parties</label>
            <label><input type="checkbox" name="healthDataVisible"> Health Data Visible</label>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>

