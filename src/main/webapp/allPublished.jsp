<%@ page import="java.util.List" %>
<%@ page import="pers.geolo.LogisticsAssistant.entity.Cargo" %><%--
  Created by IntelliJ IDEA.
  User: 631059678
  Date: 2018/12/26
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Cargo> allCargoList = (List<Cargo>) session.getAttribute("allCargoList");
    for (int i = 0; i<allCargoList.size();i++){
        String str = allCargoList.get(i).toString();
        out.println(str);
    }
%>
</body>
</html>
