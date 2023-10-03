package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());
        //To find no of rows
        List<WebElement> rows=driver.findElements(By.xpath("//*[@id='sortableTable']/tbody/tr"));
        System.out.println("No of rows:"+rows.size());
        //To find no of columns
        List<WebElement> cols=driver.findElements(By.xpath("//*[@id='sortableTable']/tbody/tr/td"));
        System.out.println("No of columns:"+cols.size());
        //scond row second row second element
        WebElement secondrow2ndele=driver.findElement(By.xpath("//*[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("second row second colum value before sort:"+secondrow2ndele.getText());
        //sorting the table by clicking first row first column
        driver.findElement(By.xpath("//*[@id='sortableTable']/thead/tr[1]/th")).click();
        secondrow2ndele=driver.findElement(By.xpath("//*[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("second row second colum value after sort:"+secondrow2ndele.getText());
        //To print cell values of table last row
        List<WebElement> lastrows=driver.findElements(By.xpath("//*[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Values of last row");
        for(WebElement ele:lastrows){
            System.out.println(ele.getText());
        }
        driver.quit();

    }

}
