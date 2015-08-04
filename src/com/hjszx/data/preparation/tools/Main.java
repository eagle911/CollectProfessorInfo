package com.hjszx.data.preparation.tools;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\professor.txt";
		String url = CollectDataTools.URL_BASE;
		StringBuilder sb = new StringBuilder();
		FilesUtils fu = FilesUtils.getInstance(file);
		int i=16140;
		int j=14342;
		for(;i<=CollectDataTools.MAX_INT;i++){
			
			Professor p = CollectDataTools.resolve(CollectDataTools.get(url+i),i);
			
			if(!p.name.equals("")){
				System.out.println(j+". "+ p);
				fu.appendContents(j+". "+ p + "\n");
				j++;
			}
		}
		
		fu.close();

	}

}
