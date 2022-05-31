package com.bestbuy.testbase.servicesinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ServicesPutTest extends TestBase {
    @Test
    public void updateProductWithPatch() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Zinc Battery");
        productPojo.setType("Battery");
        productPojo.setPrice(18);
        productPojo.setShipping(0);
        productPojo.setUpc("000444");
        productPojo.setDescription("Long--lasting energy powerful");
        productPojo.setManufacturer("Duracell");
        productPojo.setModel("Uc-3333");
        productPojo.setUrl("http://www.bestbuy.com/site/zinc1");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4853/48000_sa.jpg");

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