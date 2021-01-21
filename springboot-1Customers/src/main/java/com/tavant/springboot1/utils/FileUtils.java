package com.tavant.springboot1.utils;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

//@Component
public class FileUtils {

	public Properties getProperties() {
		Properties properties = new Properties();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {

			if (inputStream == null) {
				System.out.println("File is not Available");
			} else {
				properties.load(inputStream);
				return properties;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return properties;
	}
}
