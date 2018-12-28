<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
</head>
<body>
	<!-- 导航栏 -->
	<div>
		<ul style="list-style: none;">
			<%
				if (session.getAttribute("user") == null) {
					out.print("<li ><a href=\"login\">登录</a></li>\n" +
							"\t\t\t<li ><a href=\"register\">注册</a></li>");
				}
			%>
			<li ><a href="profile">我的资料</a></li>
			<li ><a href="message">我的消息</a></li>
			<li ><a href="publish">我要发货</a></li>
			<li ><a href="myPublish">我的发布</a></li>
			<li ><a href="allPublished">我要接单</a></li>
			<li ><a href="myPublish">我的订单</a></li>
			<%
				if (session.getAttribute("user") != null) {
					out.print("<li ><a href=\"logout\">注销登录</a></li>");
				}
			%>
		</ul>
	</div>
	<!-- 导航栏 -->
</body>
</html>