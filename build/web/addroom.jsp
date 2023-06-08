<%-- 
    Document   : addroom
    Created on : Mar 9, 2023, 9:38:08 PM
    Author     : caokhanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

        <title>ADD ROOM</title>
    </head>
    <body>
        <header>
            <div class="nav container">
                <a href="home.jsp" class ="logo"><i class='bx bx-home'></i>G7 State</a>
                <input type="checkbox" name="" id="menu">
                <label for="menu" <i class='bx bx-menu' id="menu-icon"></i></label>
                <ul class="navbar">
                    <li><a href="home.jsp">Home</a></li>

                </ul>
            </div>
        </header>
<div class="login container">
    <div class="login-container">
        <section class="payment container" id="payment">
            <form action="AddRoomServlet" method="get">        
            <span>Illustration of the in room</span>
            <input type="text" name="img" id="" placeholder="link of image" required>
            <span>RoomID</span>
            <input type="number" name="roomID" id="" placeholder="Room ID" required>
            <span>Price</span>
            <input type="number" name="price" id="" placeholder="Cost of room" required>
            <span>Address</span>
            <input type="text" name="address" id="" placeholder="Address of room" required>
            <span>Number of people</span>
            <input type="number" name="numberpeople" id="" placeholder="Number of people in room" required>
            <span> Type room</span>
            <select name="type" class="typeuser">
                <option value="1">Share</option>
                 <option value="0">Only</option>
            </select></td></tr>
            <input type="submit" value="Add room" class="button">
            </form>
        </section>
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
