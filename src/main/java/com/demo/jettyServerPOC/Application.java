package com.demo.jettyServerPOC;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("main()");
		
	}
	
	@PostConstruct
	public void init() throws Exception {
		System.out.println("init()");
		
//		Server server = new Server();
//		
//		server.start();
	}

}
