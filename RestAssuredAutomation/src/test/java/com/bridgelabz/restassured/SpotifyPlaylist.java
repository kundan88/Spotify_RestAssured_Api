package com.bridgelabz.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SpotifyPlaylist {
    String token="Bearer BQArrMtrdaSDNuh0p3DRcNm0nU6gzeqKLtW-BG6H9v8L67WXwZkl-NrVhwhpanK3Cve3mCVaES3FFZ6Y7CZ9jciYMgDSnsNO9FxY_ULIYYUUPjXeUNG1igRh4h2CXWHx1ZbhtJgqNwynsHKxhcyMNxNGu87YKNF1goEEaxMIC-MdU0HMW8ItuueAypcnh3elOwZLqpejvYSyEZx6tk1PrJN6S2iMtdnK4e0j6KZ38NQ3MFZdJCEoSBVoFTuHDNoC58RHGQMCile47c7A2tpW1hVvU2NXzNvdpYVbATJTBbplMfuRWAeBcAE-cj6eceSG-_7e4FtVjg";
    @Test
    public void createPlaylist_ApiExecution_ThenReturn_OkStatus(){
        Response apiResult = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"My KK New Playlist\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/wcb8c937mbg4zuyy57hcbacm3/playlists");
                 apiResult.then()
                         .assertThat()
                         .statusCode(201);

    }
    @Test
    public void addToItemInPlaylist_ApiExecution_ThenReturn_OkStatus() {
         given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"snapshot_id\": \"MyxlYzBlZGYwMGI5NThhNWFkNDEzYTU1Y2Q4NGI0ZWE2Y2FiYTliNDQ3\"\n" +
                        "}");
                when().post("https://api.spotify.com/v1/playlists/79gbO7CabvvlnU1HebcvN3/tracks")
                .then()
                        .log();

    }

    @Test
    public void getTrack_By_Id_ApiExecution() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/tracks/6EJiVf7U0p1BBfs0qqeb1f");
        response.prettyPrint();
        String userId=response.path("id");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void getUser_PalyList_By_Id_ApiExecution() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/users/wcb8c937mbg4zuyy57hcbacm3/playlists");
        response.prettyPrint();
        String userId=response.path("id");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    }

