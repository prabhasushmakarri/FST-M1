package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Appiumprjactivity1 {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();


        //set the appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @DataProvider(name = "Taktobeadd")
    public static Object[][] credentials() {
        return new Object[][] { {"Complete Activity with Google Tasks"},{"Complete Activity with Google Keep"},
                {"Complete the second Activity Google Keep"}

        };
    }

    @Test(dataProvider = "Taktobeadd")
    public void createlistTest(String task) throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(2000);
        //checking task is created or not
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc='"+task+"']/android.view.ViewGroup/android.widget.TextView")).isDisplayed());
    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }

}
