package org.skynet.sources;


import  java.io.*;
import java.nio.file.*;


public class FilePacket  implements Serializable{
	
	/**
	 * test
	 */
	private static final long serialVersionUID = 100;
	/**
	 * constructor 
	 * @param file
	 */
	public FilePacket(File file){
		tfile =  file;
		
		getExtractWithFiles();
		getDetailsOfFiles();
	}
	
	
	
	/**
	 * constructor
	 */
	public FilePacket(){
		
	}
	
	
	/**
	 * sets the file
	 * @param file
	 */
	public void setFile(File file){
		tfile =  file;
		getExtractWithFiles();
		getDetailsOfFiles();
	}
	
	
	
	
	/**
	 * extarcts bytes from the files
	 */
	private void getExtractWithFiles(){
		try{
			
			FileInputStream fStream =  new FileInputStream(tfile);
			fileBytes =  new byte[(int)tfile.length()];
			
			fStream.read(fileBytes, 0, fileBytes.length);
			fileSize =  fileBytes.length;
		}catch(Exception ex){
			System.err.println("File Packet "+ex.getMessage());
		}
	}
	
	/**
	 * gets the details of files
	 */
	private  void getDetailsOfFiles(){
		String path =  tfile.getAbsolutePath();
		
		type = path.substring(path.lastIndexOf('.')+1);
		
		if(path.contains("/")){
			fileName =  path.substring(path.lastIndexOf("/")+1);
		}else if(path.contains("\\")){
			fileName = path.substring(path.lastIndexOf("\\")+1);
		}
	}
	
	
	
	/**
	 * Gets the bytes  of bytes
	 * @return
	 */
	public byte[] getFileBytes(){
		return fileBytes;
	}
	
	
	/**
	 * gets the file  size
	 * @return
	 */
	public int getFileSize(){
		return fileSize;
	}
	
	
	/**
	 * gets the file type
	 * @return
	 */
	public String getFileType(){
		return type;
	}
	
	
	/**
	 * gets the file  name
	 * @return
	 */
	public String getFileName(){
		return fileName;
	}
	
	
	
	
	/**
	 * private instances
	 */
	private File tfile;
	private int fileSize;
	private String type;
	private String fileName;
	byte[] fileBytes;
}
