package com.hjszx.data.preparation.tools;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class CollectDataTools {

	public final static String URL_BASE="http://cksp.eol.cn/tutor_detail.php?id="; //31736 - 1";
	public final static int MAX_INT = 31736;
	
	
	public final static String P_NAME = "<th width=\"80\">姓　　名</th>";
	public final static String R_NAME = "\" target=\"_blank\">";
	public final static String E_NAME = "</a></td>";
	
	public final static String P_SEX = "<th width=\"80\">性　　别</th>";
	public final static String R_SEX = "<td width=\"40\">";
	public final static String E_SEX = "</td>";
	
	public final static String P_BIRTHDAY = "<th width=\"80\">出生年月</th>";
	public final static String R_BIRTHDAY = "<td width=\"80\">";
	public final static String E_BIRTHDAY = "</td>";
	
	public final static String P_UNIVERSITY = "<th>所在院校</th>";
	public final static String R_UNIVERSITY = "\">";
	public final static String E_UNIVERSITY = "</a></td>";
	
	public final static String P_COLLEGE = "<th>所在院系</th>";
	public final static String R_COLLEGE = "\">";
	public final static String E_COLLEGE = "</td>";
	
	public final static String P_TITLE = "<th>职　　    称</th>";
	public final static String R_TITLE = "<td>";
	public final static String E_TITLE = "</td>";
	
	public final static String P_LEVEL = "导师类别：";
	public final static String R_LEVEL = "<strong class=\"colO\">";
	public final static String E_LEVEL = "</strong>";
	
	public final static String P_MAJOR = "<th>招生专业</th>";
	public final static String R_MAJOR = "title=\"";
	public final static String E_MAJOR = "\" target=\"_blank\" class=\"f_12u_blue\"";
	
	public final static String P_RESEARCH = "<th height=\"70\" valign=\"top\">研究领域</th>";
	public final static String R_RESEARCH = "style=\"word-wrap:break-word;word-break:break-all;\">";
	public final static String E_RESEARCH = "</td>";
	
	public final static String P_EMAIL = "<td width=\"50\"><strong>E-mail </strong></td>";
	public final static String R_EMAIL = "<td width=\"150\">";
	public final static String E_EMAIL = "</td>";
	
	public final static String P_TEL = "<td width=\"50\"> <strong>电  话</strong></td>";
	public final static String R_TEL = "<td width=\"150\">";
	public final static String E_TEL = "</td>";
	
	public final static String P_ZIP = "<td width=\"50\"><strong>邮  编</strong> </td>";
	public final static String R_ZIP = "<td width=\"100\">";
	public final static String E_ZIP = "</td>";
	
	public final static String P_ADDR = "<td><strong>地  址</strong></td>";
	public final static String R_ADDR = "<td colspan=\"5\">";
	public final static String E_ADDR = "</td>";

	public final static String P_INTRODUCTION = "";
	public final static String R_INTRODUCTION = "";
	public final static String E_INTRODUCTION = "";
	
	public static String get(String url) {
		// TODO Auto-generated method stub
		
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		
		client.getParams().setAuthenticationPreemptive(true);
		//retry 3 times
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
		        new DefaultHttpMethodRetryHandler()); 
		
		String response = null;
		int statusCode = 0;
		try {
			statusCode = client.executeMethod(getMethod);
			response = new String(getMethod.getResponseBody(),"utf-8");

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
	public static Professor resolve(String body,int pageid) {
		// TODO Auto-generated method stub
		
		Professor p = new Professor();
		
		p.pageid = ""+pageid;
		p.name = SEARCHBody(body,P_NAME,R_NAME,E_NAME);
		p.sex = SEARCHBody(body,P_SEX,R_SEX,E_SEX);
		p.birthday = SEARCHBody(body,P_BIRTHDAY,R_BIRTHDAY,E_BIRTHDAY);
		p.university = SEARCHBody(body,P_UNIVERSITY,R_UNIVERSITY,E_UNIVERSITY);
		p.college = SEARCHBody(body,P_COLLEGE,R_COLLEGE,E_COLLEGE);
		p.title = SEARCHBody(body,P_TITLE,R_TITLE,E_TITLE);
		p.level = SEARCHBody(body,P_LEVEL,R_LEVEL,E_LEVEL);
		p.major = SEARCHBody(body,P_MAJOR,R_MAJOR,E_MAJOR);
		p.research = SEARCHBody(body,P_RESEARCH,R_RESEARCH,E_RESEARCH);
		p.email = SEARCHBody(body,P_EMAIL,R_EMAIL,E_EMAIL);
		p.tel = SEARCHBody(body,P_TEL,R_TEL,E_TEL);
		p.addr = SEARCHBody(body,P_ADDR,R_ADDR,E_ADDR);
		p.zip = SEARCHBody(body,P_ZIP,R_ZIP,E_ZIP); 
		p.introduction = SEARCHBody(body,P_INTRODUCTION,R_INTRODUCTION,E_INTRODUCTION);
		
		return p;
	}
	private static String SEARCHBody(String body, String pName, String rName, String eName) {
		// TODO Auto-generated method stub
		int index = body.indexOf(pName);
		if (index == -1)
			return "";
		String sub = body.substring(index+pName.length());
		int beginIndex = sub.indexOf(rName);
		int endIndex = sub.indexOf(eName);
		return sub.substring(beginIndex+rName.length(), endIndex);
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
