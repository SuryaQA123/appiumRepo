package org.example;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
public class demo1 {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Rahul Shetty Academy\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n").when().post("/maps/api/place/add/json").then().log().all().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response); //for parsing Json
        String placeId = js.getString("place_id");
        System.out.println(placeId);


        String response1 = given().log().all().queryParam("key", "qaclick").header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"place_id\": \"" + placeId + "\",\n" +
                        "  \"address\": \"Telangana11qww\",\n" +
                        "  \"key\": \"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json").then().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(response1); //for parsing Json
        String msg = js1.getString("msg");
        System.out.println(msg);
        System.out.println(placeId);


        String address_res = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).header("Content-Type", "application/json").
                when().get("maps/api/place/get/json").then().log().all().statusCode(200).extract().response().asString();
        JsonPath jsp = new JsonPath(address_res);
        System.out.println(jsp.getString("address"));


    }
}
