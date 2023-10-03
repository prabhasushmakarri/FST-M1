package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());
        WebElement username=driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        WebElement password=driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        WebElement confirmpassword=driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        WebElement signup=driver.findElement(By.xpath("//button[text()='Sign Up']"));
        username.sendKeys("test");
        password.sendKeys("test");
        confirmpassword.sendKeys("test");
        email.sendKeys("test@gmail.com");
        signup.click();
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(loginMessage);
        driver.quit();
    }
}
