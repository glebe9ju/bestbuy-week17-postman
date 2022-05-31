package com.bestbuy.testbase.utilities;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UtilitiesGetTest extends TestBase {
    @Test
    public void getHealthCheckInfo() {
        Response response = given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUtilitiesInfo() {

        Response response = given()
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
