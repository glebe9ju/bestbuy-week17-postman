package com.bestbuy.testbase.extractingresponsedata.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathStores {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //1.Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    //2.Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5
    @Test
    public void test003() {
        String fifthstore = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the name of fifth store: " + fifthstore);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> allStoresNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the name of all the stores are : " + allStoresNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> allStoresId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extrct the storeId of all the stores are: " + allStoresId);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Print the size of the data list
    @Test
    public void test006() {
        int size = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of the data list : " + size);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Address of the store is : " + address);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the services of 8
    @Test
    public void test009() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store's services : " + services);
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<List<String>> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store services of the store: " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of the store : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }
    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id=response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of the all the stores : " + id);
        System.out.println("------------------End of Test---------------------------");
    }
    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> storeNames = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store's name : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<List<Integer>> totalServices = response.extract().path("data.findAll{it.name=='Rochester'}.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services for the store where store name is Rochester : "+totalServices.get(0).size());
        System.out.println("------------------End of Test---------------------------");
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<?> created =response.extract().path("data.find{it.services}.services.findAll{it.name='Windows Store'}.storeservices.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total createdAt for all services whose name is “Windows Store” : "+created);
        System.out.println("------------------End of Test---------------------------");
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total services Where store name = “Fargo” : "+services);
        System.out.println("------------------End of Test---------------------------");
    }
    //17. Find the zip of all the store
    @Test
    public void test017() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total services Where store name = “Fargo” : "+zip);
        System.out.println("------------------End of Test---------------------------");
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
       String zip = response.extract().path("data[2].zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total services Where store name = “Roseville” : "+zip);
        System.out.println("------------------End of Test---------------------------");
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<?> services = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Storeservices of Magnolia Home Theater : "+services);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List<String> services = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Lat of all the stores : "+services);
        System.out.println("------------------End of Test---------------------------");
    }
}
