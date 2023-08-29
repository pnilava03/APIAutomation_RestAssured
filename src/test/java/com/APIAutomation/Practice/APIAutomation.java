package com.APIAutomation.Practice;

import com.APIAutomation.CommonMethods.ReusableMethods;
import com.APIAutomation.Files.PayLoads;
import com.APIAutomation.Files.ResponseKey;
import com.APIAutomation.Files.ResponseValue;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class APIAutomation {

    static ReusableMethods reusableMethods = new ReusableMethods();
    static ResponseValue responseValue = new ResponseValue();
    String expectedValue = "West Bengal ,Habra";


    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    @Test(priority = 1)
    public void getPlace() {
        setup();
        System.out.println("****************-Get call started-****************");
        String getAddress = given().log().all().queryParam("key", "qaclick123")
                .queryParam(String.valueOf(ResponseKey.place_id), AddPlace.add_Place())
                .queryParam("Content-Type", "application/json")
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().asString();
        String actualAddress = reusableMethods.getResponse(getAddress, String.valueOf(ResponseKey.address));
        System.out.println("Address is:: " + actualAddress);
        Assert.assertEquals(responseValue.addressValue(actualAddress), expectedValue);
        System.out.println("****************-Get call end-****************");
    }

    @Test (priority = 2)
    public void updatePlace(){
        System.out.println("****************-Update call started-**************** ");
        setup();
      String updateResponse=  RestAssured.given().log().all().queryParam("key","qaclick123")
                .queryParam("Content-Type","application/json")
                .body(PayLoads.updatePlace())
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).extract().asString();

      System.out.println("New address is updated :: "+reusableMethods.getResponse(updateResponse,"msg"));
      System.out.println("****************-Update call End-**************** ");
    }

    @Test (priority = 3)
    public void getUpdatePlace(){
        String placeId=AddPlace.add_Place();
        System.out.println("Place id is:: "+placeId);
        setup();
        String resp=RestAssured.given().log().all().queryParam("key","qaclick123")
                .queryParam("Content-Type","application/json")
                .queryParam(String.valueOf(ResponseKey.place_id),placeId)
                .when().get("/maps/api/place/get/json").then().log().all()
                .assertThat().statusCode(200).extract().asString();

        String updatedAddressValue=reusableMethods.getResponse(resp, String.valueOf(ResponseKey.address));
        System.out.println("Updated Address is :: "+updatedAddressValue);
    }




}
