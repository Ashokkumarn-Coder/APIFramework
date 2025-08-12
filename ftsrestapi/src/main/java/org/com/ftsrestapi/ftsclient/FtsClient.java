package org.com.ftsrestapi.ftsclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;




public class FtsClient {

//	//1.Get Method 
//	public CloseableHttpResponse get(String url ) throws IOException{
//	CloseableHttpClient httpClient= HttpClients.createDefault(); //will create on client method and returns closablehttps client 
//	HttpGet httpget=new HttpGet(url);// will connect one get connection with that URL  ; httpget-> it is arequest
//	CloseableHttpResponse closeablehttprequest= httpClient.execute(httpget);// hit the GET URL
//	
//	return closeablehttprequest;
//	
//	}
	//2.Get Method with headers 
		public CloseableHttpResponse get(String url,HashMap<String,String>hashMap ) throws IOException{
		CloseableHttpClient httpClient= HttpClients.createDefault(); //will create on client method and returns closablehttps client 
		HttpGet httpget=new HttpGet(url);// will connect one get connection with that URL  ; httpget-> it is arequest
		
		for(Map.Entry<String, String> entry : hashMap.entrySet() ) {
			httpget.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse closeablehttprequest= httpClient.execute(httpget);// hit the GET URL
		
		return closeablehttprequest;
		
		}

		//3.Post Method:
		public CloseableHttpResponse post(String url, String entityString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpClient= HttpClients.createDefault(); // create client 
			HttpPost httppost = new HttpPost(url); // Http post request 
			httppost.setEntity(new StringEntity(entityString)); //for payload 
			
			//For headers
			for(Map.Entry<String, String> entry : headerMap.entrySet() ) {  //define headers
				httppost.addHeader(entry.getKey(),entry.getValue());
			}
			CloseableHttpResponse closeableHttpResponse =	httpClient.execute(httppost);// execute the request
			return closeableHttpResponse;
			
		}
		

}
