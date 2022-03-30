package com.tech.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DBConfiguration {
	
	private Connection con=null;
	
	@Autowired
    Environment env;
	
	@PostConstruct
	public Connection init() throws ClassNotFoundException, SQLException {
		Class.forName(env.getProperty("db.driver"));
		con=DriverManager.getConnection(env.getProperty("db.url"), env.getProperty("db.username"), env.getProperty("db.password"));
		return con;
	}

	@Bean 
	public Connection getConnection() {
		return con;
	}
	
	@PreDestroy
	public void destroyDbCon() throws SQLException {
		con.close();
	}
}
