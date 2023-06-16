package com.spotify.baseinfo.applicationapi;

import com.spotify.pojo.PlayList;
import com.spotify.utility.ConfigLoader;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PlayListApi {
@Step
	//public static String access_token = "BQB1MrzmNaK7EtBq-A7pDOelxoj7sTlYdEXx9JHwctzcHuyTssW7SJdAI5BgJw-7wsBMxAbI9lysUWDD9TiZPiEo_1aoHlFv06ERLGCsCGQH_Rv_Cu1HvRT9tbJbB8iNnvz-X37r5pbHIpxn4dvU0dkPRZilsWPxV2Ws3Kh0PyqvxgDA3qp7wiV1UvJnWe0kR0NfDfArx00HlvCIVY0DneBUbDKeAsrLiPyGmV3FCas8zMLFMIj712W0KvbX8VQofJJC3byKLybVbycRnQ";
	public static Response post(PlayList requestPlayList) {
		return RestResourceApi.post("/users/"+ConfigLoader.getInstance().getUserid()+"/playlists", TokenManager.getToken(), requestPlayList);
	}

	public static Response post(String token, PlayList requestPlayList) {
		return RestResourceApi.errorPost("/users/"+ConfigLoader.getInstance().getUserid()+"/playlists", token, requestPlayList);

	}

	public static Response get(String PlayListId) {

		return RestResourceApi.get("/playlists/"+PlayListId, TokenManager.getToken());

	}

	public static Response update(PlayList requestPlaylist, String PlayListId) {
		return RestResourceApi.update("/playlists/"+ PlayListId, TokenManager.getToken(), requestPlaylist);

	}
}