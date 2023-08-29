package com.APIAutomation.Files;

import com.APIAutomation.Practice.AddPlace;

public class PayLoads {
    public static String addPlace(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"API Automation Practice\",\n" +
                "  \"phone_number\": \"(+91)6789345645\",\n" +
                "  \"address\": \"West Bengal ,Habra\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"Bengali-IN\"\n" +
                "}\n";

    }

    public static String deletePlace(){
        return "{\n" +
                "    \""+ResponseKey.place_id+"\":\""+AddPlace.add_Place()+"\"\n" +
                "}";
    }

    public static String updatePlace(){
        return "{\n" +
                "\""+ResponseKey.place_id+"\":\""+ AddPlace.add_Place() +"\",\n" +
                "\""+ResponseKey.address+"\":\"16 Foot road, Krishnapur\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }
}
