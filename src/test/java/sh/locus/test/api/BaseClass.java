package sh.locus.test.api;

import org.testng.annotations.BeforeClass;
import sh.locus.test.util.FileUtil;
import java.util.Properties;

public class BaseClass {
    protected static final String PROP_PATH = "src/test/resources/api.properties";
    protected static final String BASE_URL = "https://the-one-api.dev/v2";
    static Properties properties;

    @BeforeClass
    public static void getProperties(){
        properties = FileUtil.readPropertiesFile(PROP_PATH);
    }
}
