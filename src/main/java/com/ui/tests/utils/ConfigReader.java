package com.ui.tests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	//To read the property file
		public  Properties readProperty()  {
			
			Properties prop = new Properties();
			File propFile = new File(System.getProperty("user.dir") + "//src//test//resources//Config//config.properties");	
			try {
				FileInputStream filePath = new FileInputStream(propFile);
				//FileReader filePath = new FileReader(propFile);
				
				prop.load(filePath);
				//prop.getProperty(propertyName.trim());
				
				
			} 		
			 catch (IOException e) {
				e.printStackTrace();
				//throw(new RuntimeException("*****Error***** - Property with name "+ propertyName + "does not exist" ));
			}
			return prop;
		}
	
	

}
