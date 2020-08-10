package com.demo.jettyServerPOC.jettyUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class Handler extends AbstractHandler{

	final String assetName;
    final int portNumber;
    final String url;
    
    
	public Handler(String assetName, int portNumber, String url) {
		super();
		this.assetName = assetName;
		this.portNumber = portNumber;
		this.url = url;
	}

	
	@Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        out.println("<h3>" + assetName  + " : " + portNumber + "</h3>");
        out.println("<br>route : " + url);
        	
        baseRequest.setHandled(true);
    }
}
