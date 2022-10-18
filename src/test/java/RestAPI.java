
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class RestAPI {
    @Test
    public  void testGet(){
        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }
}
