package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    public static Properties readFile() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
