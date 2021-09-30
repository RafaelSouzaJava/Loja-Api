package com.example.rafael.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.rafael.api.services.S3Service;

@SpringBootApplication
public class LojaApiApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(LojaApiApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {		
		
		s3Service.uploadFile("C:\\workspace-udemy\\imgs\\cp1.jpg");
	}

}
