package com.ydx.search.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties = null;
	static {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
		properties = new Properties();
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过Key获得value
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return properties.getProperty(key);
	}
	
	/**
	 * 通过key修改value
	 * @param key
	 * @param value
	 */
	public static void setValue(String key,String value){
		//修改systemIds
		String path = Properties.class.getClassLoader().getResource("config.properties").toString().substring(3);
		properties.setProperty(key, value);
		try {
			OutputStream out = new FileOutputStream(path);
			try {
				properties.store(out, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
