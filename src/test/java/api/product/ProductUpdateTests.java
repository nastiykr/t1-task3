package api.product;

import api.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static utils.StepsForProduct.randomProduct;

public class ProductUpdateTests extends BaseTest {

    private static final String PRODUCTS_ENDPOINT = "/products";
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268" + PRODUCTS_ENDPOINT;
    }

    @Test
    public void updateInformationAboutProduct() {

       request.body(randomProduct())
               .put("/1")
               .then().log().all()
               .statusCode(200);
    }

    @Test
    public void updateInformationAboutProductIsNoExists() {

        request.body(randomProduct())
                .put("/1000")
                .then().log().all()
                .statusCode(404);
    }

    @Test
    public void updateInformationAboutProductWithoutId() {

        request.body(randomProduct())
                .put()
                .then().log().all()
                .statusCode(405);
    }

    @Test
    public void updateInformationAboutProductIWithoutBody() {

        request.put("/1")
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void updateInformationAboutProductOnlyName() {

        String product = "{\n" +
                "\"name\": \"random name\"" +
                "}";

        request.body(product)
                .put("/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void updateInformationAboutProductOnlyCategory() {

        String product = "{\n" +
                "\"category\": \"random category\",\n" +
                "}";

        request.body(product)
                .put("/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void updateInformationAboutProductOnlyPrice() {

        String product = "{\n" +
                "\"price\": 5.5,\n" +
                "}";

        request.body(product)
                .put("/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void updateInformationAboutProductOnlyDiscount() {

        String product = "{\n" +
                "\"discount\": 1\n" +
                "}";

        request.body(product)
                .put("/1")
                .then().log().all()
                .statusCode(200);
    }
}
