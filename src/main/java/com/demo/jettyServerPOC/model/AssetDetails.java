package com.demo.jettyServerPOC.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="AssetDetails")
public class AssetDetails {

	@Id
	private String _id;
	
	private long assetId;
	private String assetName;
	private String inboundUri;
	
	public long getAsssetId() {
		return assetId;
	}
	public void setAsssetId(long asssetId) {
		this.assetId = asssetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getInboundUri() {
		return inboundUri;
	}
	public void setInboundUri(String inboundUri) {
		this.inboundUri = inboundUri;
	}	
}
