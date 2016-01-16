package com.core.dao.impl;

import com.core.dao.SendTcpDao;
import com.core.entity.TcpPacket;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-25
 * Time: 下午11:23
 * To change this template use File | Settings | File Templates.
 */
@Repository("SendTcpDao")
public class SendTcpDaoImpl extends BaseDao implements SendTcpDao {

    @Override
    public void addTcpPacket(TcpPacket tcpPacket) {
        String sql = "INSERT INTO send_tcp_packet(src_port,dst_port,sequence,ack_num,head_len,keep,urg,ack,psh,rst,syn,fin,window,check_sum,urgent_pointer,tcp_option,data,send_time,device_name,device_description,send_ip_address,receive_ip_address)" +
                " VALUES(" + tcpPacket.getSrcPort() + "," + tcpPacket.getDstPort() + "," + tcpPacket.getSequence() + "," + tcpPacket.getAckNum() + "," + tcpPacket.getHeadLen() + "," + tcpPacket.getKeep() + ","
                + tcpPacket.getUrg() + "," + tcpPacket.getAck() + "," + tcpPacket.getPsh() + "," + tcpPacket.getRst() + "," + tcpPacket.getSyn() + "," + tcpPacket.getFin() + ","
                + tcpPacket.getWindow() + "," + tcpPacket.getCheckSum() + "," + tcpPacket.getUrgentPointer() + ",'" + tcpPacket.getTcpOption() + "','" + tcpPacket.getData() + "','"
                + tcpPacket.getSendTime() + "','" + tcpPacket.getDeviceName() + "','" + tcpPacket.getDeviceDescription() + "','" + tcpPacket.getSendIpAddress() + "','" + tcpPacket.getReceiveIpAddress() + "')";
        getJdbcTemplate().update(sql);
    }

    @Override
    public void delPacket(String id) {
        String sql = "DELETE FROM send_tcp_packet WHERE id=" + id;
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<TcpPacket> getTcpPackets() {
        String sql = "SELECT * FROM send_tcp_packet ORDER BY id DESC";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TcpPacket>(TcpPacket.class));
    }
}
