package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class ThriftApplication {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		InputStream in = DubboApplication.class.getClassLoader().getResourceAsStream("thrift.properties");
		properties.load(in);
		SpringApplication app = new SpringApplication(ThriftApplication.class);
		app.setDefaultProperties(properties);
		app.run(args);
	}

}

