<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 15-1-30
  Time: 下午12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已发送TCP-协议数据收发系统</title>
    <%@include file="../../include.jsp" %>
</head>
<body style="overflow-x:hidden;overflow-y:auto;">
<div class="col-md-10 col-md-offset-1">
    <div class="page-header">
        <div class="row">
            <div class="col-md-9">
                <h1>
                    <small>已发送数据报文</small>
                </h1>
            </div>
            <div class="col-md-3">
                <a onclick="returnTCPPage()" class="button button-glow button-rounded button-raised"
                   style="width: 100%">返回发送TCP报文
                </a>
            </div>
        </div>
    </div>
</div>
<div class="col-md-10 col-md-offset-1" style="margin-top: 20px">
    <table id="packets"></table>
</div>
</body>
</html>
<script>
    function returnTCPPage() {
        location.href = "<%=basePath%>sendTcp";
    }

    $('#packets').datagrid({
        url: '<%=basePath%>sendTcp/refresh',
        fitColumns: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        loadMsg: "正在加载已发送TCP数据包...",
        showFooter: true,
        columns: [
            [
                {field: 'option', title: '操作', formatter: function (value, row, index) {
                    return "<a onclick='deletePacket(" + row.id + ")'>删除</a>";
                }},
                {field: 'deviceDescription', title: '设备描述'},
                {field: 'sendTime', title: '发送时间'},
                {field: 'sendIpAddress', title: '发送IP地址'},
                {field: 'receiveIpAddress', title: '接收IP地址'},
                {field: 'srcPort', title: '源端口'},
                {field: 'dstPort', title: '目的端口'},
                {field: 'sequence', title: '序号'},
                {field: 'ackNum', title: '确认序号'},
                {field: 'headLen', title: '头部长度'},
                {field: 'keep', title: '保留'},
                {field: 'urg', title: 'urg'},
                {field: 'ack', title: 'ack'},
                {field: 'psh', title: 'psh'},
                {field: 'rst', title: 'rst'},
                {field: 'syn', title: 'syn'},
                {field: 'fin', title: 'fin'},
                {field: 'window', title: '窗口'},
                {field: 'checkSum', title: '检验和'},
                {field: 'urgentPointer', title: '紧急指针'}
            ]
        ]
    });

    function deletePacket(id) {
        if (window.confirm('确认删除')) {
            $.ajax({
                url: "<%=basePath%>/sendTcp/delPacket?id=" + id,
                type: "get",
                success: function () {
                    $('#packets').datagrid('reload');
                }
            });
        }
    }
</script>