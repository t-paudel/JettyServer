package com.demo.jettyServerPOC.jettyUtils;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.jettyServerPOC.dto.HandlerData;
import com.demo.jettyServerPOC.model.AssetDetails;
import com.demo.jettyServerPOC.service.AssetService;

@Component
public class Connector {

	@Autowired
	AssetService assetService;
	
	public void createConnector(List<AssetDetails> assets) {
		System.out.println("Connector::createConnector()");
		
		int port;
		ServerConnector connector;
		HandlerData handlerData;
		HandlerList handlerList = new HandlerList();
		ContextHandler context;
		
		Server server = new Server();
		
		for(AssetDetails asset:assets) {
			port = assetService.getPortNumber(asset.getAsssetId());
			connector = new ServerConnector(server);
			handlerData= new HandlerData();
			context = new ContextHandler();
			
			handlerData.setAssetName(asset.getAssetName());
			handlerData.setPort(port);
			handlerData.setUrl(asset.getInboundUri());
			handlerData.setConnectorName(asset.getAssetName());
			
			System.out.println(handlerData.toString());
			connector.setPort(port);
			connector.setHost("localhost");
			connector.setName(asset.getAssetName());
			server.addConnector(connector);
			
			context = createHandler(handlerData);
			handlerList.addHandler(context);
		}
		
		server.setHandler(handlerList);
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ContextHandler createHandler(HandlerData data) {
		System.out.println("Connector::createHandler()");
		
		ContextHandler context = new ContextHandler();
		
		context.setContextPath(data.getUrl());
		context.setHandler(new Handler(data.getAssetName(), data.getPort(), data.getUrl()));
		context.setVirtualHosts(new String[] {"@" + data.getConnectorName()});
		
		return context;
		
	}
}
