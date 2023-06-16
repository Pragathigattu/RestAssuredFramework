package com.spotify.utility;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;
public class PropertyUtility {
	
	
	
	
public static Properties propertyLoader(String filePath) {

   Properties properties= new Properties();

   BufferedReader reader;
 
   try {//whenever involving in file handiling use try, catch

          reader =new BufferedReader(new FileReader(filePath));
           try {
	             properties.load(reader);
	             reader.close();
                }
          catch(IOException e){
        	  e.printStackTrace();
              throw new RuntimeException("fail to load properties file"+(filePath));
                 }
	
         }	
	
	catch(FileNotFoundException e) {
		  e.printStackTrace();
	throw new RuntimeException("properties file not found at"+(filePath));
	
	}
	
return properties;
}



}