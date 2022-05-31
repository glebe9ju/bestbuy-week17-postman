package com.bestbuy.testbase.servicesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesDeleteTest extends TestBase {
    @Test
    public void deleteSerivces() {
        Response response = given()
                .basePath("/services")
                .pathParam("id", 27)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

