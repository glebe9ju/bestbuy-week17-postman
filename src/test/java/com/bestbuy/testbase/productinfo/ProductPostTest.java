package com.bestbuy.testbase.productinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ProductPostTest extends TestBase {

    @Test
    public void createProduct() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Alkline Battery");
        productPojo.setType("Battery");
        productPojo.setPrice(100);
        productPojo.setShipping(0);
        productPojo.setUpc("000444");
        productPojo.setDescription("Long--lasting energy");
        productPojo.setManufacturer("Kodak");
        productPojo.setModel("Uc-3333");
        productPojo.setUrl("http://www.bestbuy.com/site/kodak1");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4853/48000_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

//    "id": 9999681,


    }
}
