package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

        //set the appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Test
    public void contactappTest() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.android.contacts:id/floating_action_button")).click();
        driver.findElement(AppiumBy.xpath("//*[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//*[@text='Last name']")).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath("//*[@text='Phone']")).sendKeys("999148292");
        driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.contacts:id/large_title")));
        String text=driver.findElement(AppiumBy.id("com.android.contacts:id/large_title")).getText();
        System.out.println(text);
        Assert.assertEquals("Aaditya Varma",text);

    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }


    }
