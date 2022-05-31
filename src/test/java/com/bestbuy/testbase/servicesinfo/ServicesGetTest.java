package com.bestbuy.testbase.servicesinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ServicesGetTest extends TestBase {

    @Test
    public void getAllServicesInfo() {
        Response response = given()
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleServicesInfo() {

            Response response = given()
                    .pathParam("id",2)
                    .when()
                    .get("/services/{id}");
            response.then().statusCode(200);
            response.prettyPrint();

    }

    @Test
    public void searchServicesWithParameter1() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit",3);
        qParams.put("$skip",1);
        Response response = given()
                .basePath("/services")
                .queryParams(qParams)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
//@Test
//public void searchServicesWithParameter() {
//    HashMap<String,Object> qParams=new HashMap<>();
//    qParams.put("$limit",3);
//    Response response=given()
//            .basePath("/services")
//            .header("Accept", "application/json")
//            .queryParams(qParams)
//            .when()
//            .get();
//    response.then().statusCode(200);
//    response.prettyPrint();
//}
}
