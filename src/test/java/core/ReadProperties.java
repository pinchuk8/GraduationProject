package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties = null;
    private static String filename = "config.properties";

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getLogin_Url() {
        return properties.getProperty("login_url");
    }

    public static String getBrowserName() {
        return properties.getProperty("browser");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static String getUrlApi() {
        return properties.getProperty("urlApi");
    }
}
