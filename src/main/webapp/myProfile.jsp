<%@ page import="pers.geolo.LogisticsAssistant.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>我的资料</title>
</head>
<body>
    <%
        // 获取已登录的用户信息
        User user = (User) session.getAttribute("user");
    %>
    <form>
        <label>用户名</label>
        <input class="form-control" type="text" name="username" value=<%= user.getUsername()%> >
        <label>密码</label>
        <input class="form-control" type="password" name="password" value=<%= user.getPassword()%> >
        <label>邮箱地址</label>
        <input class="form-control" type="text" name="email" value=<%= user.getEmail()%> >
        <label>用户类型</label>
        <input class="form-control" type="text" name="userType" value=<%= user.getUserType()%> >
        <label>真实姓名</label>
        <input class="form-control" type="text" name="realName" value=<%= user.getRealName()%> >
        <label>电话号码</label>
        <input class="form-control" type="text" name="telephone" value=<%= user.getTelephone()%> >
        <label>车辆类型</label>
        <input class="form-control" type="text" name="vehicleType" value=<%= user.getVehicleType()%> >
        <label>车牌号码</label>
        <input class="form-control" type="text" name="licensePlateNumber" value=<%= user.getLicensePlateNumber()%> >
        <label>运输类型</label>
        <input class="form-control" type="text" name="transportableType" value=<%= user.getTransportableType()%>>
        <label>地址</label>
        <input class="form-control" type="text"  name="address" value=<%= user.getAddress()%>>
        <button type="button" onclick="">编辑信息</button>
        <button type="submit">保存修改</button>
    </form>
</body>
</html>

