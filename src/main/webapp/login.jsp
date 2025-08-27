<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - You Are in Good Hands</title>
<link rel="stylesheet" href="login.css" />
</head>
<body>

<header>
    <div class="header-content">
        <img src="th.jpg" alt="UR Good Health Logo" class="logo">
        <h1>You Are in Good Hands</h1>
    </div>
</header>

<main>
<%
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
%>
    <div class="error-message"><%= error %></div>
<%
    }
%>

<div class="login-container">
    <form class="login-form" action="LoginServlet" method="post">
        <label>Email:</label>
        <input type="email" name="email" placeholder="Enter your email" required><br>

        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter your password" required><br>

        <input class="actions" type="submit" value="Login">
    </form>

    <div class="role-selection">
        <h2>Don't have an account?</h2>
        <form action="registerPatient.jsp" method="get" style="display:inline;">
            <button class="button">Sign Up as Patient</button>
        </form>
        <form action="registerDoctor.jsp" method="get" style="display:inline;">
            <button class="button">Sign Up as Doctor</button>
        </form>
        <form action="welcome.jsp" method="get" style="margin: 10px; padding: 0;">
    <button type="submit" style="
        background-color:  #77e2f5; 
        color: white; 
        padding: 10px 20px; 
        border: none; 
        border-radius: 5px; 
        cursor: pointer; 
        font-size: 16px;
    ">Home</button>
</form>
    </div>
</div>
</main>

<footer>
    <p>&copy; 2025 UR Good Health. All rights reserved.</p>
</footer>

</body>
</html>
