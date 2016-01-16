package com.core.dao;

import com.core.entity.TcpPacket;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午7:03
 * To change this template use File | Settings | File Templates.
 */
public interface ReceiveTcpDao {

    public void addTcpPacket(TcpPacket tcpPacket);

    public void delPacket(String id);

    public List<TcpPacket> getTcpPackets();
}
