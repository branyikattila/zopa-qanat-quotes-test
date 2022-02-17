package uk.co.acme.apiservices;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiService {

    public Response createUser (String url, String body) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(body)
                .when().post(url+"/member").thenReturn();
    }

    public Response getMember (String url, String memberId) {
        return given().accept(ContentType.JSON)
                .queryParam("memberId", memberId)
                .when().get(url+"/member").thenReturn();
    }

    public Response getQuote (String url, String memberId, String body) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .queryParam("memberId", memberId)
                .body(body)
                .when().post(url+"/quote").thenReturn();
    }

    //TODO need to check valid quote one. it was working fine ...
    //TODO clean up



}
