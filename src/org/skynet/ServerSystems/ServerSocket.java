package org.skynet.ServerSystems;


import java.io.*;
import java.net.*;
import org.skynet.sources.*;



public class ServerSocket implements Serializable {
	
	
	public static void main(String[] args){
		try{
			java.net.ServerSocket listener =  new java.net.ServerSocket(9966);
			
			while(true){
				Socket socket =  listener.accept();
				try{
					ObjectInputStream input =  new ObjectInputStream(socket.getInputStream());
					
					try {
						System.out.println("comming to try");
						FilePacket fileData = (FilePacket)input.readObject();
						System.out.println("Received File Data");
						System.out.println(fileData.getFileName());
						new ReceiveTheFile(fileData,"/Users/ethender/Developer/java/JobsFileTransfer/files","/");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						socket.close();
					}
				}finally{
					socket.close();
				}
			}
		}catch(IOException ex){
			System.err.println(ex.getMessage());
		}
	}
	
}