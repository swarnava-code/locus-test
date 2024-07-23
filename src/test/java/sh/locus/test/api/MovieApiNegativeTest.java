package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieApiNegativeTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(MovieApiNegativeTest.class);

    @Test
    public void getMoviesWithoutAuth() {
        Response response = RestAssured
                .given()
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesWithInvalidApiKey() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer invalid-api-key-123")
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesWithMalformedApiKey() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer _DoRaF1DragonZ-5Ball")
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

    @Test
    public void getMoviesNonExistentEndpoint() {
        Response response = RestAssured
                .given()
                .when()
                .get("/movie-invalid");
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void getMoviesWithInvalidQueryParams() {
        Response response = RestAssured
                .given()
                .queryParam("invalidParam", "invalidValue")
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 401);
    }

}
