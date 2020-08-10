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
	
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
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
	
	
	@Override
	public String toString() {
		return "AssetDetails [_id=" + _id + ", assetId=" + assetId + ", assetName=" + assetName + ", inboundUri="
				+ inboundUri + "]";
	}
}
