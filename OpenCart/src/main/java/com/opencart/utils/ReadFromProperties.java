package com.opencart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
	
	public static String getData(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\config.properties");
		prop.load(fip);
		String data = prop.getProperty(key);
		return data;
	}

}
