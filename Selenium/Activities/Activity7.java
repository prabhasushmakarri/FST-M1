package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity7 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());
        Actions builder = new Actions(driver);
        WebElement ball=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drpzone1=driver.findElement(By.xpath("//*[@id='droppable']"));
        WebElement drpzone2=driver.findElement(By.xpath("//*[@id='dropzone2']"));
        builder.clickAndHold(ball).moveToElement(drpzone1).release().perform();
        String Zone1= ball.getCssValue("left");
        System.out.println(Zone1);
       if(Zone1.equals("-434px")){
           System.out.println("Ball moved to Zone1");
           builder.clickAndHold(ball).moveToElement(drpzone2).release().pause(1000).perform();
           String Zone2= ball.getCssValue("left");
           if(Zone2.equals("434px")){
               System.out.println("Ball moved to Zone2");
           }
       }
       driver.quit();
    }
}
