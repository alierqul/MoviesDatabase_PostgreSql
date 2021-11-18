package com.bilgeadam.aliergul.server;

import java.util.Date;

public class PortInfo {
	private static final int DEFAULT_PORT = 7777;
	private static final String DEFAULT_IP_ADRESS = "localhost";
	private long id;
	private int portNumber;
	private String ipAdress;
	private Date logsDate;
	
	public PortInfo() {
		this.portNumber = DEFAULT_PORT;
		this.ipAdress = DEFAULT_IP_ADRESS;
		this.logsDate = new Date(System.currentTimeMillis());
	}
	
	public PortInfo(int port, String idAdress) {
		this.portNumber = port;
		this.ipAdress = idAdress;
		this.logsDate = new Date(System.currentTimeMillis());
	}
	
	public PortInfo(long id, int port, String idAdress, Date logsDate) {
		this.id = id;
		this.portNumber = port;
		this.ipAdress = idAdress;
		this.logsDate = logsDate;
	}
	
	@Override
	public String toString() {
		return "ClientServerTuto [id=" + id + ", port=" + portNumber + ", idAdress=" + ipAdress + ", logsDate="
				+ logsDate + "]";
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getPort() {
		return portNumber;
	}
	
	public void setPort(int port) {
		this.portNumber = port;
	}
	
	public String getIdAdress() {
		return ipAdress;
	}
	
	public void setIdAdress(String idAdress) {
		this.ipAdress = idAdress;
	}
	
	public Date getLogsDate() {
		return logsDate;
	}
	
	public void setLogsDate(Date logsDate) {
		this.logsDate = logsDate;
	}
	
}
