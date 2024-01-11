package pojo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class getResponse {
    public static void main(String[] args) {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(
                "https://rahulshettyacademy.com/").setContentType(ContentType.JSON).build();
        login loginr = new login();
        loginr.setUserEmail("PostmanTesting@gmail.com");
        loginr.setUserPassword("9dW$X9#u3XjSRG");
        RequestSpecification res = given().spec(req).log().all().body(loginr);
        LoginResponse loginResponse = res.when().post("api/ecom/auth/login").then().log().all().extract().as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
    }

}
