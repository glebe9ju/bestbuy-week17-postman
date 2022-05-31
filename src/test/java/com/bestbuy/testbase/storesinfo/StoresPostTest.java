package com.bestbuy.testbase.storesinfo;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StoresPostTest extends TestBase {

    @Test
    public void createStore() {

        StoresPojo storesPojo = new StoresPojo();

        storesPojo.setName("Patric");
        storesPojo.setType("Battery");
        storesPojo.setAddress("100,city");
        storesPojo.setAddress2("Marta");
        storesPojo.setCity("Manchestre");
        storesPojo.setState("USA");
        storesPojo.setZip("123456");
        storesPojo.setLat(0);
        storesPojo.setLng(0);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

//    "id": 8925,


    }
}
