package com.spotify.baseinfo.applicationapi;

import static com.spotify.baseinfo.SpecBuilder.getRequestSpec;
import static com.spotify.baseinfo.SpecBuilder.getResponseSpec;

import java.time.Instant;
import java.util.HashMap;

import com.spotify.utility.ConfigLoader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
private static String access_token;
private static Instant expiry_time;
	
public static String getToken() {	
  	
	try {	
	      if (access_token == null || Instant.now().isAfter(expiry_time)){
		
			Response response =  renewToken();
			access_token = response.path("access_token");
			int expiryDur = response.path("expires_in");
			expiry_time = Instant.now().plusSeconds(expiryDur-300);
			return access_token;
	
		   } 
	   else {
	  	System.out.println("Access Token is active");
	  
	        }
	}
	catch(Exception e) {
		new RuntimeException("ABORT!!!!!Renew TokenFailed");
			
		}	
	
	return access_token;
	
	
  	}
	private static Response renewToken() {
	
		HashMap<String, String> formParm = new HashMap<String,String>();
		
		
		formParm .put("client_id", ConfigLoader.getInstance().getClientid());
		formParm .put("client_secret",ConfigLoader.getInstance().getClientsecret());
		formParm .put("grant_type", ConfigLoader.getInstance().getGranttype());
		formParm .put("refresh_token",ConfigLoader.getInstance().getRefreshtoken());
		
		Response response= RestResourceApi.postAccesstoken(formParm);
		if(response.statusCode() !=200) {
		
			new RuntimeException("ABORT!!!!!Renew TokenFailed");
	
		}

	return response;
	}
}

