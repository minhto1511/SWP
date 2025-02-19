<%-- 
    Document   : login1
    Created on : Feb 12, 2025, 10:29:15 PM
    Author     : Heizxje
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tilte Heizxje Login</title>
    <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
    <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
</head>
<body id="bg">
<div class="page-wraper">
    <div id="loading-icon-bx"></div>
    <div class="account-form">
        <div class="account-head" style="background-image:url(assets/images/background/bg.jpg);">
            <a href="index.jsp"><img src="assets/images/logo-white-2.png" alt=""></a>
        </div>
        <div class="account-form-inner">
            <div class="account-container">
                <div class="heading-bx left">
                    <h2 class="title-head">Login to your <span>Account</span></h2>
                    <p>Don't have an account? <a href="register.jsp">Create one here</a></p>
                </div>  
                <form action="login" class="contact-bx">
                    <input type="hidden" name="service" value="loginUser">
                    <div class="row placeani">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <label>Your Name</label>
                                    <input name="username" type="text" required class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <label>Your Password</label>
                                    <input name="password" type="password" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group form-forget">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                    <label class="custom-control-label" for="customControlAutosizing">Remember me</label>
                                </div>
                                <a href="requestPassword.jsp" class="ml-auto">Forgot Password?</a>
                            </div>
                        </div>
                        <p class="text-danger">${error}</p>
                        <div class="col-lg-12 m-b30">
                            <button name="submit" type="submit" value="Submit" class="btn button-md">Login</button>
                        </div>
                        <div class="col-lg-12">
                            <h6>Login with Social media</h6>
                            <div class="d-flex">
                                <a class="btn flex-fill m-l5 google" href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:9999/SWP391_Group4_TutorManagement/login&response_type=code&client_id=918167236066-r8da2g0h2eh06buen60d3km6fqaecn1f.apps.googleusercontent.com&approval_prompt=force"><i class="fa fa-google"></i> Google</a>
                            </div>
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
<script src="assets/js/functions.js"></script>
</body>
</html>
