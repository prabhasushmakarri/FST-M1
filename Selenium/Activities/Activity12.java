package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {

    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement txtbox=driver.findElement(By.id("input-text"));
        WebElement toggleinput=driver.findElement(By.id("toggleInput"));
        if(txtbox.isEnabled()){
            System.out.println("Textbox is enabled");
        }
        else{
            toggleinput.click();
            System.out.println("Is textbox enabled:"+txtbox.isEnabled());
        }

     driver.quit();

    }
}
