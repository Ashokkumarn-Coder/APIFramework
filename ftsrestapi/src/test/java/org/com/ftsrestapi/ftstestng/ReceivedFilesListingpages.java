package org.com.ftsrestapi.ftstestng;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.com.ftsrestapi.data.PageDetails;
import org.com.ftsrestapi.data.SenTfileListingUsersdata;
import org.com.ftsrestapi.ftsclient.FtsClient;
import org.com.ftsrestapi.ftsrestapi.FtsBase;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReceivedFilesListingpages extends FtsBase {
	
	FtsBase ftsbase;
	String serviceURL;
	String ReceivedfileListUrl;
	String url;
	FtsClient restClient;
	CloseableHttpResponse closeablehttprequest;
	
	@BeforeMethod
	public void setup() {
		
		ftsbase= new FtsBase();
		serviceURL = prop.getProperty("URL");
		ReceivedfileListUrl=prop.getProperty("ReceivedFilelistingpageURL");
		url=serviceURL + ReceivedfileListUrl ;
		
	}
	@Test
	public void PostReceivedfiles() throws JsonGenerationException, JsonMappingException, IOException {
		restClient =new FtsClient();
		HashMap<String,String> headermap=new HashMap<String, String>();
		headermap.put("im_userid", "GCP513GTS8197");
		headermap.put("im_buid", "GC94102480QI");
		headermap.put("Content-Type", "application/json; charset=UTF-8"); 
		
		// use same sentfileslistinguserData 
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
        sendfilelistingusers.setAprf(new ArrayList<Object>());
        sendfilelistingusers.setSnrf(new ArrayList<String>());  
        sendfilelistingusers.setStatus(new ArrayList<String>());  
        sendfilelistingusers.setDelete(null);
        sendfilelistingusers.setIsConfidential(null);
        sendfilelistingusers.setIsLive(null);
        sendfilelistingusers.setAttributes(new HashMap<Object, Object>());
        
        ObjectMapper mapper =new ObjectMapper();
        mapper.writeValue(new File("C:/Selenium-NeoAutomation/ftsrestapi/src/main/java/org/com/ftsrestapi/data/RecievedfileslistingUsersdata.json"), sendfilelistingusers);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sendfilelistingusers);
        System.out.println("Generated JSON: \n" + jsonString);
        System.out.println("Request Headers: " + headermap);
        System.out.println("Request URL: " + url);
        closeablehttprequest= restClient.post(url, jsonString, headermap);
        //check status 
        int statusreceicedfilelistcode=closeablehttprequest.getStatusLine().getStatusCode();
        System.out.println("Response Status Code: " + statusreceicedfilelistcode);
         Assert.assertEquals(statusreceicedfilelistcode, RESPONSE_STATUS_CODE_200); 
         
         //check JSOn
         String responsereceivedfilelistingString=EntityUtils.toString(closeablehttprequest.getEntity(),"UTF-8");
         
       //convert to Json string
         JSONObject responsereceivefilelistingJson =new JSONObject(responsereceivedfilelistingString);
         System.out.println("The response from Received File Listing API is :\n" +responsereceivefilelistingJson.toString(4));
         
        
		
		
	}

}
