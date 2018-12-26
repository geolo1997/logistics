<%@ page import="java.util.List" %>
<%@ page import="pers.geolo.LogisticsAssistant.entity.CargoInformation" %><%--
  Created by IntelliJ IDEA.
  User: acjieao
  Date: 2018/12/26
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<CargoInformation> cargoList = (List<CargoInformation>) session.getAttribute("cargoList");
    for (int i = 0; i < cargoList.size(); i++) {
        out.println("第" + i + "条" + cargoList.toString());
    }
%>
</body>
</html>
