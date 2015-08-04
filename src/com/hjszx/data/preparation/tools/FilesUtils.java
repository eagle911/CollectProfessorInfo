package com.hjszx.data.preparation.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FilesUtils {  
	
    private static FilesUtils instance;  
	private String file;

    
    private FilesUtils (String file){
    	this.file = file;
    	
    }  
  
    public static FilesUtils getInstance(String file) {  
    	if (instance == null) {  
    		instance = new FilesUtils(file);  
    	}  
    	return instance;  
    }

	public void appendContents(String content) {
		// TODO Auto-generated method stub
		
		FileWriter fw = null;
		try {
			File f=new File(this.file);
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		
//		
//	    OutputStreamWriter writer = null;
//	    FileOutputStream fos = null;
//	    
//    	try {
//			fos = new FileOutputStream(file);
//			writer = new OutputStreamWriter(fos);
//
//			writer.append(content);
//			writer.flush();
//			writer.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
	}

	public void close() {
		// TODO Auto-generated method stub
	}  
}  