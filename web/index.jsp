<%-- 
    Document   : MainPage
    Created on : 06-Jun-2016, 15:35:44
    Author     : hannah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <!-- Link to CSS file -->
        <link rel="stylesheet" href="MainPage.css">
        
        <title>
            Yeehawz - To-do App
        </title>
        
        <!-- Script for functions -->
        <script>
            // JAVASCRIPT
            function loginCheck(){
                var user = document.getElementById('usernameTxtBox').value;
                var pass = document.getElementById('passwordTxtBox').value;
                
                if(user == "admin" && pass == "admin")
                {
//                    document.loginForm.action = "TaskMainPage.jsp";
//                    document.loginForm.submit();
                    window.location = "TaskMainPage.jsp";
                    
                }
            }
            
            /*$(document).ready(function(){
                
                $('.loginForm').click(function(){
                    
                    var user = document.getElementById('usernameTxtBox').value;
                    var pass = document.getElementById('passwordTxtBox').value;
                
                    if(user == "admin" && pass == "admin")
                    {
                        window.location = "TaskMainPage.html";
                    }
                    
                    window.location = "TaskMainPage.html";    
                });
                
            })*/
            
        </script>
    </head>
    <body>
        <div class="container-fluid">
            
            <!-- The HEADER and the buttons/links in it -->
            <nav class="navbar navbar-default navbar-fixed-top" id="topheader">
                <div class="container-fluid">
                    <div class="navbar-header">
                        
                        <!-- Brand (aka the app name) -->
                        <a class="navbar-brand" href="#topheader"> 
                            Yeehawz
                        </a>
                        
                        <!-- Links -->
                        <ul class="nav navbar-nav" id="topheaderlink">
                            <li><a href="#">WHAT'S NEW</a></li>
                            <li><a href="#">ABOUT</a></li>
                        </ul>

                        <!-- Sign Up Button -->
                        <form class="navbar-form navbar-right" name="signupForm">
                            <button type="button" class="btn btn-default navbar-btn" id="signupBtn">Sign Up</button>
                        </form>
                        
                        <!-- Log In: username and password -->
                        <form class="navbar-form navbar-right" name="loginForm">
                            <label class="sr-only" for="inputUsername">Username</label>
                            <input type="text" class="form-control" id="usernameTxtBox" name="usernameTxtBox" placeholder="Username"/>
                            <label class="sr-only" for="inputPassword">Password</label>
                            <input type="password" class="form-control" id="passwordTxtBox" name="passwordTxtBox" placeholder="Password"/>

                            <!-- Log In Button -->
                            <button id="loginSubmit" name="loginSubmit" type="submit" class="btn btn-default navbar-btn" onclick="loginCheck(); return false;">Log In</button>
                            
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
