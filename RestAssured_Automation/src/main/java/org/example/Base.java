package org.example;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Base {
    public static String get_Resorce ="/maps/api/place/get/json";
    public static JsonPath js;
    public static String key = "key";
    public static int status_code = 200;
    public static String keyValue = "qaclick";
    public static String headerKey = "Content-Type";
    public static String header_Type = "application/json";
    public static String put_Resorce = "/maps/api/place/update/json";

    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick").header("Content-Type", "application/json")
                .body(Payloads.AddPlace()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void add_place() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick").header("Content-Type", "application/json")
                .body("{\n" +
                        "&quot;location&quot;: {\n" +
                        "&quot;lat&quot;: -38.383494,\n" +
                        "&quot;lng&quot;: 33.427362\n" +
                        "},\n" +
                        "&quot;accuracy&quot;: 50,\n" +
                        "\n" +
                        "&quot;name&quot;: &quot;Frontline house&quot;,\n" +
                        "&quot;phone_number&quot;: &quot;(+91) 983 893 3937&quot;,\n" +
                        "&quot;address&quot;: &quot;29, side layout, cohen 09&quot;,\n" +
                        "&quot;types&quot;: [\n" +
                        "&quot;shoe park&quot;,\n" +
                        "&quot;shop&quot;\n" +
                        "],\n" +
                        "&quot;website&quot;: &quot;http://google.com&quot;,\n" +
                        "&quot;language&quot;: &quot;French-IN&quot;\n" +
                        "}").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
    }

    public static String get_responseKey(String response, String key) {
        js = new JsonPath(response);
        String key_return = js.getString(key);
        System.out.println("key Return Value :::" + key_return);
        return key_return;
    }

}
