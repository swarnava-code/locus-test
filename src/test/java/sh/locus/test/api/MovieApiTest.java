package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovieApiTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(MovieApiTest.class);
    private static String token;

    @BeforeMethod
    public void getToken(){
        token = properties.getProperty("token");
    }

    @Test
    public void getMoviesWithoutAuth() {
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured
                .given()
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesWithInvalidApiKey() {
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer invalid-api-key-123")
                .when()
                .get("/movie");

        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesWithMalformedApiKey() {
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer _ZF1mF1DragonZ-5Ball")
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesNonExistentEndpoint() {
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured
                .given()
                .when()
                .get("/movie-invalid");
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void getMoviesWithInvalidQueryParams() {
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured
                .given()
                .queryParam("invalidParam", "invalidValue")
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

}
