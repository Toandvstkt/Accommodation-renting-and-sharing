<%-- 
    Document   : home
    Created on : Mar 13, 2023, 7:53:35 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rent and share house</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <style>
            
            .search-box{
                background-color: #39ace7;
                border-radius: 20px;
                width: 50%;               
                margin: auto;
                margin-top: 10px;
                text-align: center;
            }
            .search-box-form{                
                display: flex;
                justify-content: center;
            }

            .search-box-form select{    
                color: chocolate;                    
            }
        </style>

</head>
<body>
    <header>
        <div class="nav container">
            <a href="list" class ="logo"><i class='bx bx-home'></i>G7 State</a>
            <input type="checkbox" name="" id="menu">
           <label for="menu" <i class='bx bx-menu' id="menu-icon"></i></label>
            <ul class="navbar">
                <li><a href="#home">Home</a></li>
                <li><a href="#about">About</a></li> 
                <c:if test="${sessionScope.acc !=null}">
                    <c:if test="${sessionScope.acc.role==0}">
                <li><a href="#Rent">Rent</a></li>
                <li><a href="#Share">Share</a></li>
                </c:if>
                <c:if test="${sessionScope.acc.role==1}">
                <li><a href="./ManagerServlet">Manager</a></li>
                </c:if>
                    <li><a href="#about">HELLO (${sessionScope.acc.fullName})</a></li> 
                    
                <li><a href="./LogoutServlet">Logout</a></li>
                </c:if>
            </ul>
            <c:if test="${sessionScope.acc==null}">
             <a href="login.jsp" class="btn">Login</a>
            </c:if>
           
        </div>
    </header>

        <section class="home container" id="home">
            <c:if test="${sessionScope.acc==null}">
            <div class="home-text">
                <h1>Find Your Next <br>Perfect Place To<br>Live.</h1>
                <a href="sign-up.jsp" class="btn">Sign Up</a>
            </div>
            </c:if>
        </section>
        

        <section class="about container" id="about">
            <div class="about-img">
                <img src="img/about.jpg" alt="">
            </div>
            <div class="about-text">
                <span>About Us</span>
                <h2>We Provide The Best <br>Property For You!</h2>
                <p>GROUP 7 SE17A01 FPTU</p>
                <p>DINH VAN TOAN-DE160603</p>
                <p>DINH CAO KHANH</p>
                <p>TA QUOC THINH</p>
                <p>NGUYEN TRI DONG</p>
                <a href="#" class="btn">Learn More</a>
            </div>
        </section>
        <c:if test="${sessionScope.acc!=null}">
    <section class="sales container" id="sales">
        <!-- Box 1 -->
        <div class="box">
            <i class ='bx bx-user'></i>
            <h3>Make Your Dream True</h3>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.Facilis,ant.</p>
        </div>
        <!-- Box 2 -->
        <div class="box">
            <i class ='bx bx-desktop'></i>
            <h3>Start Your MemberShip</h3>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.Facilis,ant.</p>
        </div>
        <!-- Box 3 -->
        <div class="box">
            <i class ='bx bx-home-alt'></i>
            <h3>Enjoy Yor New Room</h3>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.Facilis,ant.</p>
        </div>
    </section>
     <c:if test="${sessionScope.acc.role==0}">
    <div class="searchbox">
    <section class="search-box">
            <form class="search-box-form" action="search">     
                <select name="address" id="id">
                    <option value="0">Address</option>
                    <option value="1">Hải Châu</option>
                    <option value="2">Thanh Khuê</option>
                    <option value="3">Ngũ Hành Sơn</option>
                    <option value="4">Liên Chiểu</option>
                    <option value="5">Hòa Vang</option>
                    <option value="6">Cẩm Lệ</option>
                    <option value="7">Sơn Trà</option>
                </select>

                <select name="price" id="id">
                    <option value="0">Price</option>
                    <option value="1">Under 200$</option>
                    <option value="2">200$ -> 300$</option>
                    <option value="3">300$ -> 400$</option>
                    <option value="4">Over 400$</option>                    
                </select>
                <input type="submit">
            </form>
        </section>
</div>




        <section class="properties container" id="Rent">
            <div class="heading">
                <span>Rent Room</span>
            </div>
            <c:forEach items="${requestScope.list}" var="i">
                <div class="properties-container container">                
                    <div class="box">
                        <img src="${i.img}" alt="">
                        <h3>${i.price}$</h3>
                        <div class="content">
                            <div class="text">
                                <h3>The Place</h3> 
                                <p>${i.address}</p>
                                <input type="hidden" name ="roomid" value ="${i.roomid}">
                            </div>
                            <div class="icon">
                                <i class='bx bx-bed'>1</i>
                                <i class='bx bx-desktop'>1</i></br>
                                <p>Number of people: ${i.numberOfPeople}</p>
                            </div>
                           <a href="PaymentServlet?roomid=${i.roomid}" class="btn">Rent now</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </section>

        <section class="properties container" id="Share">
            <div class="heading">
                <span>Share Room</span>
            </div>
            <c:forEach items="${requestScope.list2}" var="i">
                <div class="properties-container container">                
                    <div class="box">
                        <img src="${i.img}" alt="">
                        <input type="hidden" name="price" value="${i.price}$"> <h3>${i.price}$</h3>
                        <div class="content">
                            <div class="text">
                                <h3>The Place</h3> 
                                <p>${i.address}</p>
                                <input type="hidden" name ="roomid" value ="${i.roomid}">
                            </div>
                            <div class="icon">
                                <i class='bx bx-bed'>1</i>
                                <i class='bx bx-desktop'>1</i> </br>
                                <p>Number of people: ${i.numberOfPeople}</p>

                            </div>
                            <a href="PaymentServlet?roomid=${i.roomid}" class="btn">Rent now</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </section>
 </c:if>
<section class="newsletter container">
    <h2>Have Question in Mind <br>Let Us Help You</h2>
    <form action="">
        <input type="email" name="" id="email-box" placeholder="yourmail@gmail.com" required>
        <input type="submit" name="Send" class="btn">
    </form>
</section>
</c:if>
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
<script src="./mycode.js"></script>
</body>
</html>