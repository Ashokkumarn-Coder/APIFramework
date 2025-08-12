package org.com.ftsrestapi.ftstestng;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.com.ftsrestapi.Utils.FtsUtils;
import org.com.ftsrestapi.ftsclient.FtsClient;
import org.com.ftsrestapi.ftsrestapi.FtsBase;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





public class FileViewdetails extends FtsBase{
	String serviceURL;
	String sendfileUrl;
	String url;
	FtsClient ftsclient;
	CloseableHttpResponse closeablehttprequest;

	FtsBase ftsBase;
	@BeforeMethod
	public void SetUp() 
	{
		ftsBase= new FtsBase();
		serviceURL=prop.getProperty("URL");
		sendfileUrl=prop.getProperty("SendFilesViewDetailsURL");
		// http://fts-dev-us-iwf.fulcrum-apps.bp.anthos.otxlab.net/fts/api/v1/files/listing/sentbox
		url=serviceURL +sendfileUrl ;
		
		
	}
	
//	@Test(priority = 1)
//	public void FtsApiTestwithoutHeaders() throws IOException 
//	{
//
//		ftsclient=new FtsClient(); //calling the client call 
//		closeablehttprequest = ftsclient.get(url);
//		
//		//a.Status Code
//		int statuscCode= closeablehttprequest.getStatusLine().getStatusCode();
//		System.out.println("StatusCode--->"+statuscCode);
//		
//		//Assert.assertEquals(statuscCode,RESPONSE_STATUS_CODE_200 ,"Status code is not 200"); //to validate //not removed hard coded
//		//b.Json String 
//		String responseString = EntityUtils.toString(closeablehttprequest.getEntity(),"UTF-8"); //json info will be ocnverted to string
//		
//		JSONObject responsejson=new JSONObject(responseString); //this will convert string into json
//		System.out.println("Response JSON From API-->"+ responsejson);
//		//Single value assertions-
////		String totalpagesValue=FtsUtils.getValueByJpath(responsejson, "/totalPages");
////		System.out.println("Total pages is--->"+ totalpagesValue );
////		Assert.assertEquals(Integer.parseInt(totalpagesValue), 1);
//		
//		//get value from Json array 
////		String FileID= FtsUtils.getValueByJpath(responsejson, "/result[0]/fileId");
////		System.out.println(FileID);
//		
//		//c.all headers
//		//header testing 
////		Header[] headerarray =closeablehttprequest.getAllHeaders();//headers comes in array 
////		
////		HashMap<String, String> allHeaders =new HashMap<String, String>(); //use of Hashmap look and feel
////		
////		for(Header header:headerarray)
////		{
////			allHeaders.put(header.getName(),header.getValue());
////		}
////		System.out.println("Headers Array-->"+allHeaders);
////
////		}
//	
	@Test(priority = 2)
	public void FtsApiTestwithHeaders() throws IOException 
	{

		ftsclient=new FtsClient(); //calling the client call 
		
		HashMap<String,String> headermap=new HashMap<String, String>();
		headermap.put("im_userid","GCP513GTS8197");
		headermap.put("im_buid", "GC94102480QI");
	
	    closeablehttprequest = ftsclient.get(url,headermap);
		
		//a.Status Code
	     int statuscCode= closeablehttprequest.getStatusLine().getStatusCode();
	    System.out.println("StatusCode--->"+statuscCode);
	
		Assert.assertEquals(statuscCode,RESPONSE_STATUS_CODE_200 ,"Status code is not 200"); //to validate //not removed hard coded
		//b.Json String 
		String responseString = EntityUtils.toString(closeablehttprequest.getEntity(),"UTF-8"); //json info will be ocnverted to string
		
		JSONObject responsejson=new JSONObject(responseString); //this will convert string into json
		System.out.println("Response JSON From API-->:\n"+ responsejson.toString(4));
		
//		//Single value assertions-
		String UserIdValue=FtsUtils.getValueByJpath(responsejson, "/userId");
	    System.out.println("User ID  is--->"+ UserIdValue );
		Assert.assertEquals(UserIdValue, "GCP513GTS8197");
		
//		//get value from Json array 
//		String FileID= FtsUtils.getValueByJpath(responsejson, "/result[0]/fileId");
//		System.out.println(FileID);
//		
//		//c.all headers
		//header testing 
		
		Header[] headerarray =closeablehttprequest.getAllHeaders();//headers comes in array 
		
		HashMap<String, String> allHeaders =new HashMap<String, String>(); //use of Hashmap look and feel
		
		for(Header header:headerarray)
		{
			allHeaders.put(header.getName(),header.getValue());
		}
		System.out.println("Headers Array-->:\n"+allHeaders.toString());

		}
	
	

}
