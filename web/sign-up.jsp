<%-- 
    Document   : sign-up
    Created on : Mar 13, 2023, 7:54:40 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body>
    <header>
        <div class="nav container">
            <a href="login.jsp" class ="logo"><i class='bx bx-home'></i>G7 State</a>
            
            <a href="login.jsp" class="btn">Login</a>
        </div>
    </header>
<!-- Sign Up -->
<div class="login container">
    <div class="login-container">
        <h2>Welcome, Let's get started</h2>
        <p>Already have account <a href="login.jsp">Log In</a> </p>
        <p>Log in with your data that you entered <br> during your registration</p>
        <form action="SignupServlet" method="POST">
            <span>User ID</span>
            <input type="text" name="userid" id="" placeholder="Your ID" required>
            <span>Full Name</span>
            <input type="text" name="fullname" id="" placeholder="Your Name" required>
            <span>Email</span>
            <input type="email" name="email" id="" placeholder="yourmail@gmail.com" required>
            <span>Phone</span>
            <input type="tel" name="tel" id="" placeholder="Enter your number" required>
            <span>Enter your password</span>
            <input type="password" name="pass" id="" placeholder="At least 8 characters" required>
            <span> Type user</span>
            <select name="role" class="typeuser">
                <option value="1">Owner</option>
                 <option value="0">Renter</option>
            </select></td></tr>
            <input type="submit" value="Sign Up" class="button">
            <a href="login.html">Already have account</a>
        </form>
        <a href="login.html" class="btn">Log In</a>
    </div>
    <!-- Login Img -->
    <div class="login-imag">
        <img src="img/signup.jpg" alt="">
    </div>
</div>

<!-- Footer -->
<section class="footer">
    <div class="footer-container container">
        <h2>G7 State</h2>
        <div class="footer-box">
            <h3>Quick Links</h3>
            <a href="#">Agency</a>
            <a href="#">Building</a>
            <a href="#">Rates</a>
        </div>
        <div class="footer-box">
            <h3>Locations</h3>
            <a href="#">FPTU</a>
            <a href="#">FPTU</a>
            <a href="#">FPTU</a>
        </div>
        <div class="social">
            <h3>Social</h3>
            <a href="#"><i class='bx bxl-facebook-circle'></i></a>
            <a href="#"><i class='bx bxl-instagram-alt'></i></i></a>
            <a href="#"><i class='bx bxl-twitter' ></i></i></a>
        </div>
    </div>
</section>
</body>
</html>