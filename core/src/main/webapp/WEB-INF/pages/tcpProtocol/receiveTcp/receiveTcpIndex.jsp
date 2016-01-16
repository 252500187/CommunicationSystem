<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 15-1-22
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收TCP-协议数据收发系统</title>
    <%@include file="../../include.jsp" %>
</head>
<body style="overflow-x:hidden;overflow-y:auto;">
<div class="col-md-10 col-md-offset-1">
    <div class="page-header">
        <div class="row">
            <div class="col-md-12">
                <h1>
                    <small>接收数据报文</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <label class="control-label col-md-1 col-md-offset-1" for="deviceIndex"> 设备:</label>

        <div class="col-md-9">
            <select class="form-control" id="deviceIndex">
                <%
                    int i = 0;
                    for (String deviceName : (String[]) request.getAttribute("deviceList")) {
                %>
                <option value="<%=i++%>"><%=deviceName%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
    </div>
    <br/>
    <div class="col-md-4 col-md-offset-4">
        <a class="button button-glow button-rounded button-raised button-primary" onclick="startReceive()">开始接收</a>
        <a class="button button-glow button-rounded button-caution" onclick="stopReceive()">停止接收</a>
    </div>
</div>
<div class="col-md-10 col-md-offset-1" style="margin-top: 20px">
    <table id="packets"></table>
</div>
</body>
</html>
<script>
    var intervalId;

    function startReceive() {
        $.ajax({
            url: "<%=basePath%>/receiveTcp/start",
            type: "get",
            data: {
                deviceIndex: $('#deviceIndex option:selected').val()
            },
            success: function (result) {
                if (result == "开始接收") {
                    intervalId = window.setInterval(function () {
                        $('#packets').datagrid('reload')
                    }, 3000);
                } else {
                    alert(result);
                }
            }
        });
    }

    function stopReceive() {
        $.ajax({
            url: "<%=basePath%>/receiveTcp/stop",
            type: "get",
            success: function (result) {
                if (result == "停止接收") {
                    window.clearInterval(intervalId);
                } else {
                    alert(result);
                }
            }
        });
    }

    $('#packets').datagrid({
        url: '<%=basePath%>receiveTcp/refresh',
        fitColumns: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        loadMsg: "正在加载已接收TCP数据包...",
        showFooter: true,
        columns: [
            [
                {field: 'option', title: '操作', formatter: function (value, row, index) {
                    return "<a onclick='deletePacket(" + row.id + ")'>删除</a>";
                }},
                {field: 'deviceDescription', title: '设备描述'},
                {field: 'receiveTime', title: '接收时间'},
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
                {field: 'urgentPointer', title: '紧急指针'},
                {field: 'tcpOption', title: '选项和填充', width: 30},
                {field: 'data', title: '数据部分'}
            ]
        ]
    });

    function deletePacket(id) {
        if (window.confirm('确认删除')) {
            $.ajax({
                url: "<%=basePath%>/receiveTcp/delPacket?id=" + id,
                type: "get",
                success: function () {
                    $('#packets').datagrid('reload');
                }
            });
        }
    }
</script>