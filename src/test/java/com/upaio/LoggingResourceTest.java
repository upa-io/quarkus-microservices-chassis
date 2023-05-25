package com.upaio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
class LoggingResourceTest {

    @Test
     void testLoggingEndpoint(){
        given()
                .when().get("/logging/com.upaio")
                .then()
                .statusCode(200);
    }
}
