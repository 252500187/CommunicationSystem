<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--<base href=""/>--%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>source/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>source/css/buttons.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>source/jquery-easyui-1.4/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>source/jquery-easyui-1.4/themes/icon.css">

<script type="text/javascript" src="<%=basePath%>source/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>source/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath%>source/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>source/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<script>
    function logout() {
        top.location.href = "<%=basePath%>logout";
    }
</script>

