package com.demo.jettyServerPOC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jettyServerPOC.jettyUtils.Connector;
import com.demo.jettyServerPOC.model.AssetDetails;
import com.demo.jettyServerPOC.model.PortMapping;
import com.demo.jettyServerPOC.repository.AssetDetailsRepository;
import com.demo.jettyServerPOC.repository.PortMappingRepository;

@Service
public class AssetService {

	@Autowired
	PortMappingRepository mappingRepo;
	
	@Autowired
	AssetDetailsRepository assetRepo;
	
	@Autowired
	Connector connector;
	
	public List<PortMapping> getAllMapping() {
		return mappingRepo.findAll();
	}
	
	public List<AssetDetails> getAllAssets() {
		return assetRepo.findAll();
	}
	
	public void loadAssets() {
		System.out.println("AssetService::loadAssets()");
		
		List<AssetDetails> assets = new ArrayList<>();
		
		assets = assetRepo.findAll();
		connector.createConnector(assets);
	}
	
	public int getPortNumber(long assetId) {
		 return mappingRepo.findByAssetId(assetId).getPort();
	}
}
