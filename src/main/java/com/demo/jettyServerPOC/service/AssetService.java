package com.demo.jettyServerPOC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jettyServerPOC.jettyUtils.Connector;
import com.demo.jettyServerPOC.jettyUtils.GenerateRandom;
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
		System.out.println("AssetService::getAllMapping()");
		
		return mappingRepo.findAll();
	}
	
	public List<AssetDetails> getAllAssets() {
		System.out.println("AssetService::getAllAssets()");
		
		return assetRepo.findAll();
	}
	
	public void loadAssets() {
		System.out.println("AssetService::loadAssets()");
		
		List<AssetDetails> assets = new ArrayList<>();
		List<PortMapping> ports = new ArrayList<>();
		
		ports = mappingRepo.findByIsAllotted(false).get();
		for(PortMapping port:ports) {	
			assets.add(assetRepo.findByAssetId(port.getAssetId()));
			port.setAllotted(true);
			mappingRepo.save(port);
		}
		
		connector.createConnector(assets);
	}
	
	public int getPortNumber(long assetId) {
		System.out.println("AssetService::getPortNumber()");
		
		 return mappingRepo.findByAssetId(assetId).get().getPortNumber();
	}
	
	public String createAsset(int number) {
		System.out.println("AssetService::createAsset()");
		
		AssetDetails asset = null;
		PortMapping portMapping = null;
		GenerateRandom random = new GenerateRandom();
		long assetId;
		int port;
		
		if(number>5)
			number=5; //capping at 5
		
		for(int i=1;i<=number;i++) {
			asset = new AssetDetails();
			portMapping = new PortMapping();
			
			//check if assetId already exists.
			while(true) {
				assetId = random.generateAssetId();
				System.out.println("assetId = " + assetId );
				if(mappingRepo.findByAssetId(assetId).isEmpty())
					break;
			}
			
			//check if port already exists.
			while(true) {
				port = random.generatePortNumber();
				if(mappingRepo.findByPortNumber(port).isEmpty())
					break;
			}
			
			asset.setAssetId(assetId);
			asset.setAssetName(random.generateAssetName());
			asset.setInboundUri(random.generateUri());
			
			portMapping.setPortNumber(port);
			portMapping.setAssetId(asset.getAssetId());
			portMapping.setAllotted(false);
			mappingRepo.save(portMapping);
			assetRepo.save(asset);
		}
		
		return "Created " + number + " services!!";
	}
}
