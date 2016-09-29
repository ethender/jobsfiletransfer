package org.skynet.sources;

public class SkynetNetworkConstants {
	
	/**
	 * constructor
	 */
	public SkynetNetworkConstants(){
		
	}
	
	
	/**
	 * constructor
	 * @param serverIp
	 * @param serverPort
	 */
	public SkynetNetworkConstants(String serverIp, int serverPort){
		ipAddress =  serverIp;
		portNumber =  serverPort;
	}
	
	
	/**
	 * gets the ipAddress
	 * @return
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	
	/**
	 *  sets the IPAddress
	 * @param ipAddress
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	/**
	 * gets the port number
	 * @return
	 */
	public int getPortNumber() {
		return portNumber;
	}
	
	/**
	 * sets the port number
	 * @param portNumber
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	/**
	 * private instances
	 */
	private String ipAddress;
	private int portNumber;
}
