# Logistics-Assistant
web应用——物流助手，您的物流好帮手

介绍
-----
本项目是大三上学期综合实验，四人小组为期两周时间开发，实际使用10天开发完成，
因时间仓促，本人及同组同学开发经验较少，Git和GitHub使用不熟练，所以有小部分功能未完善，提交也较为不规范。<br>
本人为组长，负责设计架构，和主要的后端开发工作。
<br><br>
项目使用Servlet和JSP技术，Servlet、Service、DAO三层架构，Servlet调用Service获取数据转发至JSP渲染视图，DAO层使用原生JDBC操作数据库，使用工厂模式，面向接口编程，未使用框架。
<br>
网页套用模板，主页内容为内嵌的模板网站。<br>
主要负责前端开发的同学：https://github.com/Jiangxindong

系统功能描述
--
参考题目7：物流运输平台设计与开发<br>
题目概述：<br>
随着物流行业的高速发展，物流从业人员数量急剧增加，货物和车辆信息急需通畅的平台予以发布，本系统是专门针对物流行业设计开发的，物流行业人员可通过软件随时发布或找到自己适合的货源信息、车源信息，便于货主随时发布货物信息，及时了解货物承运情况，提高货物运输速度，减少运输成本。便于车主寻找货物信息，提高车辆利用率。<br>
题目要求：<br>
1）提供货主和司机注册功能。货主方包括：姓名、联系方式、常用货物、住址等。司机方：姓名、联系方式、车型、车牌号、可运输类型等。<br>
2）货主方和车主方都可以完善身份信息<br>
3）货主方可以发布货物信息。包括：货物名称、货物类别、运输起点、运输目的地、运费要求等。货主发布完信息后可以浏览发布的货物信息，可以查看货物的运输状态。如果有司机准备承运货物，货主可以选择对应司机（一条货物信息，可以有多个司机进行选择，由货主选择一个司机承运）。<br>
4）司机可以在平台上浏览、查询所有货物信息（可以出发地、目的地、运输时间、货物等条件对货物信息进行筛选），可以选择货物信息进行承运。可以查看所有自己选择承运的货物信息。一旦货主方选定司机运输，司机可以在平台上修改运单状态，承运完成后可以修改运单状态为已完成。<br>
5）货主发布的货物运单有如下状态变化：等待司机承运、选定司机、正在运输、已到达目的地、运输完成。货主在选定司机后运费会自动交由平台管理，司机在运输完成后可以修改订单状态为“已到达目的地”。货主确认货物已收到后，运费转到司机账户。<br>

网页截图
--

![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2000-23-28屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2000-24-14屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2000-24-58屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2000-26-49屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2010-48-21屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2010-49-19屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2010-49-59屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2010-50-21屏幕截图.png)
![image](https://github.com/Geolo1997/Nima-Logistics/raw/master/image/2019-03-16%2010-53-39屏幕截图.png)

TODO
--
项目还可以完善的地方有：<br>
1.货物类型使用下拉列表<br>
2.加入运费收取功能<br>
3.加入消息功能，可以及时推送信息<br>
4.加入自动计算路程和费用功能<br>
5.数据库使用连接池

