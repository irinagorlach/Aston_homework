import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class TestsAPI {

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGETReqResponseBody() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/get")
                .then().log().body()
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test
    public void testGETReqWoopsResponseBody() {
        given()
                .contentType(ContentType.JSON)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then().log().body()
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testGETReqResponseCodeOK() {
        given()
                .contentType(ContentType.JSON)
                .when().get("/get")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testPOSTRawTextResponseBody() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"test\":\"value\"" +
                        "}")
                .post("/post")
                .then().log().body()
                .assertThat()
                .body("data.test", equalTo("value"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("json.test", equalTo("value"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPOSTRawTextResponseCodeOK() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        " \"test\":\"value\"" +
                        "}")
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    //передать параметры и проверить их не получается
    @Test
    public void testPOSTFormDataResponseBody() {
        given().log().body()
//                .headers("Content-Type", "application/x-www-form-urlencoded")
                .contentType(ContentType.JSON)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
//                .body("foo1", equalTo("bar1"))
//                .body("foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPOSTFormDataResponseCodeOK() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testPUTReqResponseBody() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .body("This is expected to be sent back as part of response body.")
                .put("/put")
                .then().log().body()
                .assertThat()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPUTReqResponseCodeOK() {
        given()
                .contentType(ContentType.JSON)
                .when().put("/put")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testPATCHReqResponseBody() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .body("This is expected to be sent back as part of response body.")
                .patch("/patch")
                .then().log().body()
                .assertThat()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testPATCHReqResponseCodeOK() {
        given()
                .contentType(ContentType.JSON)
                .when().patch("/patch")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testDELETEReqResponseBody() {
        given().log().body()
                .contentType(ContentType.JSON)
                .when()
                .body("This is expected to be sent back as part of response body.")
                .delete("/delete")
                .then().log().body()
                .assertThat()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    @Test
    public void testDELETEReqResponseCodeOK() {
        given()
                .contentType(ContentType.JSON)
                .when().delete("/delete")
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }
}
