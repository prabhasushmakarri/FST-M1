package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver =new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//*[@id='third-header']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='ui two column very relaxed divided stackable grid']/div[1]/div[1]/h5")).getCssValue("color"));
        System.out.println(driver.findElement(By.xpath("//*[@class='ui violet button']")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("//*[@class='ui two column very relaxed divided stackable grid']/div[1]/div[2]/div[3]/button[2]")).getText());
        driver.quit();

    }
}
