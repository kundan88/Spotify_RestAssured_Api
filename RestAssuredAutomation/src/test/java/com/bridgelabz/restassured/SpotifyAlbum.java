package com.bridgelabz.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAlbum {
    String token=" Bearer BQCb3sjZajigcBK0tuUCG7fJGwJtsG5DzB8cbLYQJV_fJ6gqeHAR12trsFADGNTNBWAmuj8iuowrRX8JSJ_bP1M7EV6gknqeAJaBiUJWUca6VO4DAfzs0fSvL5xDjl_kizlqpM6NwKr0i-ipG_TLLrfF8Wbvjcj4CfNrzWLfdyJPfeF6k-WpUxTJ8cSccpwK5fy8px1ccR3y3nvGxaco7LKiWAgd956btW7K1f7AzT3UCbgMquNiXep_gOT1YlRl1pLdlJ9RHV3rzJDPxj_EV-VfHECfW-7t7dJD2TQAkSmohIKfSFBGbDw1ymk3idUH7e2il0k9qw";
    @Test
    public void getSpotify_Albums_By_Id_ApiExecution() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void getSpotify_Several_Albums_By_Id_ApiExecution() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization","Bearer BQCcRrx1-GOe5lcf3fHKSDkqm5B2OlHyjk6Wc7Lb24dxbf8KggsJDF7hsVBdewnt8ivN4QRyGgjzCPDhGUwD-CgrcKD3aMCTp42K1GrJvx0A891d-0RxiMJkwAH7PEXw7TPX_Ks8wTgv9ZZA6RfMKZd4h1isrUYZgPVsTwM8MnMt9p5gxTVVUgIH9Gv8rjSFLeV3YeFvt3qLR9vlOaLkbAKIvcGahzeG4n8bvIaSN8usE7fJIivR1IhC6N-QYPnsog2Qv2w4Vx250Q8fG6F4dUvrP4Rz-Q1EiTo8NTmxvpu3Yftc-tyfW1XGdxcazJ8i7R-dCvxI9w")
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
