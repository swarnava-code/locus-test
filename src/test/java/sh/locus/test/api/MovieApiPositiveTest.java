package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MovieApiPositiveTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(MovieApiPositiveTest.class);

    @BeforeClass
    public static void getBearerToken() {
        bearerToken = "Bearer 4qAaXynbVomwqHwO6MXW";
    }

    @Test
    public void testGetMoviesSuccess() {
        Response response = RestAssured
                .given()
                .header("Authorization", bearerToken)
                .when()
                .get("/movie");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertNotNull(response.getBody(), "Response body should not be null");
        String movies = response.jsonPath().getString("docs");
        Assert.assertNotNull(movies, "Movies list should not be null");
        Assert.assertTrue(movies.length() > 0, "Movies list should not be empty");
        int movieCount = response.jsonPath().getList("docs").size();
        for (int i = 0; i < movieCount; i++) {
            Assert.assertNotNull(response.jsonPath().getString("docs[" + i + "]._id"), "Movie ID should not be null");
            Assert.assertNotNull(response.jsonPath().getString("docs[" + i + "].name"), "Movie name should not be null");
            Assert.assertNotNull(response.jsonPath().getString("docs[" + i + "].runtimeInMinutes"), "Runtime should not be null");
        }
    }

    @Test
    public void testGetSpecificMovieField() {
        Response response = RestAssured
                .given()
                .header("Authorization", bearerToken)
                .when()
                .get("/movie");
        String movieName = response.jsonPath().getString("docs[0].name");
        Assert.assertNotNull(movieName, "Movie name should not be null");
        Assert.assertTrue(movieName.length() > 0, "Movie name should not be empty");
    }

}
