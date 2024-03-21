package api.cart;

import api.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import model.cart.AddToShoppingCart;
import model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static utils.StepsForUser.authorizeUser;
import static utils.StepsForUser.registerNewUser;


public class CartAddTests extends BaseTest {

    private final static String USERNAME = "nastiya";
    private final static String PASSWORD = "12345";
    private final static String CART_ENDPOINT = "/cart";

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
        registerNewUser(new User(USERNAME, PASSWORD));
    }

    @Test
    public void addProductToUserShoppingCart() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        AddToShoppingCart product = new AddToShoppingCart(1,2);

        request.header(new Header("Authorization", "Bearer " + token))
                .body(product)
                .post(CART_ENDPOINT)
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void addProductToUserShoppingCartWithoutHeader() {

        AddToShoppingCart product = new AddToShoppingCart(1,2);

        request.body(product)
                .post(CART_ENDPOINT)
                .then().log().all()
                .statusCode(401);
    }

    @Test
    public void addProductToUserShoppingCartWithoutBody() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        request.header(new Header("Authorization", "Bearer " + token))
                .post(CART_ENDPOINT)
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addProductToUserShoppingCartWithoutAttributeProductId() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        String product = "{" +
                "\"product_id\": 1," +
                "}";

        request.header(new Header("Authorization", "Bearer " + token))
                .body(product)
                .post(CART_ENDPOINT)
                .then().log().all()
                .statusCode(400);
    }

    @Test
    public void addProductToUserShoppingCartWithoutAttributeQuantity() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        String product = "{" +
                "\"quantity\": 2" +
                "}";

        request.header(new Header("Authorization", "Bearer " + token))
                .body(product)
                .post(CART_ENDPOINT)
                .then().log().all()
                .statusCode(404);
    }
}
