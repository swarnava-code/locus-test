package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieApiTwoStepCaseTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(MovieApiTwoStepCaseTest.class);

    @Test
    public void testGetMoviesAndQuotesTwoStepCase() {
        Response moviesResponse = RestAssured
                .given()
                .header("Authorization", bearerToken)
                .when()
                .get("/movie");
        Assert.assertEquals(moviesResponse.getStatusCode(), 200);
        String movieId = moviesResponse.jsonPath().getString("docs[7]._id");
        Assert.assertNotNull(movieId, "Movie ID should not be null");
        logger.info("[STEP-1] completed, movieId: " + movieId);

        Response quotesResponse = RestAssured
                .given()
                .header("Authorization", bearerToken)
                .when()
                .get("/movie/" + movieId + "/quote");
        Assert.assertEquals(quotesResponse.getStatusCode(), 200);
        String quotes = quotesResponse.jsonPath().getString("docs");
        Assert.assertNotNull(quotes, "Quotes should not be null");
        Assert.assertTrue(quotes.length() > 0, "Quotes should not be empty");
        String actualMovieIdInQuotes = quotesResponse.jsonPath().getString("docs[0].movie");
        Assert.assertEquals(actualMovieIdInQuotes, movieId, "quotes should have same movieId");
        logger.info("[STEP-2] completed, quotes: " + quotes + " , movieId: " + actualMovieIdInQuotes);
    }

}
