package com.bridgelabz.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyTracks {
    @Test
    public void getTrack__By_Id_ApiExecution() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization"," Bearer BQCcRrx1-GOe5lcf3fHKSDkqm5B2OlHyjk6Wc7Lb24dxbf8KggsJDF7hsVBdewnt8ivN4QRyGgjzCPDhGUwD-CgrcKD3aMCTp42K1GrJvx0A891d-0RxiMJkwAH7PEXw7TPX_Ks8wTgv9ZZA6RfMKZd4h1isrUYZgPVsTwM8MnMt9p5gxTVVUgIH9Gv8rjSFLeV3YeFvt3qLR9vlOaLkbAKIvcGahzeG4n8bvIaSN8usE7fJIivR1IhC6N-QYPnsog2Qv2w4Vx250Q8fG6F4dUvrP4Rz-Q1EiTo8NTmxvpu3Yftc-tyfW1XGdxcazJ8i7R-dCvxI9w")
                .get(" https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
