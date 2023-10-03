package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver =new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("About Us")).click();
        System.out.println(driver.getTitle());
    }
}
