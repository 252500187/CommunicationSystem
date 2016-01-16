package com.core.dao;

import com.core.entity.TcpPacket;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-25
 * Time: 下午11:23
 * To change this template use File | Settings | File Templates.
 */
public interface SendTcpDao {

    public void addTcpPacket(TcpPacket tcpPacket);

    public void delPacket(String id);

    public List<TcpPacket> getTcpPackets();
}
