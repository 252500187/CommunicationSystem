package com.core.service;

import com.core.entity.TcpPacket;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午6:25
 * To change this template use File | Settings | File Templates.
 */
public interface ReceiveTcpService {

    public String[] getDeviceList();

    public String startReceiveTcp(int deviceIndex);

    public String stopReceiveTcp();

    public void delPacket(String id);

    public List<TcpPacket> getTcpPackets();
}
