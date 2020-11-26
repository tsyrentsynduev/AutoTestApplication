package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumController {
    protected AppiumDriver driver;
    private DesiredCapabilities capabilities;

    public static String server;
    public static String platformVersion;
    public static String deviceName;
    public static String appPackage;
    public static String appActivity;
    public static String automationname;

    public void startAppium() throws Exception {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("automationname", automationname);

        driver = new AndroidDriver<MobileElement>(new URL(server), capabilities);

    }

    public void stopAppium() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
