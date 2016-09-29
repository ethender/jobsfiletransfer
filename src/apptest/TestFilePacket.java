package apptest;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class TestFilePacket {

	public static void main(String[] args) {
		
		File f =  new File("/Users/ethender/Developer/java/JobsFileTransfer/files/test.txt");
		
		org.skynet.sources.FilePacket packets =  new org.skynet.sources.FilePacket(f);
		
		System.out.println(packets.getFileSize());
		System.out.println(packets.getFileName());
		System.out.println(packets.getFileType());
		
		
		
		Path path =  Paths.get("/Users/ethender/Developer/java/JobsFileTransfer/files/test.txt");
		try {
			byte[] data =  Files.readAllBytes(path);
			System.out.println(data.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
