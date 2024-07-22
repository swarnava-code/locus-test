package sh.locus.test.util;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtil {

    public static Properties readPropertiesFile(String fileName) {
        Properties properties = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
