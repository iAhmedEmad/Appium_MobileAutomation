import Actions.MobileActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class TestConfigurations {
     public WebDriver driver;
     public MobileActions ma;
    public WebDriver setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "//src//test//resources//TestDataFiles//ApiDemos-debug.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "14.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        ma = new MobileActions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
     }
    public void tearDownDevice() {
        if (driver != null) {
            driver.quit();
        }
    }
}
