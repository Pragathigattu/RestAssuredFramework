package com.spotify.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import io.qameta.allure.junit4.*;

import org.testng.annotations.Test;

import com.spotify.baseinfo.applicationapi.PlayListApi;
import com.spotify.baseinfo.applicationapi.TokenManager;
import com.spotify.pojo.Error;
import  com.spotify.pojo.PlayList;
import com.spotify.utility.DataLoader;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import static com.spotify.utility.FakerUtility.generateName;
import static com.spotify.utility.FakerUtility.generateDescription;
@Epic("Allure examples")
@Feature("Junit 4 support")
public class PlayListTest {

//removed before class and created class SpecBulider
	@Step
	public PlayList playListBuilder(String name, String description, Boolean _public) {
		
		PlayList playList = new PlayList();
			playList.setName(name); 
		    playList.setDescription(description);
			playList.set_public(_public); 
   return playList;
	}		
	@Step
	public void  assertPlayListEqual(PlayList responsePlayList, PlayList requestPlayList) {
		assertThat(responsePlayList.getName(),equalTo(requestPlayList.getName()));
	    assertThat(responsePlayList.getDescription(),equalTo(requestPlayList.getDescription()));
	    assertThat(responsePlayList.get_public(),equalTo(requestPlayList.get_public()));
	    
	}
	@Step
	public void assertStatusCode(int actualStatusCode, int exceptedStatusCode) {
		        assertThat(actualStatusCode, equalTo(exceptedStatusCode));
	}
	
	
	
@Test
@Link("https//:schoolbucks.org/")
@Link(name=" allure", type= "mylink")
@Issue("1234")
@Issue("4563")
@TmsLink("CreatePlayList")
@DisplayName("CreatePlayList")
@Story("Base support for bdd annotations")
	public void createAPlayList() {
	

	
	PlayList requestPlayList = playListBuilder(generateName(),generateDescription(), false);
	Response response = PlayListApi.post(requestPlayList);
	assertPlayListEqual(response.as(PlayList.class),requestPlayList);
	
	//PlayList response = PlayListApi.post(requestPlaylist).as(PlayList.class);
	

    
    
}

@Test
@DisplayName("GetPlaylist")
public void GetPlayList() {

	PlayList requestPlayList = playListBuilder("New Playlist1","", false);
	Response response = PlayListApi.get(DataLoader.getInstance().getGetPlaylist_id());
	assertPlayListEqual(response.as(PlayList.class),requestPlayList);
	
}


@Test
@DisplayName("UpdatePlayList")
public void UpdatePlayList() {

PlayList requestPlayList = playListBuilder("Pragathi","New playlist description",false);
	
Response response = PlayListApi.update(requestPlayList ,DataLoader.getInstance().getUpdatePlaylist_id());
	
	
	
}
	
//************************Negative Test Case************************	

@Test
@DisplayName("withOutName")
public void withOutName() {


	PlayList requestPlaylist =  playListBuilder("",generateDescription(),false);
	
    Response response =	PlayListApi.post(TokenManager.getToken(), requestPlaylist);
    Error error = response.as(Error.class);
    assertThat(error.getError().getMessage(),equalTo("Missing required field: name"));


}

@Test
@DisplayName("ExpiredToken")
public void ExpiredToken() {
	
	PlayList requestPlaylist = new PlayList();
	
	Error error = given().
			baseUri("https://api.spotify.com/").basePath("/v1").
			header("Athourization","Bearer"+"12345").contentType("application/json").log().all().
			when().post("/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
			then().assertThat().statusCode(401).extract().response().as(Error.class);
			
	 //assertThat(error.getError().getStatus(),equalTo(401)) ;
	// assertThat(error.getError().getMessage(),equalTo("Missing required field:name"));
	
	
}





}

//*******************post*****************8*******
//assertThat(response.statusCode(),equalTo(201));
	//PlayList responsePlaylist = response.as(PlayList.class);}
	

	/*PlayList response =given(requestSpecification).
	
			body(requestPlaylist).	
	when().
	       post("/users/31eqszoxxhdswriyxyfhcsxuf264/playlists").
    then().
           spec(responseSpecification).
           assertThat().
           statusCode(201).
           extract().
           response().
           as(PlayList.class);*/
	//assertThat(response.getName(),equalTo(requestPlaylist.getName()));
   // assertThat(response.getDescription(),equalTo(requestPlaylist.getDescription()));
   // assertThat(response.getPublic(),equalTo(requestPlaylist.getPublic()));
	
		



	
//**********************get******************************
	
			/*PlayList response =given(requestSpecification).
	
			when().
			       get("/playlists/1ODCGOKDjARJPGOwJKK6yi").
		    then().
		           spec(responseSpecification).
		           assertThat().
		           statusCode(200).
		           extract().
		           response().
		           as(PlayList.class);*/
			
	



//*****************update*********************
		
		//PlayList responsePlaylist = response.as(PlayList.class);
				/*Response response =given(requestSpecification).
				
						body(requestPlaylist).	
				when().
				       put("/playlists/6z15J4ArFhyDGct1I8Vs09").
			    then().
			           spec(responseSpecification).
			           assertThat().
			           statusCode(200).
			           extract().
			           response();
			           //.as(PlayList.class);"*/
					
	//assertThat(response.getName(),equalTo(requestPlaylist.getName()));
  //  assertThat(response.getDescription(),equalTo(requestPlaylist.getDescription()));
   // assertThat(response.getPublic(),equalTo(requestPlaylist.getPublic()));
	
	
	
