package com.core.dao.impl;

import com.core.dao.ReceiveTcpDao;
import com.core.entity.TcpPacket;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
@Repository("ReceiveTcpDao")
public class ReceiveTcpDaoImpl extends BaseDao implements ReceiveTcpDao {

    @Override
    public void addTcpPacket(TcpPacket tcpPacket) {
        String sql = "INSERT INTO tcp_packet(src_port,dst_port,sequence,ack_num,head_len,keep,urg,ack,psh,rst,syn,fin,window,check_sum,urgent_pointer,tcp_option,data,receive_time,device_name,device_description)" +
                " VALUES(" + tcpPacket.getSrcPort() + "," + tcpPacket.getDstPort() + "," + tcpPacket.getSequence() + "," + tcpPacket.getAckNum() + "," + tcpPacket.getHeadLen() + "," + tcpPacket.getKeep() + ","
                + tcpPacket.getUrg() + "," + tcpPacket.getAck() + "," + tcpPacket.getPsh() + "," + tcpPacket.getRst() + "," + tcpPacket.getSyn() + "," + tcpPacket.getFin() + ","
                + tcpPacket.getWindow() + "," + tcpPacket.getCheckSum() + "," + tcpPacket.getUrgentPointer() + ",'" + tcpPacket.getTcpOption() + "','" + tcpPacket.getData() + "','"
                + tcpPacket.getReceiveTime() + "','" + tcpPacket.getDeviceName() + "','" + tcpPacket.getDeviceDescription() + " ')";
        getJdbcTemplate().update(sql);
    }

    @Override
    public void delPacket(String id) {
        String sql = "DELETE FROM tcp_packet WHERE id=" + id;
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<TcpPacket> getTcpPackets() {
        String sql = "SELECT * FROM tcp_packet ORDER BY id DESC";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TcpPacket>(TcpPacket.class));
    }
}
