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
public class CategoriesPatchTest extends TestBase {

    @Test
    public void updateCategoriesWithPatch(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Donna");
        categoriesPojo.setId("abcat0020001");



        Response response = given()
                .basePath("/categories")
                .header("Content-Type", "application/json")
                .pathParam("id", "abcat0020001")
                .body(categoriesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

        // "id": "abcat0020001",

    }
}
