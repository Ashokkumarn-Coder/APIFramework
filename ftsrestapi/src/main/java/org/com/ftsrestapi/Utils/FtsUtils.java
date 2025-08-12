package org.com.ftsrestapi.Utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.com.ftsrestapi.ftsclient.FtsClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class FtsUtils{

	public static String  getValueByJpath(JSONObject responsejson, String jpath)
	{
		Object obj =responsejson;
		for(String s :jpath.split("/"))
			if(!s.isEmpty())
				if(!(s.contains("[")||s.contains("]")))
				obj =((JSONObject)obj).get(s);
				else if(s.contains("[")||s.contains("]"))
					obj =((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]","")));
		return obj.toString();
	}
	
	

}



