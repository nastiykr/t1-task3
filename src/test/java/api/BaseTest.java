package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public final RequestSpecification request = given()
            .when().log().all()
            .contentType(ContentType.JSON);
}
