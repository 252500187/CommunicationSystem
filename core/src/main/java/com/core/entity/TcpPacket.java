package com.core.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: bo
 * Date: 15-1-22
 * Time: 下午6:43
 * To change this template use File | Settings | File Templates.
 */
public class TcpPacket {
    //ID
    private int id;
    //设备名称
    private String deviceName;
    //设备描述
    private String deviceDescription;

    //源端口
    private int srcPort;
    //目的端口
    private int dstPort;
    //序号
    private long sequence;
    //确认序号
    private long ackNum;
    //头部长度
    private int headLen;
    //保留
    private int keep;
    //urg
    private boolean urg;
    //ack
    private boolean ack;
    //psh
    private boolean psh;
    //rst
    private boolean rst;
    //syn
    private boolean syn;
    //fin
    private boolean fin;
    //窗口
    private int window;
    //检验和
    private int checkSum;
    //紧急指针
    private short urgentPointer;
    //选项和填充
    private String tcpOption;
    //数据
    private String data;

    //接收时间
    private String receiveTime;

    //发送时间
    private String sendTime;
    //IP部分发送地址
    private String sendIpAddress;
    //IP部分接收地址
    private String receiveIpAddress;

    public TcpPacket() {
        tcpOption = "";
        data = "";
        receiveTime = new Timestamp(new Date().getTime()).toString().substring(0,19);
        sendTime = receiveTime;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(int srcPort) {
        this.srcPort = srcPort;
    }

    public int getDstPort() {
        return dstPort;
    }

    public void setDstPort(int dstPort) {
        this.dstPort = dstPort;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public long getAckNum() {
        return ackNum;
    }

    public void setAckNum(long ackNum) {
        this.ackNum = ackNum;
    }

    public int getHeadLen() {
        return headLen;
    }

    public void setHeadLen(int headLen) {
        this.headLen = headLen;
    }

    public int getKeep() {
        return keep;
    }

    public void setKeep(int keep) {
        this.keep = keep;
    }

    public boolean getUrg() {
        return urg;
    }

    public void setUrg(boolean urg) {
        this.urg = urg;
    }

    public boolean getAck() {
        return ack;
    }

    public void setAck(boolean ack) {
        this.ack = ack;
    }

    public boolean getPsh() {
        return psh;
    }

    public void setPsh(boolean psh) {
        this.psh = psh;
    }

    public boolean getRst() {
        return rst;
    }

    public void setRst(boolean rst) {
        this.rst = rst;
    }

    public boolean getSyn() {
        return syn;
    }

    public void setSyn(boolean syn) {
        this.syn = syn;
    }

    public boolean getFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }

    public short getUrgentPointer() {
        return urgentPointer;
    }

    public void setUrgentPointer(short urgentPointer) {
        this.urgentPointer = urgentPointer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTcpOption() {
        return tcpOption;
    }

    public void setTcpOption(String tcpOption) {
        this.tcpOption = tcpOption;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendIpAddress() {
        return sendIpAddress;
    }

    public void setSendIpAddress(String sendIpAddress) {
        this.sendIpAddress = sendIpAddress;
    }

    public String getReceiveIpAddress() {
        return receiveIpAddress;
    }

    public void setReceiveIpAddress(String receiveIpAddress) {
        this.receiveIpAddress = receiveIpAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
