package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
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
    public void test() throws InterruptedException {
        driver.get("https://training-support.net/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Training Support']")));
        System.out.println("page heading:"+ driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText());
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='About Us']")));
        System.out.println("New page heading:"+driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText());
    }
}
