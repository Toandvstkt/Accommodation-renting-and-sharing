<%-- 
    Document   : payment
    Created on : Mar 20, 2023, 7:58:39 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="roomid" class="Model.Room" scope="session" />
<jsp:setProperty name="roomid" property="*"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="payment.css">
    </head>
    <body>

        <div class="container">

            <form action="PaymentServlet" method="POST">

                <div class="row">

                    <div class="col">
                        <p class="text-danger">${msq}</p>
                        <h3 class="title">billing address</h3>
                        <c:set var="i" value="${sessionScope.acc}"/>
                        <div class="inputBox">
                            <span>ID name :</span>
                            <div>${i.userID}</div>
                        </div>
                        <div class="inputBox">
                            <span>full name :</span>
                            <div> ${i.fullName}</div>
                        </div>
                        <div class="inputBox">
                            <span>email :</span>
                            <div> ${i.email}</div>
                        </div>
                        <div class="inputBox">
                            <span>Identification :</span>
                            <input type="text" placeholder="identification">
                        </div>
                        <div class="inputBox">
                            <span>address :</span>
                            <input type="text" placeholder="room - street - locality">
                        </div>

                        <div class="flex">
                            <div class="inputBox">
                                <span>Room ID :</span>
                                <div> </div>
                                <input type="hidden" name ="roomid" value ="${roomid.roomid}">${roomid.roomid}
                            </div>
                            <div class="inputBox">
                                <span>zip code :</span>
                                <input type="text" placeholder="123 456">
                            </div>
                        </div>
                    </div>

                    <div class="col">
                        <h3 class="title">payment</h3>

                        <div class="inputBox">
                            <span>cards accepted :</span>
                            <img src="img/card_img.png" alt="">
                        </div>
                        <div class="inputBox">
                            <span>name on card :</span>
                            <input type="text" placeholder="mr. john deo">
                        </div>
                        <div class="inputBox">
                            <span>credit card number :</span>
                            <input type="number" placeholder="1111-2222-3333-4444">
                        </div>
                        <div class="inputBox">
                            <span>exp month :</span>
                            <input type="text" placeholder="january">
                        </div>

                        <div class="flex">
                            <div class="inputBox">
                                <span>exp year :</span>
                                <input type="number" placeholder="2022">
                            </div>
                            <div class="inputBox">
                                <span>CVV :</span>
                                <input type="text" placeholder="1234">
                            </div>
                        </div>

                    </div>

                </div>

                <input type="submit" value="Payment ${roomid.price}$" class="submit-btn">

            </form>

        </div>    

    </body>
</html>