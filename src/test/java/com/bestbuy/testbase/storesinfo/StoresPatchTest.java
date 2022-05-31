package com.bestbuy.testbase.storesinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StoresPatchTest extends TestBase {

    @Test
    public void updateStoresWithPatch(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Patric");
        storesPojo.setType("Battery");
        storesPojo.setAddress("100,city");
        storesPojo.setAddress2("Marta");
        storesPojo.setZip("123456");



        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 8925)
                .body(storesPojo)
                .when()
                .patch("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

        //Homework

    }
}
