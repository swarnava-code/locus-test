package sh.locus.test.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import sh.locus.test.util.FileUtil;
import java.util.Properties;

public class BaseClass {
    protected static final String PROP_PATH = "src/test/resources/api.properties";
    protected static final String BASE_URL = "https://the-one-api.dev/v2";
    protected static String bearerToken;
    static Properties properties;

    @BeforeClass
    public static void getProperties() {
        properties = FileUtil.readPropertiesFile(PROP_PATH);
    }

    @BeforeClass
    public static void getBaseUri() {
        RestAssured.baseURI = "https://the-one-api.dev/v2";
    }

    @BeforeClass
    public static void getBearerToken() {
        bearerToken = "Bearer " + properties.getProperty("token");
    }

}
