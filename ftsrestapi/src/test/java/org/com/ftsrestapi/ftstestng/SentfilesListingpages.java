package org.com.ftsrestapi.ftstestng;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.com.ftsrestapi.Utils.FtsUtils;
import org.com.ftsrestapi.data.PageDetails;
import org.com.ftsrestapi.data.SenTfileListingUsersdata;
import org.com.ftsrestapi.ftsclient.FtsClient;
import org.com.ftsrestapi.ftsrestapi.FtsBase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SentfilesListingpages extends FtsBase{
	String serviceURL;
	String sentfileListUrl;
	FtsClient  restClient;      
	String url;
	FtsClient ftsclient;
	CloseableHttpResponse closeablehttprequest;
	FtsBase ftsBase ;
	
	    
	
	@BeforeMethod
	public void SetUp() throws ClientProtocolException, IOException 
	{
		ftsBase= new FtsBase();
		serviceURL=prop.getProperty("URL");
		sentfileListUrl=prop.getProperty("SentFileListingpageURL");
		url=serviceURL +sentfileListUrl ;
		//sessionCookie = getSessionIdFromLogin();
	}
  /* public String getSessionIdFromLogin() throws ClientProtocolException, IOException {
		
		
		FtsClient restClient = new FtsClient();
		String loginUrL ="https://tradinggrid.otxlab.net/tgoportal/#/login";
		
		JSONObject loginPayload = new JSONObject();
        loginPayload.put("username", "iqacibc_user@gxs.com");  // Replace with actual username
        loginPayload.put("password", "Qwerty@1"); 
        
        HashMap<String, String> loginHeaders = new HashMap<>();
        loginHeaders.put("Content-Type", "application/json");
        
        CloseableHttpResponse loginResponse = restClient.post(loginUrL, loginPayload.toString(), loginHeaders);
        Header[] cookies = loginResponse.getHeaders("Set-Cookie");
        for (Header cookie : cookies) {
            if (cookie.getValue().contains("JSESSIONID")) {
                String jsessionId = cookie.getValue().split(";")[0];  // Extracts 'JSESSIONID=xxxxx'
                return jsessionId;
            }
        }
        
		return null;
		
	}*/
	
	@Test
	 public void postAPiSentFile() throws IOException
	 {
		restClient= new FtsClient();
		// prepare headers 
		HashMap<String,String> headermap=new HashMap<String, String>();
	//	headermap.put("Cookie", "JJSESSIONID=8220643BD570E81C83C33418B715236B");
		//headermap.put("Cache-Control", "no-cache");
		//headermap.put("Postman-Token", "<calculated when request is sent>");
	//	headermap.put("Content-Type", "application/json");
		//headermap.put("Accept", "application/json");
		//headermap.put("Content-Length", "<calculated when request is sent>");
		//headermap.put("Host", "<calculated when request is sent>");
		//headermap.put("im_userid","GCP513GTS8197");
	//	headermap.put("im_buid", "GC94102480QI");
		headermap.put("im_userid", "GCP513GTS8197");
		headermap.put("im_buid", "GC94102480QI");
		headermap.put("Content-Type", "application/json; charset=UTF-8"); 
		//headermap.put("Cookie", "JSESSIONID=D88A2C3EEB0632C75C91AD282E07B319");	
		// generate json
		//Jackson APi covert java to Json 
		
		//ObjectMapper mapper =new ObjectMapper();
		
		/* if (sessionCookie != null) {
	            headermap.put("Cookie", sessionCookie);
	        } else {
	            System.out.println("⚠️ Warning: JSESSIONID is null. Login might have failed.");
	        }*/

		PageDetails pageDetails = new PageDetails(0,10);
       
        
		SenTfileListingUsersdata sendfilelistingusers =new SenTfileListingUsersdata();
		sendfilelistingusers.setPageDetails(pageDetails);
        sendfilelistingusers.setSortBy("createdDate");
        sendfilelistingusers.setDirection("desc");
        sendfilelistingusers.setSenderBuId(null);
        sendfilelistingusers.setRecipientBuId(null);
        sendfilelistingusers.setFileName(null);
        sendfilelistingusers.setFileType(null);
        sendfilelistingusers.setUserName(null);
        sendfilelistingusers.setSenderEdi(null);
        sendfilelistingusers.setRecipientEdi(null);
        
        // Empty lists instead of JSONArray
        sendfilelistingusers.setAprf(new ArrayList<Object>());
        sendfilelistingusers.setSnrf(new ArrayList<String>());  
        sendfilelistingusers.setStatus(new ArrayList<String>());  

        sendfilelistingusers.setDelete(null);
        sendfilelistingusers.setIsConfidential(null);
        sendfilelistingusers.setIsLive(null);

        // Empty map instead of JSONObject
        sendfilelistingusers.setAttributes(new HashMap<Object, Object>());
        
        ObjectMapper mapper =new ObjectMapper();
        
        
        //object to json file
        mapper.writeValue(new File("C:/Selenium-NeoAutomation/ftsrestapi/src/main/java/org/com/ftsrestapi/data/SentfileslistingUsersdata.json"), sendfilelistingusers);
		// object to String file
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sendfilelistingusers);
        
        System.out.println("Generated JSON: \n" + jsonString);
        
        System.out.println("Request Headers: " + headermap);
        
        
        System.out.println("Request URL: " + url);
        
      //  System.out.println("Response Body: " + response.getBody().asString());
        
        closeablehttprequest= restClient.post(url, jsonString, headermap);
       
        
      //  System.out.println(closeablehttprequest);
         
        //1.status Code:
       int statussentfilelistcode=closeablehttprequest.getStatusLine().getStatusCode();
       System.out.println("Response Status Code: " + statussentfilelistcode);
        Assert.assertEquals(statussentfilelistcode, RESPONSE_STATUS_CODE_200); 
        
        //2.Check Json String:
        //fetch Json String
       
        String responsesentfilelistingString=EntityUtils.toString(closeablehttprequest.getEntity(),"UTF-8");
        
        //convert to Json string
        JSONObject responseSenfilelistingJson =new JSONObject(responsesentfilelistingString);
        System.out.println("The response from Sent File Listing API is :\n" +responseSenfilelistingJson.toString(4));
        
        
	 }
	
	
}
