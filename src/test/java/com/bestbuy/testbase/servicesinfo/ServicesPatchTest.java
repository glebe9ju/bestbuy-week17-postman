package com.bestbuy.testbase.servicesinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ServicesPatchTest extends TestBase {

    @Test
    public void updateServicesWithPatch(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Mathew");

        Response response = given()
                .basePath("/services")
                .header("Content-Type", "application/json")
                .pathParam("id", 26)
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

        //Homework

    }
}
