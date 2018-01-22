package project_filament;

import java.net.URL;
import java.net.HttpURLConnection;

public class Verifylinks {

	public void Verifylink(String rowNo, String links) {
		try{
			URL url = new URL(links);
			HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
			httpurlconnection.setConnectTimeout(3000);
			httpurlconnection.connect();
			if(httpurlconnection.getResponseCode()==200){
				System.out.println("Link is :"+links+"-"+httpurlconnection.getResponseMessage());
	
			}
			if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println("Link is :"+links+"-"+httpurlconnection.getResponseMessage());
			}
			
		}catch(Exception e){
			System.out.println("Error is :"+e.getMessage());
		}
		
	}

}
