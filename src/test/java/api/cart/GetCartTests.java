package api.cart;

import api.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import model.cart.ShoppingCart;
import model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static utils.StepsForUser.authorizeUser;
import static utils.StepsForUser.registerNewUser;


public class GetCartTests extends BaseTest {

    private final static String USERNAME = "nastiya";
    private final static String PASSWORD = "12345";
    private final static String CART_ENDPOINT = "/cart";

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
        registerNewUser(new User(USERNAME, PASSWORD));
    }

    @Test
    public void getUserShoppingCart() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        List<ShoppingCart.ProductInShoppingCart> list = request.header(new Header("Authorization", "Bearer " + token))
                .get(CART_ENDPOINT)
                .then().log().all()
                .statusCode(200)
                .and()
                .extract().as(ShoppingCart.Root.class).carts();
    }

    @Test
    public void getUserShoppingCartWithoutHeader() {

        request.get(CART_ENDPOINT)
                .then().log().all()
                .statusCode(401);
    }
}
