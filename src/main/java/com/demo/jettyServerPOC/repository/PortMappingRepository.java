package com.demo.jettyServerPOC.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.jettyServerPOC.model.PortMapping;

public interface PortMappingRepository extends MongoRepository<PortMapping, String> {
	
	PortMapping findByAssetId(long assetId);
}
