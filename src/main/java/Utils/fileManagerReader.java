package Utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;


public class fileManagerReader {
    public static String FileReader(String userDirectory, String key){
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of(userDirectory)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}

