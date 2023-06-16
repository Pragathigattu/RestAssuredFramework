package com.spotify.baseinfo.applicationapi;
//import static com.applicationapi.TokenManager.*;
import static com.spotify.baseinfo.SpecBuilder.getRequestSpec;
import static com.spotify.baseinfo.SpecBuilder.getResponseSpec;
import static com.spotify.baseinfo.SpecBuilder.getAccesstokenRequestSpec;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.spotify.pojo.PlayList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestResourceApi {//reusable methods
//rivate static RequestSpecification getAccesstokenRequestSpec;

	//**************************post method**********************
	public  static Response post(String path,String token, Object requestPlayList) {
		System.out.println("Path value "+path);
	return given(getRequestSpec()).
		body(requestPlayList).
		auth().oauth2(token).
		//header("Authorization","Bearer "+ token).
		when().post(path).
		then().spec(getResponseSpec()).
		assertThat().statusCode(201).extract().response();
	
	}	
//******************************* get method **************************
	public static Response get(	String path,String token) {
		
	    return given(getRequestSpec()).
	    		auth().oauth2(token).
	    		//header("Authorization","Bearer "+token).
		when().get(path).
		then().spec(getResponseSpec()).assertThat().statusCode(200).extract().response();
		
		}	


//************************* update method ********************
	public static Response update(String path,String token,Object requestPlayList) {
	return given(getRequestSpec()).
		body(requestPlayList).
		auth().oauth2(token).
		//header("Authorization","Bearer "+token).
		when().put(path).
		then().spec(getResponseSpec()).
		assertThat().statusCode(200).
		extract().
		response();



	}
	
	public  static Response errorPost(String path,String token, PlayList requestPlayList) {
		
	return given(getRequestSpec()).
		body(requestPlayList).
		auth().oauth2(token).
		//header("Authorization","Bearer "+ token).
		when().post(path).
		then().spec(getResponseSpec()).
		assertThat().statusCode(400).extract().response();
	}
//************************Token handling******************************
	
	public static Response postAccesstoken(HashMap<String, String> formParm ) {
	
		return given(getAccesstokenRequestSpec()).
			    formParams(formParm).
				when().post("/api/token").
				then().spec(getResponseSpec()).extract().response();
	
	
	
	
	}
}
