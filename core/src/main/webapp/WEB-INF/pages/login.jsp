<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 15-1-30
  Time: 下午2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登陆-协议数据收发系统</title>
    <link href="source/loginPage/public/css/base.css" rel="stylesheet" type="text/css">
    <link href="source/loginPage/public/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="margin: 30px">
    <script charset="Shift_JIS"
            src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.js"></script>
</div>
<div class="login">
    <form method="post" id="form" action="loginDeal">
        <div class="logo"></div>
        <div class="login_form">
            <div class="user">
                <input class="text_value" id="userName" name="userName" value="" type="text" placeholder="账户">
                <input class="text_value" id="password" name="password" value="" type="password" placeholder="密码">
            </div>
            <button class="button" type="submit">登录</button>
        </div>
        <div id="tip">
            <label>
                <input type="checkbox" name="<%=request.getAttribute("checkName")%>"> 我不是机器人
            </label>
        </div>
        <div class="foot">
        </div>
    </form>
</div>
</body>
</html>
<script>var basedir = 'source/loginPage/public/ui/';</script>
<script src="source/loginPage/public/ui/do.js"></script>
<script src="source/loginPage/public/ui/config.js"></script>