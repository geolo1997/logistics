<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pers.geolo.LogisticsAssistant.entity.User"  %>
<html>
<head>
    <title>物流</title>
</head>
<body>
<h2>Hello World!</h2>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        out.print(user.getUsername() + "\n" + user.getPassword());
    }
%>

<a href="login">登录</a>
<a href="register">注册</a>
<%
    if (session.getAttribute("user") != null) {
        out.println("已登录");
    } else {
        out.println("未登录");
    }
%>
<a href="profile">我的资料</a>
<a href="logout">注销登录</a>
</body>
</html>
