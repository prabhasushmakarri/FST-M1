package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Appiumprjactivity3 {
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
        // driver.get("https://v1.training-support.net/selenium");
    }
    @Test(priority = 0)
    public void opentaskpage() throws InterruptedException {
        driver.get("https://v1.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@index='2']/android.view.View[@index='14']")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@index='2']/android.view.View[@index='14']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@index='0']")));

    }
    @DataProvider(name = "Taktobeadd")
    public static Object[][] credentials() {
        return new Object[][] { {"Add tasks to list"},{"Get number of tasks"},
                {"Clear the list"}

        };
    }
    @Test(priority = 1,dataProvider = "Taktobeadd")
    public void addtask(String task) throws InterruptedException {
        //sending keys to addtask textbox
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys(task);
        Thread.sleep(1000);
        //To click on add task
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='1']")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    public void strikeandclear() throws InterruptedException {
        int temp=0;
        List<WebElement> addedtasklist=driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View"));
             for(WebElement i:addedtasklist) {
                 if (temp == 0) {
                     temp = 1;

                 } else {
                     i.click();
                     Thread.sleep(2000);
                 }

             }
             //Clear the list
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View[@index='2']")).click();
             Thread.sleep(2000);
        boolean list=driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View")).isEmpty();
        Assert.assertTrue(list);
    }
}
