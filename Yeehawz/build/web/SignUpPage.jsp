<%-- 
    Document   : SignUpPage
    Created on : 08-Jun-2016, 10:31:11
    Author     : hannah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap stuff -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <!-- Link to CSS file -->
        <link rel="stylesheet" href="SignUpPage.css">
        
        <title>
            Yeehawz
        </title>
        
        <!-- Script for functions -->
        <script>
            $(document).ready(function(){
                
                $('#goHome').on('click', function(){
                    window.location = "index.jsp";
                });
                
                $('#loginForm').submit(function(event){
                    event.preventDefault();
                    
                    var user = $("#usernameTxtBox").val();
                    var pass = $("#passwordTxtBox").val();
                
                    if(user === "admin" && pass === "admin")
                    {
                        alert("LogIn : " + user + " " + pass);
                        window.location.href = "TaskMainPage.jsp";
                    }
                    else
                    {
                        return false;
                    }
                        
                });
                
                $('#signupBtn').on('click', function(){
                    window.location.href = "SignUpPage.jsp";
                });
                
                $('#signUp').submit(function(event)){
                    event.preventDefault();
                    
//                    var fullname = $("#fullname").val();
//                    var user = $("#username").val();
//                    var email = $("#username").val();
//                    var pass = $("#password").val();
//                    var confpass = $("#password_confirm").val();
//                    
//                    alert(fullname + " " + user + " " + email + " " + pass + " " + confpass);
                    alert("BANANANAna");
                });
                
            });
            
        </script>
        
    </head>
    
    <body>
        <div class="container-fluid">
            
            <!-- The HEADER and the buttons/links in it -->
            <nav class="navbar navbar-default navbar-fixed-top" id="topheader">
                <div class="container-fluid">
                    <div class="navbar-header">
                        
                        <!-- Brand (aka the app name) -->
                        <a class="navbar-brand" href="#" id="goHome" name="goHome"> 
                            Yeehawz
                        </a>
                        
                        <!-- Links -->
                        <ul class="nav navbar-nav" id="topheaderlink">
                            <li><a href="#">WHAT'S NEW</a></li>
                            <li><a href="#">ABOUT</a></li>
                        </ul>

                        <!-- Sign Up Button -->
                        <form class="navbar-form navbar-right" id="signupForm" name="signupForm">
                            <input type="button" class="btn btn-default navbar-btn" id="signupBtn" name="signupBtn" value="Sign Up" />
                        </form>
                        
                        <!-- Log In: username and password -->
                        <form class="navbar-form navbar-right" id="loginForm" name="loginForm">
                            <label class="sr-only" for="inputUsername">Username</label>
                            <input type="text" class="form-control" id="usernameTxtBox" name="usernameTxtBox" placeholder="Username"/>
                            <label class="sr-only" for="inputPassword">Password</label>
                            <input type="password" class="form-control" id="passwordTxtBox" name="passwordTxtBox" placeholder="Password"/>

                            <!-- Log In Button -->
                            <input type="submit" class="btn btn-default navbar-btn" id="loginSubmit" name="loginSubmit" value="Log In" />
                            
                        </form>
                        
                    </div>
                </div> <!-- /container-fluid -->
            </nav> <!-- /navbar top header -->
            
            <!-- CONTENT -->
            <div class="container-fluid" id="content">
                <div class="row">
                    <div class="col-md-12">

                        <form class="form-horizontal" id="signUp" name="signUp">
                            <fieldset>
                                <div id="legend">
                                    <legend class="">Register</legend>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" id="fullname" name="fullname" placeholder="Fullname" class="form-control input-lg">
                                    </div>
                                </div>
                    
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" id="username" name="username" placeholder="Username" class="form-control input-lg">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="email" id="email" name="email" placeholder="E-mail" class="form-control input-lg">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="password" id="password" name="password" placeholder="Password" class="form-control input-lg">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="password" id="password_confirm" name="password_confirm" placeholder="Confirm Password" class="form-control input-lg">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="submit" id="signupSubmit" name="signupSubmit" class="btn btn-success" value="Sign Up"/>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div> 
            </div>


            <!-- The FOOTER and the buttons/links in it -->
            <nav class="navbar navbar-default navbar-fixed-bottom" id="footer">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <!-- Links -->
                        <ul class="nav navbar-nav" id="footerlink">
                            <li><a href="#">Contact</a></li>
                        </ul>
                        
                    </div>
                </div> <!-- /container-fluid -->
            </nav> <!-- /navbar footer -->

        </div> <!-- /container-fluid BODY -->
    </body>
</html>
