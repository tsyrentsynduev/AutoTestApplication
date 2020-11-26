package test;

import org.junit.*;
import screen.MainScreen;
import screen.SearchScreen;


import java.io.*;
import java.util.Properties;


public class GifAppTest extends AppiumController {
    private final static String APPIUM_PROPERTIES_FILE = "src/test/resources/appium.properties";
    private final static String DEVICECONNECT_URL = "DEVICECONNECT_URL";
    private final static String DEVICECONNECT_DEVICENAME = "DEVICECONNECT_DEVICENAME";
    private final static String DEVICECONNECT_PLATFORMVERSION = "DEVICECONNECT_PLATFORMVERSION";
    private final static String APPLICATION_PACKAGE = "APPLICATION_PACKAGE";
    private final static String APPLICATION_ACTIVITY = "APPLICATION_ACTIVITY";
    private final static String AUTOMATIONNAME = "AUTOMATIONNAME";

    protected MainScreen mainScreen;
    protected SearchScreen searchScreen;

    public GifAppTest() {

    }

    public static void beforeStart() throws Exception {
        try (InputStream input = new FileInputStream(APPIUM_PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            server = prop.getProperty(DEVICECONNECT_URL);
            platformVersion = prop.getProperty(DEVICECONNECT_PLATFORMVERSION);
            deviceName = prop.getProperty(DEVICECONNECT_DEVICENAME);
            appPackage = prop.getProperty(APPLICATION_PACKAGE);
            appActivity = prop.getProperty(APPLICATION_ACTIVITY);
            automationname = prop.getProperty(AUTOMATIONNAME);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void setUp() throws Exception {
        startAppium();
        mainScreen = new MainScreen(driver);
        searchScreen = new SearchScreen(driver);
    }

    public void tearDown() throws Exception {
        stopAppium();
    }

}
