<%-- 
    Document   : Register
    Created on : Feb 14, 2025, 12:24:14 AM
    Author     : dvdung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%@ page import="java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<%
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
    <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
</head>

<body id="bg">
    <div class="page-wraper">
        <div class="account-form">
            <div class="account-head" style="background-image:url(assets/images/background/bg2.jpg);">
                <a href="index.jsp"><img src="assets/images/logo-white-2.png" alt=""></a>
            </div>
            <div class="account-form-inner">
                <div class="account-container">
                    <div class="heading-bx left">
                        <h2 class="title-head">Sign Up <span>Now</span></h2>
                        <p>Login Your Account <a href="login.jsp">Click here</a></p>
                    </div>
                    <form action="UserURL" method="POST" class="contact-bx">
                        <input type="hidden" name="service" value="registerUser">
                        <div class="row placeani">
                            <input type="hidden" name="RoleID" value="2">
                            <input type="hidden" name="CreatedAt" value="<%= currentTime %>">
                            <input type="hidden" name="IsActive" value="1">

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Email</label>
                                        <input type="email" name="Email" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Full Name</label>
                                        <input type="text" name="FullName" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Phone</label>
                                        <input type="text" name="Phone" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group1">
                                        <label>Date of Birth</label>
                                        <input type="date" name="Dob" class="form-control" placeholder=" " required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Address</label>
                                        <input type="text" name="Address" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Avatar</label>
                                        <input type="file" name="Avatar" class="form-control">
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Username</label>
                                        <input type="text" name="UserName" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                                <p class="text-danger">${error}</p>
                                <div class="form-group">
                                    <div class="input-group">
                                        <label>Password</label>
                                        <input type="password" name="Password" class="form-control" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 m-b30">
                                <button type="submit" class="btn button-md" name="submit" value="registerUser">Sign Up</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
    <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
    <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
    <script src="assets/vendors/counter/waypoints-min.js"></script>
    <script src="assets/vendors/counter/counterup.min.js"></script>
    <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
    <script src="assets/vendors/masonry/masonry.js"></script>
    <script src="assets/vendors/masonry/filter.js"></script>
    <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
    <script src="assets/js/functions.js"></script>
    <script src="assets/js/contact.js"></script>
    <script src='assets/vendors/switcher/switcher.js'></script>
</body>

</html>
