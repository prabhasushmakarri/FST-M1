package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {

    public void selectcheckbox(WebElement chk){
       chk.click();
    }
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Activity10 obj=new Activity10();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        //check box pat
        WebElement chk=driver.findElement(By.xpath("//*[@type='checkbox']"));
        //check if the check box is visible
         if(chk.isDisplayed()){
             System.out.println("checkbox is displayed");
             //If visible calling function to select chkbox
             obj.selectcheckbox(chk);
         }
         //for click of remove checkbox
        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.invisibilityOf(chk));
        //again click on add checkbox
        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOf(chk));
        System.out.println("Is check box displayed:"+chk.isDisplayed());
        //selecting the check box
        obj.selectcheckbox(chk);
        driver.quit();

    }
}
