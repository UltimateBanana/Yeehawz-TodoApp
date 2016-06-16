
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap stuff -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <script src="bootstrap-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="datepicker.css">

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
        <script>
            // MODAL STUFF
            $(document).ready(function(){

                $("#createTask").submit(function(){
                    var x = $("#task").val();
                    
                    alert("Date : " + $("#datepickerCreateTask").val());

                    if(!x){
                        alert("Please enter text")
                    }
                    else{
                        $("#taskList").append('<li class='+ '"list-group-item"'+ '>'+ x + '<span class="glyphicon glyphicon-trash pull-right deleteMe"> </span> ' + 
                                        '<span class="glyphicon glyphicon-edit pull-right editMe"> </span></li>');
                      }
                      console.log(x);
                });
            });

            $(document).on('click', '.deleteMe',function(){
                $(this).closest("li").remove();

            });
            
            $(document).on('click', '.editMe',function(){
                $('#editModal').modal('show');
            });

        </script>
        
        <script>
            // DATEPICKER STUFF
            $('body').on('click', '.datepicker', function () {
                $(this).datepicker();
                }).on('focus', '.datepicker', function () {
                $(this).datepicker();
            });
        </script>
        
        <style>
          .margin12 {
              margin-top: 12px;
          }

          .margin11 {
              margin-top: 11.5px;
          }

          .marginLeftTop{
            margin-top: 14px;
            margin-left: 16px;
          }
        </style>
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
                                <ul  class="dropdown-menu">
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
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="card">
                            <ul id = "taskList" class="list-group list-group-flush">

                                <!-- ADD A TASK -->
                                <li class="list-group-item">
                                    <div class="row center-block">
                                        <form id="createTask">
                                                <div class="col-md-10 ">
                                                    <input type="text" class="form-control margin12" id="task" placeholder="Type Task" style="margin-bottom: 10px;">
                                                    <textarea class="form-control" id="descriptionTextArea" rows="3" placeholder="Enter a description" style="resize: none; margin-bottom: 10px;"></textarea>
                                                    <input type = "text" class="datepicker" id="#datepickerCreateTask" placeholder="Schedule">
                                                    <script>
                                                      $('.datepicker').datepicker();
                                                    </script>
                                                </div>
                                                <div class="col-md-2">
                                                    <input id = "addTask" type="submit" class="btn btn-success margin11" value="Add Task">
                                                </div>
                                        </form>
                                    </div>
                                </li>
                                <li class="list-group-item" data-toggle="modal" data-target="#myModal"> 
                                    Dapibus ac facilisis in  
                                    <span class="glyphicon glyphicon-trash pull-right deleteMe"> </span> 
                                    <span class="glyphicon glyphicon-edit pull-right editMe"> </span>
                                </li>
                                <li class="list-group-item">
                                    Vestibulum at eros 
                                    <span class="glyphicon glyphicon-trash pull-right deleteMe"> </span> 
                                    <span class="glyphicon glyphicon-edit pull-right editMe"> </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>

        <!-- Task -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- View Task Content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <p>Some text in the modal.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
        
        <!-- EDIT Task -->
        <div class="modal fade" id="editModal" role="dialog">
            <div class="modal-dialog">
                
                <!-- View Task Content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Task</h4>
                    </div>
                    <form class="form-horizontal">
                        <div class="modal-body">
                            <input type="text" class="form-control" id="editTitle" value="Well shiiiiit" style="margin-bottom: 20px;">
                            <textarea rows="5" class="form-control" id="editDescription" style="resize: none; margin-bottom: 20px;">EEEEYYYYY</textarea>
                            <input type="text" class="datepicker" id="datepickerEditTask" placeholder="Schedule" style="display: block!important;">
                            <script>
                                $('.datepicker').datepicker();
                            </script>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" id="editSave" value="Save changes">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        
        </div><!-- /container-fluid BODY -->
    </body>
</html>
