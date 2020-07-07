package com.xxy.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class BeanConfig {

/*
	@Bean(name="dataSource")
	public DruidDataSource getDataSource() {
		DruidDataSource ds = new DruidDataSource();

		try {
			 ds.setUsername("root");
			ds.setPassword("root");    //用户名 密码
			
			//1.x写法
			ds.setUrl("jdbc:mysql://127.0.0.1:3306/erp");  //数据库
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			
			//2.x写法
			//ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti?serverTimezone=GMT%2B8");  //数据库
			//ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {

		}
		return ds;
	}
*/

	
	
}
