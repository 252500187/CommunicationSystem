package com.controller;

import com.core.entity.TcpPacket;
import com.core.service.ReceiveTcpService;
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
 * Time: 下午6:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
@RequestMapping("/receiveTcp")
public class ReceiveTcpController {

    @Autowired
    private ReceiveTcpService receiveTcpService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public String receiveTcpIndex(HttpServletRequest request) {
        request.setAttribute("deviceList", receiveTcpService.getDeviceList());
        return "tcpProtocol/receiveTcp/receiveTcpIndex";
    }

    //开始接收TCP
    @RequestMapping(value = "/start", method = {RequestMethod.GET})
    @ResponseBody
    public String startReceiveTcp(@RequestParam("deviceIndex") int deviceIndex) {
        return receiveTcpService.startReceiveTcp(deviceIndex);
    }

    //停止接收TCP
    @RequestMapping(value = "/stop", method = {RequestMethod.GET})
    @ResponseBody
    public String stopReceiveTcp() {
        return receiveTcpService.stopReceiveTcp();
    }

    //刷新表
    @RequestMapping(value = "/refresh", method = {RequestMethod.POST})
    @ResponseBody
    public List<TcpPacket> getTcpPackets() {
        return receiveTcpService.getTcpPackets();
    }

    //删除报文
    @RequestMapping(value = "/delPacket", method = {RequestMethod.GET})
    @ResponseBody
    public void delPacket(@RequestParam("id") String id) {
        receiveTcpService.delPacket(id);
    }
}
