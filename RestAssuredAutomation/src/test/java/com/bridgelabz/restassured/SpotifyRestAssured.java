package com.bridgelabz.restassured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class SpotifyRestAssured {
    String token="Bearer BQA9q-_mdR-wV3b2-QWZ9g9SdybL7KbLoZ1bEhMTUbYstXtijU_PL0S7e4WGL68LpAwH0loaY0ayH7QH1_7C6D08w55kK7_TppK9QmARqwzvYDinicyfjeaHjXhUQQgZi07qMM_rea64NwGZxHYcKeOfNnE2uP7NQHBX1ivk_GIWsVge4mBb_nKj6Wy-gs3GS0xKGVV2snkK714l_4XzvjFQ_4vamkJmORNWitvvwHb20sPwHXLjIPrC5ym-zGwNddcq41vbjEMQ__wLnCgtyVV3_J-oH1tfDQOQYwMk8YCetKRVFycXIB3cf9jGMCRwl5pCWYmzzA";
    @Test
    public void getCurrentUserProfile_RestAssured(){

        given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me")
                .then()
                .log()
                .all();
    }
    @Test
    public void getUserProfile_id(){
       Response response = (Response) given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me");
                response.prettyPrint();
                String userId=response.path("id");
                System.out.println("UserID"+userId);
                response.then().assertThat().statusCode(200);
                Assert.assertEquals(response.getStatusCode(),200);
    }
}
