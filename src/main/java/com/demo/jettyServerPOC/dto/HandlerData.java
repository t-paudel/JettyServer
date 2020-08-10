package com.demo.jettyServerPOC.dto;

public class HandlerData {

	private String assetName;
	private int port;
	private String url;
	private String connectorName;
	
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getConnectorName() {
		return connectorName;
	}
	public void setConnectorName(String connectorName) {
		this.connectorName = connectorName;
	}
	
	@Override
	public String toString() {
		return "HandlerData [assetName=" + assetName + ", port=" + port + ", url=" + url + ", connectorName="
				+ connectorName + "]";
	}
	
}
