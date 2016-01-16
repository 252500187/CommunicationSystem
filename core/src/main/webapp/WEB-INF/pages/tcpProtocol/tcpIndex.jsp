<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 15-1-26
  Time: 下午4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TCP-协议数据收发系统</title>
    <%@include file="../include.jsp" %>
</head>
<body style="overflow-y: hidden">
<nav class="navbar navbar-inverse navbar-fixed-top" style="box-shadow: 0px 5px 5px #888888;background-image: url('source/loginPage/public/images/login_bg.jpg');">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="tcpProtocol" style="color: #ffffff;font-size: 25px"><b>TCP协议数据收发系统</b></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <a onclick="logout()" class="navbar-form navbar-right" style="color: #ffffff"><b>退出</b></a>
            <a onclick="returnPage()" class="navbar-form navbar-right" style="color: #ffffff"><b>返回</b></a>
        </div>
    </div>
</nav>
<div style="height: 30px"></div>
<div data-interval="0" class="carousel slide" id="carousel-example-captions">
    <ol class="carousel-indicators">
        <li data-slide-to="0" data-target="#carousel-example-captions" class="active"></li>
        <li data-slide-to="1" data-target="#carousel-example-captions" class=""></li>
    </ol>
    <div role="listbox" class="carousel-inner">
        <div class="item active">
            <div class="col-md-12">
                <iframe src="<%=basePath%>receiveTcp" style="width:100%; height:99%;border:0px;"></iframe>
            </div>
        </div>
        <div class="item">
            <div class="col-md-12">
                <iframe src="<%=basePath%>sendTcp" style="width:100%; height:99%;border:0px;"></iframe>
            </div>
        </div>
    </div>
    <a data-slide="prev" role="button" href="#carousel-example-captions" class="left carousel-control"
       style="width: 60px">
        <span aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a data-slide="next" role="button" href="#carousel-example-captions" class="right carousel-control"
       style="width: 60px">
        <span aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</body>
</html>
<script>
    function returnPage() {
        top.location.href = "<%=basePath%>";
    }
</script>