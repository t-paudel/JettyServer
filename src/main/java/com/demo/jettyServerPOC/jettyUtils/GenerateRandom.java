package com.demo.jettyServerPOC.jettyUtils;

import java.io.IOException;
import java.net.Socket;

public class GenerateRandom {

	public int generatePortNumber() {
		System.out.println("GenerateRandom::generatePortNumber()");
		
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
		
		generatePortNumber();
		
		return 0;
	}
	
	public String generateAssetName() {
		System.out.println("GenerateRandom::generateUri()");
		
		final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder sb = new StringBuilder();
		int index=0;
		
		for(int i=0;i<10;i++) {
			index = (int) (Math.random()*master.length());
			sb.append(master.charAt(index));
		}
		
		return sb.toString();
	}
	
	public String generateUri() {
		System.out.println("GenerateRandom::generateUri()");
		
		final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		int index=0;
		
		for(int i=0;i<=4;i++) {
			index = (int) (Math.random()*master.length());
			sb.append(master.charAt(index));
		}
		
		return sb.toString();
	}
	
	public long generateAssetId() {
		System.out.println("GenerateRandom::generateAssetId()");
		long id = (long) (Math.random()*1000000000);
		return id;
	}
}
