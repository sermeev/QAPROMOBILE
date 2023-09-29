package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumSelenideDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(System.getProperty("platformName","Android"));
        options.setDeviceName(System.getProperty("deviceName","otus"));
        options.setPlatformVersion(System.getProperty("platformVersion","5.1"));


        options.setAppPackage("com.pyankoff.andy");
        options.setAppActivity("MainActivity");

        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://"+System.getProperty("addressServer")+"/wd/hub"), options);
            driver.configuratorSetWaitForSelectorTimeout(Duration.ofSeconds(10));
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
