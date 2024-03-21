package api.user;

import api.BaseTest;
import io.restassured.RestAssured;
import model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static utils.StepsForUser.generateRandomUser;
import static utils.StepsForUser.registerNewUser;

public class UserTests extends BaseTest {

    public static final String AUTH_ENDPOINT = "/login";
    public static final String REGISTER_ENDPOINT = "/register";

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
    }

    @Test
    public void registerNewUserTest() {

        registerNewUser(generateRandomUser())
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void loginWithUserNameAndPasswordTest() {

        User userData = generateRandomUser();

        registerNewUser(userData)
                .then().log().all()
                .statusCode(201);

        request.body(userData)
                .post(AUTH_ENDPOINT)
                .then().log().all()
                .statusCode(200)
                .and()
                .extract().as(Token.class);
    }
}
