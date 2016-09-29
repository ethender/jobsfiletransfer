package org.skynet.ServerSystems;


import java.io.*;
import org.skynet.sources.*;
import java.util.*;


public class ReceiveTheFile implements FilesLifeCycle{
	
	
	public ReceiveTheFile(FilePacket packet, String folderPath,String appender){
		destroyCount = -1;
		dataPacket =  packet;
		folderLocation =  folderPath;
		append = appender;
		onIntialise();
	}

	@Override
	public void onIntialise() {
		try{
			file =  checkExist(folderLocation+append+dataPacket.getFileName());
			onRun();
		}catch(Exception ex){
			System.err.println("Class: "+this.getClass().getName()+"\t function: onInitialise \t"+ex.getMessage());
			destroyCount++;
			onSuspend();
		}
		
	}

	@Override
	public void onRun() {
		try{
			FileOutputStream fout =  new FileOutputStream(file);
			byte[] data =  dataPacket.getFileBytes();
			
			fout.write(data, 0, data.length);
			
		}catch(Exception ex){
			System.err.println("Class: "+this.getClass().getName()+"\t function onRun \t"+ex.getMessage());
			onSuspend();
		}
		
	}

	@Override
	public void onSuspend() {
		if(destroyCount < 5){
			try{
				Thread.sleep(30*1000);
				onIntialise();
			}catch(InterruptedException ex){
				System.err.println("Class: "+this.getClass().getName()+"\t function: onSuspend \t"+ex.getMessage());
				onDestroy();
			}
		}else{
			System.out.println("Data couldn`t process. Please try agin");
			onDestroy();
		}
		
	}

	@Override
	public void onDestroy() {
		System.out.println("Class: "+this.getClass().getName()+"\t function onDestroy");
		System.out.println("File unable to process. try again");
	}
	
	private File checkExist(String path){
		try{
			File f  = new File(path);
			if(f.exists()){
				f.delete();
			}
			
			f.createNewFile();
			return f;
		}catch(Exception ex){
			System.err.println(ex.getMessage());
			return null;
		}
	}
	
	
	
	/**
	 * private instances
	 */
	private FilePacket dataPacket;
	private String folderLocation;
	private File file;
	private int destroyCount;
	private String append;
}
