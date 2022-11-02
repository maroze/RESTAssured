import io.restassured.http.ContentType;
import model.UserRequestModel;
import io.restassured.RestAssured;

public class APIUser {
    public void createUser(UserRequestModel model) {
        RestAssured.given()
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON)
                .body(model)
                .when().post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
