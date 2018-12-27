<%@ page import="pers.geolo.LogisticsAssistant.entity.Cargo" %>
<%@ page import="java.lang.annotation.Target" %>
<%@ page import="pers.geolo.LogisticsAssistant.service.TradeService" %>
<%@ page import="pers.geolo.LogisticsAssistant.entity.TradeRequest" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: acjieao
  Date: 2018/12/27
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货物详细信息</title>
</head>
<body>
    <%
        Cargo cargo = (Cargo) session.getAttribute("cargoDetail");
        out.println(cargo.toString());
    %>
    <%--
        TODO 货物状态，申请列表

    --%>
    <%
        List<TradeRequest> requestList = TradeService.getInstance().getTradeRequestList(cargo.getCargoNumber());
//        onclick list(i)
//        ajax post requestNumber
//        return ok
    %>
    <button>请求承运</button>
</body>
</html>
