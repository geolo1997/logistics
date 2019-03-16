<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/css/bootstrap.min2.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    <!-- 拼图验证 -->
    <link rel="stylesheet" href="./slider/style.css" >
    <script type="text/javascript" src="./slider/style.js"></script>
    <script src="assets/js/FromCheck.js"></script>
</head>
<body>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>尼玛拉货</strong></h1>
                    <div class="description">
                        <p>
                            欢迎注册<a href="#"><strong>尼玛拉货</strong></a>, 只需要简单几步，即可开启拉货之旅
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>注册</h3>
                            <p>请输入您的用户信息：</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form id="form" role="form" action="" method="post" class="login-form">
                            <div class="form-group">
                                <input type="text" name="username" placeholder="用户名"
                                       class="username form-control" id="username"
                                       required="required">
                            </div>

                            <div class="form-group">

                                <input type="text" name="password" placeholder="密码"
                                       class="password form-control" id="password"
                                       required="required">
                            </div>
                            <div class="form-group">
                                <input type="text" name="email" placeholder="邮箱地址"
                                       class="form-mailAddress form-control" id="form-mailAddress"
                                       required="required">
                            </div>
                            <div class="form-group">
                                <input type="radio" class="radio-inline" name="userType"
                                       value="shipper">货主
                                <input type="radio" class="radio-inline" name="userType"
                                       value="driver">司机
                            </div>
                            <div style="margin-top: 10px">
                                <!-- booststrap弹窗验证 -->
                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">注册</button>
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
                        </form>
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