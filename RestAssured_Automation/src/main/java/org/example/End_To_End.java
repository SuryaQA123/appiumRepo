package org.example;

//import Files.Payloads;
import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.example.Base.*;
import static org.example.Base.key;
import static org.hamcrest.Matchers.equalTo;

public class End_To_End {


    public static void main(String[] args) {
// creating_Place

        String add_Place_Body = Payloads.AddPlace();
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(add_Place_Body).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println("first time add" + get_responseKey(response, "place_id"));
        String id = get_responseKey(response, "place_id");
        String place = "kurnool Ap";
//updated_place
        String updatedRes = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"place_id\": \"" + id + "\",\n" +
                        "  \"address\": \"" + place + "\",\n" +
                        "  \"key\": \"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
        System.out.println(updatedRes);
        JsonPath jsp = new JsonPath(updatedRes);
        Assert.assertEquals(jsp.getString("msg"), "Address successfully updated");


//get address

        String getRes = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", id).header("Content-Type", "application/json")
                .when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
        JsonPath jsp1 = new JsonPath(getRes);
        Assert.assertEquals(jsp1.getString("address"), place,"assertion o");
        System.out.println(getRes);

//jsp1.getString("")


//        String upDated_ResponseasString = given().queryParam(key, keyValue).header(headerKey, header_Type).body("{\n" +
//                        "&quot;place_id&quot;:&quot;" + id + "&quot;,\n" +
//                        "&quot;address&quot;:&quot;70 winter walk, USA&quot;,\n" +
//                        "&quot;key&quot;:&quot;qaclick123&quot;\n" +
//                        "}").when().put(put_Resorce)
//                .then().log().all().assertThat().statusCode(status_code).extract().response().asString();
//        System.out.println("updated" + upDated_ResponseasString);

//        String key_Id = "place_id";
//        String updated_PlaceID = get_responseKey(upDated_ResponseasString, "place_id");
//        System.out.println(updated_PlaceID);
//get updated Place and compare
//String  updated_response =given().queryParam(key,keyValue)  .queryParam("place_id",updated_PlaceID).when().get(get_Resorce).then().log()
//        .all().assertThat().statusCode(status_code).extract().response().asString();
//        String updated_Place1 = get_responseKey(updated_response, "address");
//        Assert.assertEquals(update_Place,updated_Place1);
    }


}
