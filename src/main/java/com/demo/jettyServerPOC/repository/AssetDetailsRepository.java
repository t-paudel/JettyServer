package com.demo.jettyServerPOC.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.jettyServerPOC.model.AssetDetails;

public interface AssetDetailsRepository extends MongoRepository<AssetDetails, String> {

}
