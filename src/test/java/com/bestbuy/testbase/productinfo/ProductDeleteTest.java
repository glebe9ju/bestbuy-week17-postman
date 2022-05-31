package com.bestbuy.testbase.productinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDeleteTest extends TestBase {
    @Test
            public void deleteProduct(){
        Response response = given()
                .pathParam("id",309062)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
