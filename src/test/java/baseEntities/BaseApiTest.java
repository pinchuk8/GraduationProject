package baseEntities;

import core.ReadProperties;
import dbEntries.TaskTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeTest
    public void setupApiTest() {
        RestAssured.baseURI = ReadProperties.getUrlApi();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
