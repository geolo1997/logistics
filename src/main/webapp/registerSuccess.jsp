<%--
  Created by IntelliJ IDEA.
  User: acjieao
  Date: 2018/12/25
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <script language="javascript" type="text/javascript">
        function jump() {
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
注册成功，5秒后跳转至主页
<script language="javascript" type="text/javascript">
    setTimeout(jump(), 10000);
</script>
<%--<%--%>
    <%--try {--%>
        <%--Thread.sleep(5000);--%>
    <%--} catch (InterruptedException e) {--%>
        <%--e.printStackTrace();--%>
    <%--}--%>
    <%--RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");--%>
    <%--dispatcher.forward(request, response);--%>
<%--%>--%>
</body>
</html>
