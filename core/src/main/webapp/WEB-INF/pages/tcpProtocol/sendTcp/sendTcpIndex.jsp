<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 15-1-23
  Time: 下午1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送TCP-协议数据收发系统</title>
    <%@include file="../../include.jsp" %>
</head>
<body style="overflow-x:hidden;overflow-y:auto;">
<div class="col-md-10 col-md-offset-1">
    <form id="packetMessage">
        <div class="page-header">
            <div class="row">
                <div class="col-md-9">
                    <h1>
                        <small>发送数据报文</small>
                    </h1>
                </div>
                <div class="col-md-3">
                    <a onclick="sendPackets()" class="button button-glow button-rounded button-raised"
                       style="width: 100%">已发送TCP报文
                    </a>
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
        <hr/>

        <div class="row">
            <label class="control-label col-md-12">IP部分</label>
        </div>

        <div class="row">
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="源IP地址" id="sendIpAddress" name="sendIpAddress">
            </div>
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="目的IP地址" id="receiveIpAddress"
                       name="receiveIpAddress">
            </div>
        </div>
        <hr/>
        <div class="row">
            <label class="control-label col-md-12">TCP部分</label>
        </div>

        <div class="row">
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="源端口" id="srcPort" maxlength="16" name="srcPort">
            </div>
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="目的端口" id="dstPort" maxlength="16" name="dstPort">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-12">
                <input class="form-control" type="text" placeholder="序列号" id="sequence" maxlength="32" name="sequence">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-12">
                <input class="form-control" type="text" placeholder="确认号" id="ackNum" maxlength="32" name="ackNum">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-2">
                <input class="form-control" type="text" placeholder="首部长度(4位)" id="headLen" name="headLen"
                       disabled="true"
                       maxlength="4">
            </div>
            <div class="col-md-2">
                <input class="form-control" type="text" placeholder="保留(6位)" id="keep" name="keep" disabled="true"
                       maxlength="6">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="URG" id="urg" name="urg" maxlength="1">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="ACK" id="ack" name="ack" maxlength="1">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="PSH" id="psh" name="psh" maxlength="1">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="RST" id="rst" name="rst" maxlength="1">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="SYN" id="syn" name="syn" maxlength="1">
            </div>
            <div class="col-md-1">
                <input class="form-control" type="text" placeholder="FIN" id="fin" name="fin" maxlength="1">
            </div>
            <div class="col-md-2">
                <input class="form-control" type="text" placeholder="窗口(16位)" id="window" name="window" maxlength="16">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="校验和" id="checkSum" name="checkSum" disabled="true"
                       maxlength="16">
            </div>
            <div class="col-md-6">
                <input class="form-control" type="text" placeholder="紧急指针" id="urgentPointer" name="urgentPointer"
                       maxlength="16">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-10">
                <input class="form-control" type="text" placeholder="选项" id="tcpOption" name="tcpOption" disabled="true"
                       maxlength="32">
            </div>
            <div class="col-md-2">
                <input class="form-control" type="text" placeholder="填充" id="append" name="append" disabled="true"
                       maxlength="32">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-12">
                <input class="form-control" type="text" placeholder="数据" id="data" name="data" disabled="true"
                       maxlength="32">
            </div>
        </div>
        <br/>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <button class="button button-glow button-rounded button-raised button-primary" type="submit"
                        style="width: 100%">发送
                </button>
            </div>
        </div>
        <br/>
    </form>
</div>
</body>
</html>
<script>
    function sendPackets() {
        location.href = "<%=basePath%>sendTcp/sendPackets";
    }

    function sendPacket() {
        $.ajax({
            url: "<%=basePath%>sendTcp/send",
            type: "post",
            dataType: "json",
            data: {
                deviceIndex: $('#deviceIndex option:selected').val(),
                sendIpAddress: $("#sendIpAddress").val(),
                receiveIpAddress: $("#receiveIpAddress").val(),
                srcPort: $("#srcPort").val(),
                dstPort: $("#dstPort").val(),
                sequence: $("#sequence").val(),
                ackNum: $("#ackNum").val(),
                urg: $("#urg").val(),
                ack: $("#ack").val(),
                psh: $("#psh").val(),
                rst: $("#rst").val(),
                syn: $("#syn").val(),
                fin: $("#fin").val(),
                window: $("#window").val(),
                urgentPointer: $("#urgentPointer").val()
            },
            success: function (result) {
                alert(result.responseText);
            },
            error: function (result) {
                alert(result.responseText);
            }
        });
    }

    $('#packetMessage').validate({
        rules: {
            sendIpAddress: {
                required: true
            },
            receiveIpAddress: {
                required: true
            },
            srcPort: {
                required: true,
                digits: true,
                range: [0, 9999999999999999]
            },
            dstPort: {
                required: true,
                digits: true,
                range: [0, 99999999999999999999999999999999]
            },
            sequence: {
                required: true,
                digits: true,
                range: [0, 99999999999999999999999999999999]
            },
            ackNum: {
                required: true,
                digits: true,
                range: [0, 99999999999999999999999999999999]
            },
            urg: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            ack: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            psh: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            rst: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            syn: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            fin: {
                required: true,
                digits: true,
                range: [0, 1]
            },
            window: {
                required: true,
                digits: true,
                range: [0, 9999999999999999]
            },
            urgentPointer: {
                required: true,
                digits: true,
                range: [0, 9999999999999999]
            }
        },
        messages: {
            sendIpAddress: {
                required: "请填写"
            },
            receiveIpAddress: {
                required: "请填写"
            },
            srcPort: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            dstPort: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            sequence: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            ackNum: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            urg: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            ack: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            psh: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            rst: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            syn: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            fin: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            window: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            },
            urgentPointer: {
                required: "请填写",
                digits: "请填写整数",
                range: "超出范围"
            }
        },
        highlight: function (element) {
            $(element).parent().addClass('has-error');
        },
        success: function (element) {
            $(element).parent().removeClass('has-error');
        },
        errorPlacement: function (error, element) {
            error.appendTo(element.parent());
        },
        submitHandler: function () {
            sendPacket();
        }
    })
</script>