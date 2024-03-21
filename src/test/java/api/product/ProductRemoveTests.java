package api.product;

import api.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductRemoveTests extends BaseTest {

    private static final String PRODUCTS_ENDPOINT = "/products";
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268" + PRODUCTS_ENDPOINT;
    }

    @Test
    public void deleteProduct() {

        request.delete("/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void deleteProductIsNoExists() {

        request.delete("/1000")
                .then().log().all()
                .statusCode(404);
    }

    @Test
    public void deleteProductWithoutId() {

        request.delete()
                .then().log().all()
                .statusCode(405);
    }
}
