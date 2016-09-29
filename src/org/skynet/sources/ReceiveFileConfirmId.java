package org.skynet.sources;

import java.io.Serializable;

public class ReceiveFileConfirmId  implements Serializable{
	
	
	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 100;

	/**
	 * Gets the File Id
	 * @return
	 */
	public String gettFileId() {
		return tFileId;
	}

	/**
	 * Sets the file Id
	 * @param tFileId
	 */
	public void settFileId(String tFileId) {
		this.tFileId = tFileId;
	}

	
	/**
	 * gets the file location
	 * @return
	 */
	public String getFileLocation() {
		return fileLocation;
	}

	
	
	/**
	 * sets the file location
	 * @param fileLocation
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	
	
	/**
	 * gets sender Ip address
	 * @return
	 */
	public String getSenderIpAddress() {
		return senderIpAddress;
	}

	
	/**
	 * sets the iPAddress
	 * @param senderIpAddress
	 */
	public void setSenderIpAddress(String senderIpAddress) {
		this.senderIpAddress = senderIpAddress;
	}

	/**
	 * private instances
	 */
	private String tFileId, fileLocation, senderIpAddress;
	
}