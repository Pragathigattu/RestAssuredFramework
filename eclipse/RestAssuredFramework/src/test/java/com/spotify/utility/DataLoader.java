package com.spotify.utility;

import java.util.Properties;

public class DataLoader {

	private final Properties properties;
	private static DataLoader dataLoader;
	
	private DataLoader() {
	
		properties = PropertyUtility.propertyLoader("src/main/resources/data.Properties");
	
}
	
	public static DataLoader getInstance() {
	if (dataLoader ==null) {
	
		dataLoader = new DataLoader();
	    }	
		return dataLoader;
		
	}
	
	public String getGetPlaylist_id() {
		 String prop = properties.getProperty("GetPlaylist_id");
		 		
		if (prop!=null) return prop;
		else throw new  RuntimeException("property GetPlaylist_id is not specified in data.properties file");

		}
	
	
	public String getUpdatePlaylist_id() {
		 String prop = properties.getProperty("Updateplaylist_id");
		 		
		if (prop!=null) return prop;
		else throw new  RuntimeException("property Updateplaylist_id is not specified in data.properties file");

		}
}

