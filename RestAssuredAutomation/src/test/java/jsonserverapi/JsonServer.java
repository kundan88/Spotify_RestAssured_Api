package jsonserverapi;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonServer {
    @Test
    public void getPosts_ApiExecution_RestAssured() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")

                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void createPosts_ApiExecution_RestAssured() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n"+
                "   \"id \":5 ,\n" +
                "   \"title\":  \"My json -server\",\n"+
                "   \"author\":  \"John Due\"\n  " + "}")
                .when()
                .post("http://localhost:3000/posts");
        response.prettyPrint();


    }
    @Test
    public void updatePosts_ApiExecution_RestAssured() {
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "   \"id \":5 ,\n" +
                        "   \"title\":  \"My json -server\",\n" +
                        "   \"author\":  \"Sam peter\"\n  " + "}")
                .when()
                .put("http://localhost:3000/posts");
        response.prettyPrint();

    }

    @Test
    public void removePosts_ApiExecution_RestAssured() {
        Response response = given()
                .contentType("application/json")
                .accept("application/json")

                .when()
                .put("http://localhost:3000/posts/3");
        response.prettyPrint();

    }
    }

