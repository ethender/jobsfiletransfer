package org.skynet.ClientSystems;

import org.skynet.sources.*;
import java.io.*;
import java.net.*;


public class SendTheFile implements FilesLifeCycle {

	public SendTheFile(String filePath,String ServerIp){
		access =  new SkynetNetworkConstants(ServerIp,9966);
		path =  filePath;
		destroyCount = -1;
	}

	@Override
	public void onIntialise() {
		try{
			File file =  new File(path);
			if(file.exists()){
				packet =  new FilePacket(file);
				onRun();
			}else{
				System.out.println("file doesn`t exist");
			}
		}catch(Exception ex){
			System.err.println("Class: "+this.getClass().getName()+"\t  function: onInitialise \t"+ex.getMessage());
			onSuspend();
		}
		
	}

	@Override
	public void onRun() {
		try{
			
			Socket s =  new Socket(access.getIpAddress(),access.getPortNumber());
			
			ObjectOutputStream objOut =  new ObjectOutputStream(s.getOutputStream());
			objOut.writeObject(packet);
			
			s.close();
			System.out.println("File Send from client");
		}catch(Exception ex){
			System.err.println("Class: "+this.getClass().getName()+"\t  function: onRun \t "+ex.getMessage());
			destroyCount++;
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
				System.err.println("class: "+this.getClass().getName()+"\t function: onSuspend \t"+ex.getMessage());
			}
		}else{
			System.err.println("Unable process this request. Please Try again");
			onDestroy();
		}
	}

	@Override
	public void onDestroy() {
		System.out.println("Failed the opertaion.Please try again");
		System.gc();
	}
	
	
	
	/**
	 * private instances
	 */
	private SkynetNetworkConstants access;
	private String path;
	private int destroyCount;
	private FilePacket packet;
}
