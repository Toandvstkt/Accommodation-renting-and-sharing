<%-- 
    Document   : login
    Created on : Mar 13, 2023, 7:54:04 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body>
    <header>
        <div class="nav container">
            <a href="home.jsp" class ="logo"><i class='bx bx-home'></i>G7 State</a>
            
            <a href="sign-up.jsp" class="btn">Sign Up</a>
        </div>
    </header>
<!-- Login -->
<div class="login container">
    <div class="login-container">
        <h2>Login To Continue</h2>
        <p>Log in with your data that you entered <br> during your registration</p>
        <form action="LoginServlet" method="post">
             
            <span>Enter your ID</span>
            <input type="text" name="userID" id="" placeholder="Rxx or Oxx" required>
            <span>Enter your password</span>
            <input type="password" name="password" id="" placeholder="Password" required>
            <p class="text-danger" >${mess}</p>
            <input type="submit" value="Log In" class="button">
            <a href="#">Forget Password?</a>
        </form>
        <a href="sign-up.jsp" class="btn">Sign Up Now</a>
    </div>
    <!-- Login Img -->
    <div class="login-images">
        <img src="img/loginimg.jpg" alt="">
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