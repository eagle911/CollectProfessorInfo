package com.hjszx.data.preparation.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FilesUtils {  
	
    private static FilesUtils instance;  
	
    OutputStreamWriter writer = null;
    FileOutputStream fos = null;
    
    private FilesUtils (String file){
    	
    	try {
			fos = new FileOutputStream(file);
			writer = new OutputStreamWriter(fos);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    }  
  
    public static FilesUtils getInstance(String file) {  
    	if (instance == null) {  
    		instance = new FilesUtils(file);  
    	}  
    	return instance;  
    }

	public void appendContents(String content) {
		// TODO Auto-generated method stub
		
		try {
			
			writer.append(content);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void close() {
		// TODO Auto-generated method stub
		try {
			this.writer.flush();
			this.writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}  