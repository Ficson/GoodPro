package com.jyu;
/**
 * 创建spring boot 主启动类 spring boot 会扫描根目录低下的包
 */

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ImportResource("classpath:dubbo/dubbo-consumer.xml")
@PropertySources(value = {@PropertySource("classpath:redis.properties")})
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
	}
}

