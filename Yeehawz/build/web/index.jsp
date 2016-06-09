<%-- 
    Document   : MainPage
    Created on : 06-Jun-2016, 15:35:44
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
        <link rel="stylesheet" href="MainPage.css">
        
        <title>
            Yeehawz
        </title>
        
        <!-- Script for functions -->
        <script>
            // JAVASCRIPT
            /*function loginCheck(){
                var user = document.getElementById('usernameTxtBox').value;
                var pass = document.getElementById('passwordTxtBox').value;
                
                if(user == "admin" && pass == "admin")
                {
                    document.loginForm.action = "TaskMainPage.jsp";
                    document.loginForm.submit();
                    window.location = "TaskMainPage.jsp";
                    
                }
            }
            
            function signUp(){
                window.location = "SignUpPage.jsp";
            }*/
            
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
            <div id="content">
                <div class="container-fluid">
                    
                    <!-- Text -->
                    <div id="contenttext">
                        <h1>
                        The perfect to-do app for lazy bummers.
                        <br>
                        (pls change...)
                        <br>
                        [insert proper thingy here]
                        </h1>
                    </div>
                    
                    <!-- Image -->
                    <div id="contentimg">
                        
                    </div>
                    
                </div>
            </div><!-- /content -->
            
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
