package api.product;

import api.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static utils.StepsForProduct.createNewProduct;

public class ProductAddTests extends BaseTest {

    private static final String PRODUCTS_ENDPOINT = "/products";

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268" + PRODUCTS_ENDPOINT;
    }

    @Test
    public void addNewProductTest() {
       createNewProduct()
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void addNewProductTestWithoutBody() {
        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .post()
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addNewProductTestWithoutAttributeName() {

        String product = "{\n" +
                "\"category\": \"random category\",\n" +
                "\"price\": 5.5,\n" +
                "\"discount\": 1\n" +
                "}";

        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(product)
                .post()
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addNewProductTestWithoutAttributeCategory() {

        String product = "{\n" +
                "\"name\": \"random name\",\n" +
                "\"price\": 5.5,\n" +
                "\"discount\": 1\n" +
                "}";

        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(product)
                .post()
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addNewProductTestWithoutAttributePrice() {

        String product = "{\n" +
                "\"name\": \"random name\",\n" +
                "\"category\": \"random category\",\n" +
                "\"discount\": 1\n" +
                "}";

        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(product)
                .post()
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addNewProductTestWithoutAttributeDiscount() {

        String product = "{\n" +
                "\"name\": \"random name\",\n" +
                "\"category\": \"random category\",\n" +
                "\"price\": 5.5,\n" +
                "}";

        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(product)
                .post()
                .then().log().all()
                .statusCode(400);
    }

}
