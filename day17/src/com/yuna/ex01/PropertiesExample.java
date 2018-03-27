package com.yuna.ex01;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) throws Exception{
		Properties properties = new Properties();
		String path = PropertiesExample.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8");
		properties.load(new FileReader(path));
		
/*		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println("driver : "+driver);
		System.out.println("url : "+url);
		System.out.println("username : "+username);
		System.out.println("password : "+password);*/
		
		Enumeration e = properties.propertyNames();
		
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "="+properties.getProperty(element));
		}
	}
}
 
