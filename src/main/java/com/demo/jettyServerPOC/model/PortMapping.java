package com.demo.jettyServerPOC.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="PortMapping")
public class PortMapping {


	@Id
	private String _id;
	
	private long assetId;
	private int portNumber;
	private boolean isAllotted;
	
	
	public boolean isAllotted() {
		return isAllotted;
	}
	public void setAllotted(boolean isAllotted) {
		this.isAllotted = isAllotted;
	}
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}	
	
	@Override
	public String toString() {
		return "PortMapping [_id=" + _id + ", assetId=" + assetId + ", portNumber=" + portNumber + "]";
	}
}
