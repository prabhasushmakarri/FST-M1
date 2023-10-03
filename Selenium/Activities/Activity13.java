package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity13 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());
        List<WebElement> rows=driver.findElements(By.xpath("//*[@class='ui celled striped table']/tbody/tr"));
        System.out.println("No of rows:"+rows.size());
        List<WebElement> cols=driver.findElements(By.xpath("//*[@class='ui celled striped table']/tbody/tr/td"));
        System.out.println("No of columns:"+cols.size());
        List<WebElement> thirdrow=driver.findElements(By.xpath("//*[@class='ui celled striped table']/tbody/tr[3]/td"));
        System.out.println("All the cell values in third row:");
        for(WebElement cell:thirdrow){
            System.out.println(cell.getText());
        }
        WebElement secondrow2col=driver.findElement(By.xpath("//*[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println("second row second column value:"+secondrow2col.getText());
        driver.quit();


    }
}
