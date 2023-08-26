package com.APIAutomation.Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class AddPlace {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123").
                queryParam("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Hello API Testing\",\n" +
                        "  \"phone_number\": \"(+91)6789345612\",\n" +
                        "  \"address\": \"16 Feet road, Hanapara\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"Bengali-IN\"\n" +
                        "}\n").when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200);
    }
}
