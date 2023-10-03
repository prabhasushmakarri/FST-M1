package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@class='ui violet button']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ajax-content']/h1")));
        String text1 = driver.findElement(By.xpath("//*[@id='ajax-content']/h1")).getText();
        System.out.println(text1);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='ajax-content']/h3"),"I'm late!"));
        String text2 = driver.findElement(By.xpath("//*[@id='ajax-content']/h3")).getText();
        System.out.println(text2);
        driver.quit();
    }
}
