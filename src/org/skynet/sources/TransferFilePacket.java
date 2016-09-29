package  org.skynet.sources;


import java.io.*;
import java.time.*;
import java.util.*;


public class TransferFilePacket extends FilePacket {

	/**
	 *@author ethender 
	 */
	private static final long serialVersionUID = -9188025508758876655L;

	public TransferFilePacket(File f){
		setFile(f);
		generateUniqueFileId();
	}
	
	/**
	 * Generates unique FileId
	 */
	private void generateUniqueFileId(){
		long epochSecond = Instant.now().getEpochSecond();
		int randomNumber =  (new Random().nextInt());
		tFileId = epochSecond+""+randomNumber;
	}

	/**
	 * Gets file Unique Id
	 * @return
	 */
	public String getTFileId(){
		return tFileId;
	}
	
	
	
	/**
	 * private instance
	 */
	private String tFileId;
}