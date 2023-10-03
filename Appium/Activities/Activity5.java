package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        //set the appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Test
    public void createsmsTest() {
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("9866452528"+"\n");

        ((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
       // driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/contact_picker_create_group")).click();

        //driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        driver.findElement(AppiumBy.xpath("//*[@text='Text message']")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();



    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }

}
