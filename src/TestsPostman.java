import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestsPostman {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        given()
                .queryParam("name", "Thomas")
                .queryParam("occupation", "President")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.name", equalTo("Thomas"))
                .body("args.occupation", equalTo("President"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.connection", equalTo("close"))
                .body("url", equalTo("https://postman-echo.com/get?name=Thomas&occupation=President"));  // Изменено на https
    }

    @Test
    public void testDelete() {
        given()
                .queryParam("item", "12345")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.item", equalTo("12345"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.connection", equalTo("close"))
                .body("url", equalTo("https://postman-echo.com/delete?item=12345"));
    }

    @Test
    public void testPatch() {
        given()
                .contentType("application/json")
                .body("{\"title\": \"Emancipation Proclamation\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.title", equalTo("Emancipation Proclamation"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.connection", equalTo("close"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testPostBody() {
        given()
                .body("{\"event\": \"Inauguration\", \"year\": 1861}")
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.event", equalTo("Inauguration"))
                .body("data.year", equalTo(1861))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.connection", equalTo("close"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .log().all()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));


    }

    @Test
    public void testPut() {
        given()
                .contentType("application/json")
                .body("{\"role\": \"Leader\", \"term\": 4}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.role", equalTo("Leader"))
                .body("data.term", equalTo(4))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.connection", equalTo("close"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
}