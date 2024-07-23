package sh.locus.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookApiTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(BookApiTest.class);

    @Test
    public void getBooksTest() {
        Response response = RestAssured
                .given()
                .when()
                .get("/book");
        logger.info("response:: "+ response.asString());
        response.jsonPath().getList("docs").forEach(book -> {
            logger.info(book);
        });
        Assert.assertEquals(response.getStatusCode(), 200);
        int numberOfBooks = response.jsonPath().getList("docs").size();
        Assert.assertEquals(numberOfBooks, 3);
    }

}
