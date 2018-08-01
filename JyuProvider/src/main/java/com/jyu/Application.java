package com.jyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo/dubbo-provider.xml")
@MapperScan("com.jyu.mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	try {
		System.in.read();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
