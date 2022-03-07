package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import models.Pet;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.Randomization;

import static io.restassured.RestAssured.given;

public class AFEApiTest extends BaseApiTest {
    Gson gson = new Gson();
    String username = Randomization.getRandomString(15);

    @Test
    public void addUserTest() {
        User user = new User.Builder()
                .withId(2)
                .withUsername(username)
                .withFirstname(Randomization.getRandomString(10))
                .withLastname(Randomization.getRandomString(10))
                .withEmail(Randomization.getRandomString(25))
                .withPassword(Randomization.getRandomString(8))
                .build();

       given()
                .body(user, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.POST_CREATE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserNameTest() {
    given()
            .pathParam("username", username)
            .when()
            .get(Endpoints.GET_USER_NAME)
            .then()
            .log().body()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getLoginUserTest() {

    }

}
