<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>You Are in Good Hands - Healthcare System</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
    />
    <link rel="stylesheet" href="welcome2.css" />
  </head>

  <body>
    <header class="gh-header">
      <div class="container">
        <a href="welcome.jsp" class="gh-logo">
          <img src="th.jpg" alt="GoodHands Logo" />
          <span>You Are in Good Hands</span>
        </a>
        <nav class="gh-nav">
          <ul>
            <li><a href="chatbot.html" onclick="">Contact Eveline</a></li>
            <li><a href="login.jsp">Emergency</a></li>
            <li><a href="login.jsp">Doctors</a></li>
            <li><a href="welcome.jsp">Dashboard</a></li>
            <li class="gh-user-icon">
              <a href="login.jsp" title="Login"><i class="fa fa-user-circle"></i></a>
            </li>
          </ul>
        </nav>
      </div>
    </header>

    <section id="welcome-section" class="welcome-section">
      <h1>Welcome to GoodHands</h1>
      <p>
        We are dedicated to providing the best healthcare solutions, monitoring
        blood pressure and sugar levels, and connecting you with the right
        medical resources in case of emergencies.
      </p>
      <p>
        Our AI-powered chatbot is here to assist you with any medical queries,
        monitor your health data, and provide personalized support.
      </p>
      <form action="login.jsp" method="get">
        <button class="btn-primary">Proceed</button>
      </form>
    </section>

    <main>
      <section id="home" class="section-home">
        <div class="container">
          <h2>Welcome to Your Healthcare Monitoring System</h2>
          <p>
            Track your health metrics, connect with doctors, and receive
            AI-driven assistance to stay healthy.
          </p>
        </div>
      </section>

      <section id="doctor" class="section-doctor">
        <div class="container">
          <h2>Contact Your Doctor</h2>
          <form action="login.jsp" method="get">
            <button class="btn-secondary">Send Health Data to Doctor</button>
          </form>
        </div>
      </section>
    </main>

    <footer class="gh-footer">
      <div class="container">
        <p>
          &copy; 2025 You Are in Good Hands | All Rights Reserved<br />
          Created by Dana Mazen
        </p>
      </div>
    </footer>
  </body>
</html>