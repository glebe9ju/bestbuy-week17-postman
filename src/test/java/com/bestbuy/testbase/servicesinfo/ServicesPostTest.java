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
public class ServicesPostTest extends TestBase {

    @Test
    public void createServices() {

        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Jason");

        Response response = given()
                .basePath("/services")
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

//   "id": 25,


    }
}
