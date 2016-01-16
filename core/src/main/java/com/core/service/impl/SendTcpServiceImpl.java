package com.core.service.impl;

import com.core.dao.SendTcpDao;
import com.core.entity.TcpPacket;
import com.core.service.SendTcpService;
import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.TCPPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-24
 * Time: 下午1:31
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("SendTcpService")
public class SendTcpServiceImpl implements SendTcpService {

    @Autowired
    private SendTcpDao sendTcpDao;

    @Override
    public String[] getDeviceList() {
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        String[] deviceList = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            deviceList[i] = devices[i].name + ":" + devices[i].description;
        }
        return deviceList;
    }

    @Override
    public String sendTcpPacket(int deviceIndex, TcpPacket tcpPacket) {
        if (deviceIndex < 0) {
            return "设备代号不存在";
        }
        try {
            JpcapSender jpcapSender = JpcapSender.openDevice(JpcapCaptor.getDeviceList()[deviceIndex]);
            //tcp包
            TCPPacket p = new TCPPacket(tcpPacket.getSrcPort(), tcpPacket.getDstPort(), tcpPacket.getSequence(), tcpPacket.getAckNum(),
                    tcpPacket.getUrg(), tcpPacket.getAck(), tcpPacket.getPsh(), tcpPacket.getRst(), tcpPacket.getSyn(), tcpPacket.getFin(),
                    true, true, tcpPacket.getWindow(), tcpPacket.getUrgentPointer());
            //ip部分，地址
            p.setIPv4Parameter(0, false, false, false, 0, false, false, false, 0, 0, 255, 6, InetAddress.getByName(tcpPacket.getSendIpAddress()), InetAddress.getByName(tcpPacket.getReceiveIpAddress()));
            p.data = tcpPacket.getData().getBytes();
            jpcapSender.sendPacket(p);
            jpcapSender.close();
            tcpPacket.setDeviceName(JpcapCaptor.getDeviceList()[deviceIndex].name);
            tcpPacket.setDeviceDescription(JpcapCaptor.getDeviceList()[deviceIndex].description);
            sendTcpDao.addTcpPacket(tcpPacket);
            return "发送成功";
        } catch (IOException e) {
            return e.toString();
        }
    }

    @Override
    public void delPacket(String id) {
        sendTcpDao.delPacket(id);
    }

    @Override
    public List<TcpPacket> getTcpPackets() {
        return sendTcpDao.getTcpPackets();
    }
}
