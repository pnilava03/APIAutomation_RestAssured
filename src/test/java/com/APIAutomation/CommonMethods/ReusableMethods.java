package com.APIAutomation.CommonMethods;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public String getResponse(String response, String pathOfJson){
        JsonPath jsonPath= new JsonPath(response);
        return jsonPath.getString(pathOfJson);
    }
}
