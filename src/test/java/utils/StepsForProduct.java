package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.product.NewProduct;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class StepsForProduct {
    public static NewProduct randomProduct() {

        String name = RandomStringUtils.randomAlphabetic(10);
        String category = RandomStringUtils.randomAlphanumeric(10);
        double price = 5.5;
        int discount = 1;

        return new NewProduct(name, category, price, discount);
    }

    public static Response createNewProduct() {
        return given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(randomProduct())
                .post();
    }
}
