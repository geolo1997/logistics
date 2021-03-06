<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chorme=1">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <title>登陆</title>

    <!-- CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min2.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <!-- 拼图验证 -->
    <link rel="stylesheet" href="assets/css/confirm_style.css" >
    <script type="text/javascript" src="assets/js/confirm_style.js"></script>
    <script src="assets/js/FromCheck.js"></script>
</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>搬家轿车装不下？送货运力不太足？
                        <br>
                        物流助手，一点就来劲</strong> </h1>
                    <div class="description">
                        <p>
                            欢迎来到物流助手，我们极速响应，价格透明，运力充足，专业服务
                            <a href="#"></a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎登陆<strong>物流助手</strong></h3>
                            <p>请输入用户名和密码：</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form id="form" method="post" role="form" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="用户名..." class="username form-control" id="username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input type="password" name="password" placeholder="密码..." class="password form-control" id="password">
                            </div>
                            <div style="margin-top: 10px">
                                <!-- booststrap弹窗验证 -->
                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                    登录
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button id="closeButton" type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h3 class="modal-title" id="myModalLabel">滑动拼图以验证...</h3>
                                            </div>
                                            <div class="modal-body">
                                                <!-- 拼图验证 -->
                                                <div id="slideBar" align="center">
                                                    <script type="text/javascript">
                                                        var dataList = ["0","1"];
                                                        var options = {
                                                            dataList: dataList,
                                                            success:function(){
                                                                if (formCheck("form")) {
                                                                    document.getElementById("form").submit();
                                                                } else {
                                                                    document.getElementById("closeButton").click();
                                                                }
                                                            },
                                                            fail: function(){
                                                                console.log("fail");
                                                            }
                                                        };
                                                        SliderBar("slideBar", options);
                                                    </script>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style="margin-top: 10px">
                                <button type="button" class="btn" onclick="location.href='register'">注册</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>
</body>
</html>