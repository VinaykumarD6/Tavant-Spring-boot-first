package com.tavant.springboot1.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DBUtils {
	/*@Autowired
	private FileUtils fileUtils;*/

	@Autowired
	Environment environment;

	public DataSource getDataSource() {
		//MysqlDataSource dataSource = new MysqlDataSource();
	//	MysqlDataSource dataSource = new MysqlDataSource();
		BasicDataSource dataSource = new BasicDataSource();
		System.out.println("env class name"+environment.getClass().getName());
		//Properties properties = fileUtils.getProperties();

//		String serverName = properties.getProperty("db.servername");
//		String port = properties.getProperty("db.port");
//		String password = properties.getProperty("db.password");
//		String username = properties.getProperty("db.username");
//		String databaseName = properties.getProperty("db.databasename");
		try {
		dataSource.setUrl(environment.getProperty("db.url"));
		//dataSource.setPort(Integer.parseInt(port));
		dataSource.setPassword(environment.getProperty("db.password"));
		dataSource.setUsername(environment.getProperty("db.username"));
		//dataSource.setDatabaseName(environment.getProperty("db.databasename"));
		/*try {
			dataSource.setSslMode("DISABLED");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		return dataSource;
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		return dataSource;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection connection = null;

		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
