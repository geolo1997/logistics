<%@ page import="pers.geolo.LogisticsAssistant.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: acjieao
  Date: 2018/12/26
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的资料</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        out.print(user.toString());
    }
%>
</body>
</html>
