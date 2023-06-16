package com.spotify.baseinfo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.baseinfo.applicationapi.TokenManager;
import com.spotify.pojo.PlayList;

import static com.spotify.baseinfo.SpecBuilder.getResponseSpec;
//import static com.spotify.baseinfo.SpecBuilder.RequestAccesstokenSpecBuilder;
import static com.spotify.pojo.PlayList.*;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	
	
//String 	Access_token="BQA-5AbvpNgpFPPfbKab_UmHAfy_gYlhO5vlLc6oby5h6ooBn7plSWggY9nyhwn2uaqj6ZP-WnrAIg_rwMnRCjcj6SiluSa5YZwSU7KKaDrDlc4tBmZsDVr9yspuSUuUI9P0Y6FTorSZz33uH0GVury8sdLMKMr-cK0e2PtjuIbBYlkWU6-7yPa6-wJjSyDMbnSi8YkwfT1lFugrY-9ScWScWiZ7OKwP9eZYCgDkXS3IDP20yl3qoljzTtfuKXw5X7PguDYC1QwPuH27";
		
	public static RequestSpecification getRequestSpec() {	
	 return new RequestSpecBuilder().
				setBaseUri("https://api.spotify.com/").
				setBasePath("/v1").
				setContentType(ContentType.JSON).
				addFilter(new AllureRestAssured()).
				
				log(LogDetail.ALL).build();
		
		 
		
	}
		
	public static ResponseSpecification getResponseSpec() {
	         
	                return new ResponseSpecBuilder().
						
						 log(LogDetail.ALL).build();
				
	
	
	}

public static RequestSpecification  getAccesstokenRequestSpec() {
	return  new RequestSpecBuilder ().
			setBaseUri("https://accounts.spotify.com").
	        setContentType(ContentType.URLENC).
	        addFilter(new AllureRestAssured()).
	        log(LogDetail.ALL).build();
	
	
     }
	
}	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void createAPlayList() {
			
		PlayList requestPlaylist = new PlayList()
		
	    .setDescription("New playlist description")
	    .setName("pragathi") 
		.setPublic(false);
		

		PlayList response =given(getRequestSpec()).
		
				body(requestPlaylist).	
		when(). post("/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
	    then().
	           spec(getResponseSpec()).
	           assertThat().
	           statusCode(201).
	           extract().
	           response().
	           as(PlayList.class);
		//assertThat(response.getName(),equalTo(requestPlaylist.getName()));
	   // assertThat(response.getDescription(),equalTo(requestPlaylist.getDescription()));
	   // assertThat(response.getPublic(),equalTo(requestPlaylist.getPublic()));
		}
	
	
	@Test
	public void GetPlayList() {

				PlayList responsePlaylist =given(getRequestSpec()).
		
				when().
				       get("/playlists/1ODCGOKDjARJPGOwJKK6yi").
			    then().
			           spec(getResponseSpec()).
			           assertThat().
			           statusCode(200).
			           extract().
			           response().
			           as(PlayList.class);
					
			}
	@Test
	public void UpdatePlayList() {
		
		

		PlayList requestPlaylist = new PlayList()
				.setName("Pragathi") 
			    .setDescription("New playlist description")
				.setPublic(false);

				Response response=given(getRequestSpec()).
				
						body(requestPlaylist).	
				when().
				       put("/playlists/6z15J4ArFhyDGct1I8Vs09").
			    then().
			           spec(getResponseSpec()).
			           assertThat().
			           statusCode(200).
			           extract().
			           response();
			           //as(PlayList.class);
				//assertThat(response.getName(),equalTo(requestPlaylist.getName()));
			    //assertThat(response.getDescription(),equalTo(requestPlaylist.getDescription()));
			   // assertThat(response.getPublic(),equalTo(requestPlaylist.getPublic()));
				}
					

	
  	
	
	
	}

	

}*/