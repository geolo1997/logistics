<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录错误</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chorme=1">
    <!-- 3秒后跳转页面-->
    <meta http-equiv="refresh" content="3;URL=login">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Favicon and touch icons -->
 <style type="text/css">
        #content {
            margin-left: auto;
            margin-right: auto;
            margin-top: 200px;
            padding: 50px;
            width: 600px;
            height: 300px;
        }
        body {
            background: url("assets/img/backgrounds/1.jpg");
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div id="content" class="alert alert-danger" role="alert">
                <br/>
                <h1 class="alert-link">账号或密码错误，请重试！</h1>
                <br/>
                <p class="alert-link">3秒后返回登录页面...</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
