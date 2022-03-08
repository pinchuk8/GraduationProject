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
    String username = Randomization.getRandomString(10);
    long petId = -1;

    @Test
    public void addUserTest() {
        User user = new User.Builder()
                .withId("qwe")
                .withUsername(username)
                .withFirstname(Randomization.getRandomString(10))
                .withLastname(Randomization.getRandomString(10))
                .withEmail(" %%%")
                .withPassword(Randomization.getRandomString(8))
                .build();

       given()
                .body(user, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.POST_CREATE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test()
    public void getUserNameTest() {
    given()
            .pathParam("username", Randomization.getRandomString(10))
            .when()
            .get(Endpoints.GET_USER_NAME)
            .then()
            .log().body()
            .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void getLoginUserTest() {
    User negativeUser = new User.Builder()
            .withUsername("***")
            .withPassword("///")
            .build();

    given()
            .body(negativeUser, ObjectMapperType.GSON)
            .when()
            .get(Endpoints.LOGIN_USER)
            .then()
            .log().body()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getLogoutUserTest() {
        given()
                .when()
                .get(Endpoints.LOGOUT_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void addPetTest() {
        Pet pet = new Pet.Builder()
                .withName("Vaska")
                .withId(petId)
                .withStatus("available")
                .build();

        given()
                .body(pet, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.POST_ADD_PET)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test(dependsOnMethods = "addPetTest")
    public void getPetIdTest() {
        given()
                .pathParam("id", petId)
                .when()
                .get(Endpoints.GET_PET_ID)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
