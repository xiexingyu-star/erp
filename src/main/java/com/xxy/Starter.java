package com.xxy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.xxy.dao"})
public class Starter  {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);
	
		String[] names = context.getBeanDefinitionNames();
		for(String s:names){
			if(!s.contains("springframework")){
			//	System.out.println(s);
			}
		}

	}
}
