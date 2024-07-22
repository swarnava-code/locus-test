package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import sh.locus.test.web.FlipkartTestRunner;

public class BookApiTest {
    private static final Logger logger = LogManager.getLogger(BookApiTest.class);

    @Test
    public void getBooksTest() {
        RestAssured.baseURI = "https://the-one-api.dev/v2";
        Response response = RestAssured
                .given()
                .when()
                .get("/book");
        logger.info("response:: "+ response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        int numberOfBooks = response.jsonPath().getList("docs").size();
        Assert.assertEquals(numberOfBooks, 3);
        response.jsonPath().getList("docs").forEach(book -> {
            logger.info(book);
        });
    }
}
