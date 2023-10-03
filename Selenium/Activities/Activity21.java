package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println("Current tab: " + driver.getWindowHandle());
        //To print page title and heading
        System.out.println("Page title: " + driver.getTitle());
        //String pageHeading = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/text()")).getText();
        //System.out.println("Page Heading: " + pageHeading);
        driver.findElement(By.xpath("//*[@id='actionButton']")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switching window
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        // Wait for the new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());
       // pageHeading = driver.findElement(By.className("content")).getText();
       // System.out.println("Page Heading: " + pageHeading);



    }
}
