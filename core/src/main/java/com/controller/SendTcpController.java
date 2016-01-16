package com.controller;

import com.core.entity.TcpPacket;
import com.core.service.SendTcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午6:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
@RequestMapping("/sendTcp")
public class SendTcpController {

    @Autowired
    private SendTcpService sendTcpService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public String sendTcpIndex(HttpServletRequest request) {
        request.setAttribute("deviceList", sendTcpService.getDeviceList());
        return "tcpProtocol/sendTcp/sendTcpIndex";
    }

    //发送报文
    @RequestMapping(value = "send", method = {RequestMethod.POST})
    @ResponseBody
    public String sendTcpPacket(@RequestParam("deviceIndex") int deviceIndex, TcpPacket tcpPacket) {
        return sendTcpService.sendTcpPacket(deviceIndex, tcpPacket);
    }

    //已发送TCP报文
    @RequestMapping(value = "sendPackets", method = {RequestMethod.GET})
    public String sendPackets() {
        return "tcpProtocol/sendTcp/sendTcpPackets";
    }

    //刷新表
    @RequestMapping(value = "/refresh", method = {RequestMethod.POST})
    @ResponseBody
    public List<TcpPacket> getTcpPackets() {
        return sendTcpService.getTcpPackets();
    }

    //删除报文
    @RequestMapping(value = "/delPacket", method = {RequestMethod.GET})
    @ResponseBody
    public void delPacket(@RequestParam("id") String id) {
        sendTcpService.delPacket(id);
    }
}
