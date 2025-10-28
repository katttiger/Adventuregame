package se.sprinto.hakan.adventuregame.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {
    private static AppInfo instance;
    private static Properties properties;
    private static final File path = new File("properties.txt");

    private AppInfo() {
        properties = new Properties();
        try (FileReader reader = new FileReader(path)) {
            properties.load(reader);

            //TODO Find a way to make the program work without using the setProperties method.
            setProperties("author", "Cecilia");
            setProperties("version", "1.1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppInfo getInstance() {
        if (instance == null) {
            instance = new AppInfo();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperties(String key, String value) {
        properties.setProperty(key, value);
    }


}
