<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>协议数据收发系统</title>
    <%@include file="include.jsp" %>
</head>
<body style="background-image: url('source/img/index_back.jpg'); overflow-x: hidden">
<nav class="navbar navbar-inverse navbar-fixed-top" style="box-shadow: 0px 5px 5px #888888;background-image: url('source/loginPage/public/images/login_bg.jpg');">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=basePath%>" style="color: #ffffff;font-size: 25px"><b>协议数据收发系统</b></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <a onclick="logout()" class="navbar-form navbar-right" style="color: #ffffff"><b>退出</b></a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <script charset="Shift_JIS"
                src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.js"></script>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4" onclick="changePage('tcpProtocol')">
        <button name="protocol" class="button button-3d button-primary button-circle button-giant">TCP协议</button>
        <div class="collapse" name="title" aria-expanded="true" style="margin-top: 20px">
            <button class="button button-highlight button-box button-giant button-longshadow-right button-longshadow-expand"
                    style="min-width: 300px">
                TCP协议数据收发系统
            </button>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $("[name=protocol]").css("height", document.body.clientWidth / 6);
    $("[name=protocol]").css("width", document.body.clientWidth / 6);
    $("[name=protocol]").bind("mouseover", function () {
        $(this).next("div").removeClass().addClass("collapse in");
    });
    $("[name=protocol]").bind("mouseout", function () {
        $("[name=title]").removeClass().addClass("collapse");
    });
    function changePage(protocolPath) {
        window.location.href = protocolPath;
    }
</script>