package com.hjszx.data.preparation.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class WebUtil {

	public static String htmlEncodeByRegExp(String content){
		
		if(content == null || content.length()==0)
			return "";
		
		content = content.replaceAll("&", "&amp;amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		
		return content;
	}

	public static String sendGET(String url){
			
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
	
		client.getParams().setAuthenticationPreemptive(true);
		//retry 3 times
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
		        new DefaultHttpMethodRetryHandler()); 
		
		String response="";
		// postMethod
		int statusCode = 0;
		try {
			statusCode = client.executeMethod(getMethod);
			
			byte[] responseBody = getMethod.getResponseBody();
			
			response = new String(responseBody);

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			getMethod.releaseConnection();
		}
		
		return response; 
	}
	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}
