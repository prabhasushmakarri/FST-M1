package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println(driver.getTitle());
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(selectElement);
        multiSelect.selectByVisibleText("Javascript");
        for(int i = 4; i<=6 ; i++) {
            multiSelect.selectByIndex(i);
        }
        multiSelect.selectByValue("node");
        multiSelect.deselectByIndex(5);
        driver.quit();
    }
}
