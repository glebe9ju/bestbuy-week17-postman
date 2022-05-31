package com.bestbuy.testbase.categoriesinfo;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class CategoriesPostTest extends TestBase {

    @Test
    public void createCategories() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setName("Alkline Battery");
        categoriesPojo.setId("pcmcat84000050001");

        Response response = given()
                .basePath("/categories")
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(400);
        response.prettyPrint();

//    "id": 9999681,


    }
}
