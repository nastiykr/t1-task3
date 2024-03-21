package utils;

import api.user.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.user.User;
import org.apache.commons.lang3.RandomStringUtils;

import static api.user.UserTests.AUTH_ENDPOINT;
import static api.user.UserTests.REGISTER_ENDPOINT;
import static io.restassured.RestAssured.given;


public class StepsForUser {

    public static User generateRandomUser() {

        String username = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphanumeric(10);

        return new User(username,password);
    }

    public static Response registerNewUser(User user) {
        return given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .post(REGISTER_ENDPOINT);
    }

    public static String authorizeUser(User user){

        return given().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .post(AUTH_ENDPOINT)
                .then().log().all()
                .statusCode(200)
                .extract().as(Token.class).accessToken();
    }

}
