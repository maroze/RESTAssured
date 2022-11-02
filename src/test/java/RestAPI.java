
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
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

    @Test
    public void testPost(){
        JSONObject request = new JSONObject();
        request.put("name","alla");
        request.put("job","programmer");

        RestAssured.given()
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
