package com.APIAutomation.Practice;

import com.APIAutomation.Files.PayLoads;
import io.restassured.RestAssured;

public class DeletePlace {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        RestAssured.given().log().all().queryParam("key","qaclick123")
                .queryParam("Content-Type","application/json")
                .body(PayLoads.deletePlace())
                .when().delete("/maps/api/place/delete/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
