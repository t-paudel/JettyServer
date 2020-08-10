package com.demo.jettyServerPOC.jettyUtils;

import java.io.IOException;
import java.net.Socket;

public class GenerateRandom {

	public int randomPort() {
		int port = (int)(Math.random()*10000);
		boolean isAvailable;
		try (Socket ignored = new Socket("localhost", port)) {
	        isAvailable=false;
	    } 
		catch (IOException ignored) {
		        isAvailable=true;
	    }
		
		if(isAvailable)
			return port;
		
		randomPort();
		
		return 0;
	}
	
	public String generateService() {
		final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder sb = new StringBuilder();
		int index=0;
		
		for(int i=0;i<10;i++) {
			index = (int) Math.random()*master.length();
			sb.append(master.charAt(index));
		}
		
		return sb.toString();
	}
	
	public String generateUri() {
		final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		int index=0;
		
		for(int i=0;i<2;i++) {
			index = (int) Math.random()*master.length();
			sb.append(master.charAt(index));
		}
		
		return sb.toString();
	}
	
	public long generateAssetId() {
		return (long)Math.random()*1000000000;
	}
}
