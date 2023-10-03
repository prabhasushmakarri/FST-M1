package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity17 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println(driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select singleSelect = new Select(dropdown);
        singleSelect.selectByVisibleText("Option 2");
        System.out.println("second option:"+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByIndex(3);
        System.out.println("Third option:"+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByValue("4");
        System.out.println("fourth option:"+singleSelect.getFirstSelectedOption().getText());
        List<WebElement> alloptions=singleSelect.getOptions();
        System.out.println("All the options");
        for(WebElement lst:alloptions){
            System.out.println(lst.getText());
            driver.quit();
        }

    }
}
