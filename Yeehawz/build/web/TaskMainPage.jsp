<%-- 
    Document   : TaskMainPage
    Created on : 06-Jun-2016, 18:37:58
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
        <link rel="stylesheet" href="TaskMainPage.css">
        
        <title>
            Yeehawz
        </title>
        
        <!-- Script for functions -->
        <script>
            // JQUERY
            $(document).ready(function(){
                
                $('#logoutHref').on('click', function(){
                    window.location = "index.jsp";
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
                        <a class="navbar-brand" href="#topheader"> 
                            Yeehawz
                        </a>
                        
                        <!-- Buttons -->
                        <ul class="nav navbar-nav navbar-right" id="topheaderlink">
                            <!-- Add new task BUTTON -->
                            <li>
                                <a href="#">
                                <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                </button>
                                </a>
                            </li>
                            <!-- Settings BUTTON -->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Firstname Lastname
                                    <span class="glyphicon glyphicon-user pull-right"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Messages <span class="glyphicon glyphicon-envelope pull-right"></span></a></li>
                                    <li class="divider"></li>
                                    <li><a id="logoutHref" name="logoutHref" href="#">Log Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
                              </ul>
                            </li>
                        </ul>
                    </div>
                </div><!-- /container-fluid -->
            </nav><!-- /navbar top header END OF HEADER-->
            
            
            <!-- BODY CONTENT -->
            <div>
            </div>
            
        </div><!-- /container-fluid BODY -->
    </body>
</html>
