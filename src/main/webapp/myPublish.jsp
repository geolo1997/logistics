<%@ page import="java.util.List" %>
<%@ page import="pers.geolo.logistics.entity.Cargo" %>
<%@ page import="pers.geolo.logistics.entity.User" %>
<%@ page import="pers.geolo.logistics.constant.UserType" %>
<%@ page import="pers.geolo.logistics.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>我的发布-物流助手</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/ready.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <script src="assets/js/PermissionCheck.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        user = new User();
    }
%>
<div id="stateTag" style="display: none;"><%=user.getUsername()%></div>
<div id="identity" style="display: none;"><%=user.getUserType()%></div>
<div class="wrapper">
    <div class="main-header">
        <div class="logo-header">
            <a href="index" class="logo">
                物流助手
            </a>
        </div>
        <nav class="navbar navbar-header navbar-expand-lg" style="margin-top:10px;">
            <div class="container-fluid" >
                <form class="navbar-left navbar-form nav-search mr-md-3" action="">
                    <div class="input-group">
                        <input type="text" placeholder="Search ..." class="form-control">
                        <div class="input-group-append">
								<span class="input-group-text">
									<i class="la la-search search-icon"></i>
								</span>
                        </div>
                    </div>
                </form>
                <ul class="navbar-nav topbar-nav ml-md-auto align-items-center">

                    <div id="login_or_register" class="btn-group" role="group" aria-label="...">
                        <a href="login" class="btn btn-default">登录</a>
                        <a href="register" class="btn btn-default">注册</a>
                    </div>
                    <li id="profileLi" class="nav-item dropdown">
                        <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"
                           aria-expanded="false">
                            <img src="assets/img/profile.jpg" alt="user-img" width="36"
                                 class="img-circle">
                            <span><%=user.getUsername()%></span></span>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li>
                                <!-- 右上用户信息列表 -->
                                <div class="user-box">
                                    <div class="u-img">
                                        <img src="assets/img/profile.jpg" alt="user">
                                    </div>
                                    <div class="u-text">
                                        <h4><%=user.getUsername()%>
                                        </h4>
                                        <p class="text-muted"><%=user.getEmail()%>
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="profile"><i class="ti-user"></i>我的资料</a>
                            <a class="dropdown-item" href="message"></i>我的消息</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="logout"><i class="fa fa-power-off"></i>注销登录</a>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- 左侧导航栏 -->
    <div class="sidebar" id="sidebar">
        <div class="scrollbar-inner sidebar-wrapper">
            <div class="user">
                <div class="photo">
                    <img src="assets/img/profile.jpg">
                </div>
                <div class="info">
                    <a class="" data-toggle="collapse" href="#collapseExample" aria-expanded="true">
							<span>
								<%=user.getUsername()%>
								<span class="user-level">
                                    <%
                                        if (user.getUserType() == UserType.DRIVER) {
                                            out.println("司机");
                                        } else if (user.getUserType() == UserType.SHIPPER) {
                                            out.println("货主");
                                        } else {
                                            out.println("未定义");
                                        }
                                    %>
                                </span>
								<span class="caret"></span>
							</span>
                    </a>
                    <div class="clearfix"></div>

                    <div class="collapse in" id="collapseExample" aria-expanded="true" style="">
                        <ul class="nav">
                            <li>
                                <a href="profile">
                                    <span class="link-collapse">我的资料</span>
                                </a>
                            </li>
                            <li>
                                <a href="message">
                                    <span class="link-collapse">我的消息</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <ul class="nav">
                <li class="nav-item active">
                    <a href="index">
                        <i class="la la-dashboard"></i>
                        <p>主页</p>
                        <!-- <span class="badge badge-count">5</span> -->
                    </a>
                </li>
                <li class="nav-item shippers">
                    <a href="myPublish">
                        <i class="la la-table"></i>
                        <p>我的发布</p>
                    </a>
                </li>
                <li class="nav-item shippers">
                    <a href="publish">
                        <i class="la la-keyboard-o"></i>
                        <p>我要发货</p>
                    </a>
                </li>
                <li class="nav-item drivers">
                    <a href="allPublished">
                        <i class="la la-car"></i>
                        <p>我要接单</p>
                    </a>
                </li>
                <li class="nav-item drivers">
                    <a href="myRequest">
                        <i class="la la-bell"></i>
                        <p>我的请求</p>
                    </a>
                </li>
                <li class="nav-item drivers">
                    <a href="tradeOrder">
                        <i class="la la-font"></i>
                        <p>我的订单</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <script> permissionCheck();</script>
    <!-- main-pannel -->
    <div class="main-panel">
        <div class="content">
            <div class="container-fluid">
                <h4 class="page-title">我发布的订单</h4>
                <div class="row">
                    <%
                        List<Cargo> cargoList = (List<Cargo>) request.getAttribute("cargoList");
                        if (cargoList != null) {
                            for (int i = 0; i < cargoList.size(); i++) {
                                Cargo cargo = cargoList.get(i);
                                out.println("<div class=\"col-md-4\">\n" +
                                        "                            <div class=\"card\">\n" +
                                        "                                <div class=\"card-header\">\n" +
                                        "                                    <div class=\"card-title\">订单信息</div>\n" +
                                        "                                </div>\n" +
                                        "                                <div class=\"card-body\">\n" +
                                        "                                    <ul class=\"list-group\">");
                                out.println("<li class=\"list-group-item\">货物编号:" + cargo.getId() + "</li>");
                                out.println("<li class=\"list-group-item\">货主用户名:" + UserService.getInstance().getUsername(cargo.getShipperId()) + "</li>");
                                out.println("<li class=\"list-group-item\">发布时间：" + cargo.getPublishTime() + "</li>");
                                out.println("<li class=\"list-group-item\">货物名称:" + cargo.getCargoName() + "</li>");
                                out.println("<li class=\"list-group-item\">货物类型:" + cargo.getCargoType() + "</li>");
                                out.println("<li class=\"list-group-item\">起点:" + cargo.getOrigin() + "</li>");
                                out.println("<li class=\"list-group-item\">终点:" + cargo.getDestination() + "</li>");
                                out.println("<li class=\"list-group-item\">距离(km):" + cargo.getDistance() + "</li>");
                                out.println("<li class=\"list-group-item\">运费（元）:" + cargo.getFreight() + "</li>");
                                out.println(" </ul>\n" +
                                        "                                </div>\n" +
                                        "                                <div class=\"button\" align=\"center\">");
                                out.println("<a href=\"cargoDetail?cargoId=" + cargo.getId() + "\"><button class=\"btn btn-success\" >订单详情</button></a>");
                                out.println("<br><br></div>\n" +
                                        "                            </div>\n" +
                                        "                        </div>");
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="assets/js/core/jquery.3.2.1.min.js"></script>
<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/plugin/chartist/chartist.min.js"></script>
<script src="assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script src="assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="assets/js/ready.min.js"></script>
<script>
    $(function () {
        $("#slider").slider({
            range: "min",
            max: 100,
            value: 40,
        });
        $("#slider-range").slider({
            range: true,
            min: 0,
            max: 500,
            values: [75, 300]
        });
    });
</script>
</html>
