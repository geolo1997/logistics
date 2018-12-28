<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>登录</title>
    </head>
    <body>
        <!-- 登录表单 -->
        <form id="login_form" method="post">
            <input type="text" name="username" placeholder="用户名">
            <input type="password" name="password" placeholder="密码">
            <input type="submit" value="登录">
        </form>
        <!-- 登录表单 -->

        <button onclick="location.href='register'">注册</button>
    </body>
</html>