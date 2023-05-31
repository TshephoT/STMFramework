package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;

public class ReadPropertyFile {
    public static String browser;
    public static String testurl;

    public static void ReadFiles() throws IOException {

        //  Configure config.properties file reader
        FileReader fileReader = new FileReader(System.getProperty("user.dir"));
        Properties properties = new Properties();
        properties.load(fileReader);

        //  Read from the config.properties
        browser = properties.getProperty("browser");
        testurl = properties.getProperty("testurl");
    }
}
