package com.bestbuy.testbase.categoriesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class CategoriesGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleCategoriesInfo() {

        Response response = given()
                .pathParam("id", "abcat0010000")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void searchCategoriesWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 3);
        Response response = given()
                .basePath("/categories")
                .queryParams(qParams)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
