package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity3 {
    AppiumDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //set the appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);

    }
    @Test
    public void additionTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result= driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        //System.out.println(result);
        assertEquals(result,"14");
    }
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result= driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        //System.out.println(result);
        assertEquals(result,"500");
    }
    @Test
    public void divideTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_div")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result= driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        //System.out.println(result);
        assertEquals(result,"25");
    }
    @Test
    public void subtractionTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        String result= driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        //System.out.println(result);
        assertEquals(result,"5");
    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }
}
