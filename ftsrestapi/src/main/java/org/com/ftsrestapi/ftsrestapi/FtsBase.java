package org.com.ftsrestapi.ftsrestapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FtsBase{
	
	public  int RESPONSE_STATUS_CODE_200=200;
	public  int RESPONSE_STATUS_CODE_500=500;
	public  int RESPONSE_STATUS_CODE_400=400;
	public  int RESPONSE_STATUS_CODE_401=401;
	public  int RESPONSE_STATUS_CODE_201=201;
	
	
	public Properties prop;
	// to read properties file 
	public FtsBase() {
		try {
			prop=new  Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/com/ftsrestapi/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	
}