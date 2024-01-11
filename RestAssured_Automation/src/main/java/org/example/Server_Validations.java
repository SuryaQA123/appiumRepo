package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Server_Validations {
    @Test
    public void add_place_server() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content_Type", "application/json")
                .body("{\n" +
                        "    \"location\": {\n" +
                        "        \"lat\": -38.383494,\n" +
                        "        \"lng\": 33.427362\n" +
                        "    },\n" +
                        "    \"accuracy\": 50,\n" +
                        "    \"name\": \"Frontline house\",\n" +
                        "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "    \"address\": \"29, side layout, cohen 09\",\n" +
                        "    \"types\": [\"shoe park\", \"shop\"],\n" +
                        "    \"website\": \"http://google.com\",\n" +
                        "    \"language\": \"French-IN\"\n" +
                        "}\n").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.52 (Ubuntu)");
    }

@Test
    public void fun() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String re = given().log().all().queryParam("key", "qaclick123").header("Content_Type", "application/json")
                .body("{\n" +
                        "&quot;place_id&quot;:&quot;8d2573bdf6ceec0e474c5f388fa917fb&quot;,\n" +
                        "&quot;address&quot;:&quot;70 winter walk, USA&quot;,\n" +
                        "&quot;key&quot;:&quot;qaclick123&quot;\n" +
                        "}").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath js = new JsonPath(re);
    System.out.println(re);

    }

}
