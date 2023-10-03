package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver =new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@name='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@class='ui button']")).click();
        driver.quit();
    }
}
