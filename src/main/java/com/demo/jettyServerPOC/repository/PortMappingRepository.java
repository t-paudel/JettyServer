package com.demo.jettyServerPOC.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.jettyServerPOC.model.PortMapping;

public interface PortMappingRepository extends MongoRepository<PortMapping, String> {
	
	Optional<PortMapping> findByAssetId(long assetId);
	Optional<PortMapping> findByPortNumber(int portNumber);
	Optional<List<PortMapping>> findByIsAllotted(boolean isAllotted);
}
