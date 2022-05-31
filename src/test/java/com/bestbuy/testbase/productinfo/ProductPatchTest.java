package com.bestbuy.testbase.productinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ProductPatchTest extends TestBase {

    @Test
    public void updateProductWithPatch(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Alkline Battery");
        productPojo.setType("Battery");
        productPojo.setPrice(60);
        productPojo.setShipping(10);


        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 9999682)
                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

        //Homework

    }
}
