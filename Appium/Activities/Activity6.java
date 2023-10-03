package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.text;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //set the appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        // driver.get("https://training-support.net/");

    }
    @Test
    public void imagesTest() throws InterruptedException {
        driver.get("https://training-support.net/selenium/LazyLoading");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + imageElements.size());
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollTextIntoView(\"helen\")"));

        Thread.sleep(2000);
       // driver.findElement(
          //     new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
              //         + ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + "Helen" + "\").instance(0))"));




        System.out.println("After scroll: " + imageElements.size());
        Assert.assertEquals(imageElements.size(), 5);
    }
}
