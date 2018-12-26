<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆界面</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
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
            <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
            <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
            <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
            <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
            <!-- 拼图验证 -->
            <link rel="stylesheet" href="./slider/style.css" >
            <script type="text/javascript" src="./slider/style.js"></script>
        </head>

        <body>

            <!-- Top content -->
            <div class="top-content">

                <div class="inner-bg">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-8 col-sm-offset-2 text">
                                <h1><strong>拉货 搬家 运大件</strong> </h1>
                                <div class="description">
                                 <p>
                                   欢迎来到****，我们极速响应，价格透明，运力充足，专业服务
                                   <a href="#"></a>
                               </p>
                           </div>
                       </div>
                   </div>
                   <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                       <div class="form-top">
                          <div class="form-top-left">
                             <h3>欢迎登陆****</h3>
                             <p>请输入用户名和密码：</p>
                         </div>
                         <div class="form-top-right">
                           <i class="fa fa-key"></i>
                       </div>
                   </div>
                   <div class="form-bottom">
                       <form id="form" method="post"  role="form" class="login-form">
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
                          Launch demo modal
                      </button>
                      <!-- Modal -->
                      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">请验证...</h4>
                            </div>
                            <div class="modal-body">
                                <!-- 拼图验证 -->
                                <div id="slideBar" align="center">
                                    <script type="text/javascript">
                                        var form = document.getElementById('test_form');
                                        var dataList = ["0","1"];
                                        var options = {
                                            dataList: dataList,
                                            success:function(){
                                                 $("form").submit();
                                                // $.ajax({
                                                // //几个参数需要注意一下
                                                //     type: "POST",//方法类型
                                                //     dataType: "json",//预期服务器返回的数据类型
                                                //     url: "login" ,//url
                                                //     data: $('#form').serialize(),
                                                //     success: function (result) {
                                                //         console.log(result);//打印服务端返回的数据(调试用)
                                                //         if (result.resultCode == 200) {
                                                //             alert("SUCCESS");
                                                //         };
                                                //     },
                                                //     error : function() {
                                                //         alert("异常！");
                                                //     }
                                                // });
                                            },
                                            fail: function(){
                                                console.log("fail");  
                                            }
                                        };
                                        SliderBar("slideBar", options);
                                    </script>
                                </div>
                            </div>
                                   <!--  <div class="modal-footer">
                               </div> -->
                           </div>
                       </div>
                   </div>
                </div>
                   <!--  -->
                <div style="margin-top: 10px">
                   <button type="submit" class="btn">登陆</button>
               </div>
               <div style="margin-top: 10px">
                <button type="submit" class="btn" onclick="location.href='register.html'">注册</button>
            </div>
        </form>
    </div>
</div>
</div>
<div class="row">
    <div class="col-sm-6 col-sm-offset-3 social-login">
     <h3>...or login with:</h3>
     <div class="social-login-buttons">
      <a class="btn btn-link-1 btn-link-1-facebook" href="#">
       <i class="fa fa-facebook"></i> Facebook
   </a>
   <a class="btn btn-link-1 btn-link-1-twitter" href="#">
       <i class="fa fa-twitter"></i> Twitter
   </a>
   <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
       <i class="fa fa-google-plus"></i> Google Plus
   </a>
</div>
</div>
</div>
</div>
</div>

</div>


<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
            <![endif]-->

        </body>

        </html>