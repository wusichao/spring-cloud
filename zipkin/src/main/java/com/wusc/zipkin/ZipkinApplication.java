package com.wusc.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
	public static void main(String[] args)
	{
		System.out.println("hello");
		SpringApplication.run(ZipkinApplication.class, args);
	}
}
