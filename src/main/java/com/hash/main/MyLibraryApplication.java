package com.hash.main;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLibraryApplication.class, args);
		System.out.println("MyLibrary");
	}

}
