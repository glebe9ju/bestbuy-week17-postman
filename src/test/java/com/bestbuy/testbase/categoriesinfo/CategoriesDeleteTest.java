package com.bestbuy.testbase.categoriesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteTest extends TestBase {
    @Test
            public void deleteCategories(){
        Response response = given()
                .basePath("/categories")
                .pathParam("id","abcat0020004")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
