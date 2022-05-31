package com.bestbuy.testbase.storesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StoresDeleteTest extends TestBase {
    @Test
            public void deleteProduct(){
        Response response = given()
                .pathParam("id",8927)
                .when()
                .delete("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }



    //Homework

}
