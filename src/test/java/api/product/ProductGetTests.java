package api.product;

import api.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import model.product.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductGetTests extends BaseTest {

    private static final String PRODUCTS_ENDPOINT = "/products";
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268" + PRODUCTS_ENDPOINT;
    }

    @Test
    public void getInformationAboutProduct() {
        List<Product> list = request.get("/1")
                .then().log().all()
                .statusCode(200)
                .and()
                .extract().as(new ObjectMapper().getTypeFactory().constructCollectionType(List.class, Product.class));
    }

    @Test
    public void getInformationAboutProductIsNoExists() {
        request.get("/100000000")
                .then().log().all()
                .statusCode(404);
    }
}
