package com.spotify.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.net.CacheResponse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.pojo.PlayList;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpotifyPlayListTest {

	
RequestSpecification requestSpecification;
ResponseSpecification responseSpecification;

	@BeforeClass

	public void beforeClass() {
		
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://api.spotify.com/").
				
				addHeader("Authorization","Bearer BQB1RQevvWN4E6MsJ3KLvH1Rlf7rsV-iIcr5yPUT0Rtg7KPq91q5SVMXBCqvhdKCNdJKuSX8K_rFYJTZfB6oUjlATGx4UWyg2c0QmdbOhYq3jPlKH-ZvMo4N_ZYXhCPR01eiZrR9vSF3o1QVnjy8S6JNwg1E92oLCdiEx2Y5049JTxRa7b2ysy7ibAQO0XfRCAKH2zNVcs9ffVq03ezCeC4tO0sPzV72dIpXQgOEHlv_uXjZkYE8-OtWrtXWbypnRvKWa2rL-ObLrxTpxw"
						).
				addHeader("Content-Type", "application/json").log(LogDetail.ALL);
				
		 RestAssured.requestSpecification =requestSpecBuilder.build();
		 
		

		
				 ResponseSpecBuilder responseSpecBuilder =new ResponseSpecBuilder().
						 //expectStatusCode(200).
						 //expectContentType(ContentType.JSON).
						 log(LogDetail.ALL);
						
		
		RestAssured.responseSpecification =  responseSpecBuilder.build();
	
	}
	
	/*@Test
	public void Validate_playlist() {
	
	RestAssured.given().baseUri("https://api.spotify.com/").
	when().get("/v1/playlists/1ODCGOKDjARJPGOwJKK6yi").
	then().log().all().statusCode(200);
		
		
		
	}	
	
	@Test
	public void validate_postplaylist() {
		
	String payload =	"{\n"
			+ "		    \"name\": \" A.R.Rahman\",\n"
			+ "		    \"description\": \"New playlist description\",\n"
			+ "		    \"public\": false,\n"
			+ "		    \"collaborative\": true\n"
			+ "		}";
		RestAssured.given().body(payload).
		when().post("/v1/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
        then().log().all().statusCode(201);
				
		
}
	@Test
	public void validate_UpdatePlaylist() {
		
	String payload ="{\n"
			+ "    \"name\": \"pragathi\",\n"
			+ "    \"description\": \"New playlist description\",\n"
			+ "    \"public\": false,\n"
			+ "    \"collaborative\": true\n"
			+ "}";	
		
		RestAssured.given().body(payload).
		when().put("/v1/playlists/6z15J4ArFhyDGct1I8Vs09").
		then().log().all().statusCode(200);
	}
	
	
	
	@Test
	public void validate_PostPlaylist() {
		
	String payload = 	"{\n"
		
			+ "		    \"description\": \"New playlist description\",\n"
			+ "		    \"public\": false,\n"
			+ "		    \"collaborative\": true\n"
			+ "		}";
		RestAssured.given().body(payload).
		when().post("/v1/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
		then().log().all().statusCode(201);
		
	}
	

	@Test
	public void validate_postplaylist1() {
		
	String payload =	"{\n"
			+ "		    \"name\": \" A.R.Rahman\",\n"
			+ "		    \"description\": \"New playlist description\",\n"
			+ "		    \"public\": false,\n"
			+ "		    \"collaborative\": true\n"
			+ "		}";
	

	
	
		RestAssured.given().body(payload).
		when().post("/v1/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
        then().
             log().all().assertThat().body("name",equalTo("A.R.Rahman"));
             

		
		

		
}*/

@Test
public void playlist_pojo() {
	
	PlayList requestPlaylist = new PlayList();
	requestPlaylist.setName("A.R.Rahman"); 
	requestPlaylist .setDescription("New playlist description");
	requestPlaylist.set_public(false); 
	requestPlaylist.setCollaborative(true);
	
	/*PlayList playList = given().body(requestPlaylist).when().post("/v1/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
			then().assertThat().statusCode(201).extract().response().as(PlayList.class);*/
	
	
	PlayList responsePlaylist =given(requestSpecification).
	
			body(requestPlaylist).	
	when().
	       post("/v1/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
    then().
           spec(responseSpecification).
           assertThat().
           statusCode(201).
           extract().
           response().
           as(PlayList.class);
	
}
	@Test
	public void validateGetPlayListPojo() {
	
		PlayList requestPlaylist = new PlayList();
		requestPlaylist.setName("A.R.Rahman"); 
		requestPlaylist .setDescription("New playlist description");
		requestPlaylist.set_public(false); 
		requestPlaylist.setCollaborative(true);
		PlayList responsePlayList = given().
				body(requestPlaylist).
	when().get("/v1/playlists/1ODCGOKDjARJPGOwJKK6yi").
	then().
	//spec(responseSpecification).
	assertThat().
	statusCode(200).
	extract().response().as(PlayList.class);
	
	
}





}
	
	