package com.core.service.impl;

import com.core.dao.ReceiveTcpDao;
import com.core.entity.TcpPacket;
import com.core.service.ReceiveTcpService;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午6:25
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("ReceiveTcpService")
public class ReceiveTcpServiceImpl implements ReceiveTcpService {

    @Autowired
    private ReceiveTcpDao receiveTcpDao;

    private int deviceIndex;

    private Thread thread;

    private JpcapCaptor captor;

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
    public String startReceiveTcp(int deviceIndex) {
        if (thread != null) {
            return "开始接收";
//            String stopResult = stopReceiveTcp();
//            if (!stopResult.equals("停止接收")) {
//                return stopResult;
//            }
        }
        this.deviceIndex = deviceIndex;
        try {
            captor = JpcapCaptor.openDevice(JpcapCaptor.getDeviceList()[deviceIndex], 65535, true, 1000);
            captor.setFilter("tcp", true);
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    PacketReceiver receiver = new PacketReceiver() {
                        @Override
                        public void receivePacket(Packet packet) {
                            dealTcpPacket((TCPPacket) packet);
                        }
                    };
                    captor.loopPacket(-1, receiver);
                }
            });
            thread.start();
            return "开始接收";
        } catch (IOException e) {
            return e.toString();
        }
    }

    public void dealTcpPacket(TCPPacket tcpPacket) {
        TcpPacket packet = new TcpPacket();
        packet.setDeviceName(JpcapCaptor.getDeviceList()[deviceIndex].name);
        packet.setDeviceDescription(JpcapCaptor.getDeviceList()[deviceIndex].description);
        //源端口
        packet.setSrcPort(tcpPacket.src_port);
        //目的端口
        packet.setDstPort(tcpPacket.dst_port);
        //序号
        packet.setSequence(tcpPacket.sequence);
        //确认序号
        packet.setAckNum(tcpPacket.ack_num);
//        头部长度
//        packet.setHeadLen();
//        保留
//        packet.setKeep();
        //urg
        packet.setUrg(tcpPacket.urg);
        //ack
        packet.setAck(tcpPacket.ack);
        //psh
        packet.setPsh(tcpPacket.psh);
        //rst
        packet.setRst(tcpPacket.rst);
        //syn
        packet.setSyn(tcpPacket.syn);
        //fin
        packet.setFin(tcpPacket.fin);
        //窗口
        packet.setWindow(tcpPacket.window);
//        检验和
//        packet.setPacketAckNum();
        //紧急指针
        packet.setUrgentPointer(tcpPacket.urgent_pointer);
        //选项和填充
        String value = "";
        if (tcpPacket.option != null) {
            for (byte val : tcpPacket.option) {
                value = val + ",";
            }
            if (value.length() > 0) {
                packet.setTcpOption(value.substring(0, value.length() - 1));
            }
        }
        //数据
        value = "";
        if (tcpPacket.data != null) {
            for (byte val : tcpPacket.data) {
                value = val + ",";
            }
            if (value.length() > 0) {
                packet.setData(value.substring(0, value.length() - 1));
            }
        }
        receiveTcpDao.addTcpPacket(packet);
    }

    @Override
    public String stopReceiveTcp() {
        return "停止接收";
//        if (thread == null) {
//            return "停止接收";
//        }
//        try {
//            //change
//            captor.breakLoop();
//            captor.close();
//            thread.interrupt();
//            thread.stop();
//            return "停止接收";
//        } catch (Exception e) {
//            return e.toString();
//        }
    }

    @Override
    public void delPacket(String id) {
        receiveTcpDao.delPacket(id);
    }

    @Override
    public List<TcpPacket> getTcpPackets() {
        return receiveTcpDao.getTcpPackets();
    }
}
