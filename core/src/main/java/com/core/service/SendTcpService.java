package com.core.service;

import com.core.entity.TcpPacket;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-24
 * Time: 下午1:30
 * To change this template use File | Settings | File Templates.
 */
public interface SendTcpService {

    public String[] getDeviceList();

    public String sendTcpPacket(int deviceIndex, TcpPacket tcpPacket);

    public void delPacket(String id);

    public List<TcpPacket> getTcpPackets();
}
