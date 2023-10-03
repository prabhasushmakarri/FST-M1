package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");

    }
    @Test
    public void gettitle(){
        String title=driver.getTitle();
        System.out.println("Title of the page:"+title);
        Assert.assertEquals(title,"Training Support");
        driver.findElement(By.linkText("About Us")).click();
        String newpagetitle=driver.getTitle();
        System.out.println("Title of new page:"+newpagetitle);
        Assert.assertEquals("About Training Support",newpagetitle);
    }
    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }

}
