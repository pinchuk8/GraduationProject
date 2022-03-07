package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import models.Pet;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class NFEApiTest extends BaseApiTest {
    Gson gson = new Gson();
    long petId;

    @Test
    public void addPetTest() {
        Pet pet = new Pet.Builder()
                .withName("Vaska")
                .withId(-1)
                .withStatus("available")
                .build();

       petId = given()
                .body(pet, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.POST_ADD_PET)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
               .extract().jsonPath().get("id");
    }

    @Test
    public void getFindByPetStatusTest() {
        given()
                .when()
                .get(Endpoints.GET_PET_FIND_BY_STATUS_AVAIlABLE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addPetTest")
    public void updatePetTest() {
        Pet updatePet = new Pet.Builder()
                .withId(petId)
                .withName("Buddy")
                .withStatus("sold")
                .build();

        given()
                .body(updatePet, ObjectMapperType.GSON)
                .log().body()
                .when()
                .put(Endpoints.UPDATE_PET_ID)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "updatePetTest")
    public void deletePetTest() {
        given()
                .pathParam("id", petId)
                .when()
                .delete(Endpoints.DELETE_PET_ID)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
