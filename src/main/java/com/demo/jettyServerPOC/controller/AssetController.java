package com.demo.jettyServerPOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jettyServerPOC.model.AssetDetails;
import com.demo.jettyServerPOC.model.PortMapping;
import com.demo.jettyServerPOC.repository.PortMappingRepository;
import com.demo.jettyServerPOC.service.AssetService;

@RestController
public class AssetController {

	@Autowired
	AssetService assetService;
	
	@Autowired
	PortMappingRepository repo;
	
	@GetMapping("/getAllMappings")
	public List<PortMapping> getAllMapping() {
		System.out.println("AssetController::getAllMapping()");
		
		return assetService.getAllMapping();
	}
	
	@GetMapping("/getAllAssets")
	public List<AssetDetails> getAllService(){
		System.out.println("AssetController::getAllService()");
		
		return assetService.getAllAssets();
	}
	
	@PostMapping("/loadAssets")
	public String loadAssets() {
		System.out.println("AssetController::loadAssets()");
		
		assetService.loadAssets();
		return "loaded";
	}
	
	@GetMapping("/isAvailable/{assetId}")
	public boolean isAvailable(@PathVariable("assetId") long assetId) {
		System.out.println("AssetController::isAvailable()");
		
		return repo.findByAssetId(assetId).isEmpty();
	}
	
	@PostMapping("/createAssets/{number}")
	public String createAssets(@PathVariable("number") int number) {
		System.out.println("AssetController::createAssets()");
		
		return assetService.createAsset(number);
	}
}
