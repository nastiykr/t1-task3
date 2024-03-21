package api.cart;

import api.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static utils.StepsForUser.authorizeUser;
import static utils.StepsForUser.registerNewUser;


public class RemoveCartTests extends BaseTest {

    private final static String USERNAME = "nastiya";
    private final static String PASSWORD = "12345";
    private final static String CART_ENDPOINT = "/cart";

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
        registerNewUser(new User(USERNAME, PASSWORD));
    }

    @Test
    public void removeProductFromUserShoppingCart() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        request.header(new Header("Authorization", "Bearer " + token))
                .delete(CART_ENDPOINT + "/1")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void removeProductFromUserShoppingCartWithoutHeader() {

        request.delete(CART_ENDPOINT + "/1")
                .then().log().all()
                .statusCode(401);
    }

    @Test
    public void removeProductFromUserShoppingCartWithoutToken() {

        request.header(new Header("Authorization", "Bearer "))
                .delete(CART_ENDPOINT + "/1")
                .then().log().all()
                .statusCode(422);
    }

    @Test
    public void removeProductFromUserShoppingCartIsNoExists() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        request.header(new Header("Authorization", "Bearer " + token))
                .delete(CART_ENDPOINT + "/2000")
                .then().log().all()
                .statusCode(404);
    }

    @Test
    public void removeProductFromUserShoppingCartWithoutId() {

        String token = authorizeUser(new User(USERNAME, PASSWORD));

        request.header(new Header("Authorization", "Bearer " + token))
                .delete(CART_ENDPOINT)
                .then().log().all()
                .statusCode(405);
    }
}
