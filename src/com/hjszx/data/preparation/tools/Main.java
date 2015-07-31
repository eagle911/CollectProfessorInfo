package com.hjszx.data.preparation.tools;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\professor.txt";
		String url = CollectDataTools.URL_BASE;
		StringBuilder sb = new StringBuilder();
		
		int i=1;
		int j=1;
		for(;i<=CollectDataTools.MAX_INT;i++){
			
			Professor p = CollectDataTools.resolve(CollectDataTools.get(url+i),i);
			
			if(!p.name.equals("")){
				System.out.println(j+". "+ p);
				sb.append(j+". "+ p + "\n");
				j++;
			}
		}
		FilesUtils fu = FilesUtils.getInstance(file);
		fu.appendContents(sb.toString());
		fu.close();
	}

}
