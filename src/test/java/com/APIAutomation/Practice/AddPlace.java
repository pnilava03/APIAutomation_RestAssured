package com.APIAutomation.Practice;

import com.APIAutomation.CommonMethods.ReusableMethods;
import com.APIAutomation.Files.PayLoads;
import com.APIAutomation.Files.ResponseKey;
import com.APIAutomation.Files.ResponseValue;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddPlace {
    public static String add_Place(){
        System.out.println("****************-Post call start-****************");
        RestAssured.baseURI="https://rahulshettyacademy.com";

      String response=  given().log().all()
              .queryParam("key","qaclick123")
              .queryParam("Content-Type","application/json")
              .body(PayLoads.addPlace()).when().post("/maps/api/place/add/json")
              .then().log().all().assertThat().statusCode(200)
              .body("scope", equalTo("APP")).extract().response().asString();

        System.out.println("Add place response is:: "+response);
        ReusableMethods reusableMethods= new ReusableMethods();
        String value=reusableMethods.getResponse(response, String.valueOf(ResponseKey.place_id));
        System.out.println("Add place Place id value is:: "+value);
        System.out.println("****************-Post call end-****************");
        return value;

    }
}
