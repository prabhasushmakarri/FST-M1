package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class projectselenium {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeGroups(groups = {"activity1","activity2","activity3","activity4","activity6","activity7"})
    public void setup(){
        WebDriverManager.firefoxdriver();
        driver=new FirefoxDriver();
driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/");

        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Test(priority = 0,groups = {"activity1"})
    public void verifytitle() throws InterruptedException {
        String pageTitle=driver.getTitle();
        Assert.assertEquals(pageTitle,"Alchemy Jobs – Job Board Application");
        Thread.sleep(6000);

    }
    @Test(priority = 1,groups = {"activity2"})
    public void verifywebsiteheading(){
        String heading=driver.findElement(By.className("entry-title")).getText();
        Assert.assertEquals(heading,"Welcome to Alchemy Jobs");
    }
    @Test(priority = 2,groups = {"activity3"})
    public void printimageurl(){
        String imgurl=driver.findElement(By.xpath("//*[@class='attachment-large size-large wp-post-image']")).getAttribute("src");
        System.out.println("URL of image is:"+imgurl);
    }
    @Test(priority=3,groups = {"activity4"})
    public void secondheading(){
        String secondheading=driver.findElement(By.xpath("//*[@id='post-16']/div/h2")).getText();
        Assert.assertEquals(secondheading,"Quia quis non");

    }
    @Test(priority = 4,groups = {"activity5","activity6"})
    public void navigatejobspage() throws InterruptedException {
        driver.findElement(By.linkText("Jobs")).click();
        wait.until(ExpectedConditions.titleIs("Jobs – Alchemy Jobs"));
       // Thread.sleep(8000);
        String pageTitle=driver.getTitle();
       // Thread.sleep(5000);
        Assert.assertEquals(pageTitle,"Jobs – Alchemy Jobs");
    }

    @Test(priority=5,groups = {"activity6"})
    public void searchandapplyjob() throws InterruptedException {
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//*[@value='Search Jobs']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='job_listings']/li[1]/a")));
         WebElement ele= driver.findElement(By.xpath("//*[@class='job_listings']/li[1]/a"));
         ele.click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Apply for job']")));
         driver.findElement(By.xpath("//*[@value='Apply for job']")).click();
         String value=driver.findElement(By.xpath("//*[@class='application_details']/p/a")).getText();
         Assert.assertEquals(value,"abhiram@cklabs.com");
    }
    @Test(priority=6,groups={"activity7"})
    public void createnewjob() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.linkText("Post a Job")).click();
        driver.findElement(By.id("create_account_email")).sendKeys("testin@gmail12.com");
        driver.findElement(By.id("job_title")).sendKeys("Tester Job");
        driver.findElement(By.id("job_location")).sendKeys("India");
        WebElement drp=driver.findElement(By.id("job_type"));
        Select drpvalue=new Select(drp);
        drpvalue.selectByValue("3");
        js.executeScript("window.scrollBy(0,650)", "");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@data-id='job_description']")).click();
        driver.findElement(By.xpath("//*[@data-id='job_description']")).sendKeys("sushma");
        driver.switchTo().parentFrame();
        js.executeScript("window.scrollBy(650,900)", "");
        driver.findElement(By.id("application")).sendKeys("sushma@gmail12.com");
        driver.findElement(By.id("company_name")).sendKeys("Testt company");
        driver.findElement(By.id("company_website")).sendKeys("http://www.djdks.com");
        driver.findElement(By.id("company_tagline")).sendKeys("Test tagline");
        driver.findElement(By.id("company_video")).sendKeys("www.youtube.com");
        driver.findElement(By.id("company_twitter")).sendKeys("www.youtube.com");
        js.executeScript("window.scrollBy(900,1000)", "");
        driver.findElement(By.id("company_logo")).sendKeys("C:\\Users\\07194J744\\Downloads\\testimg.png");
        driver.findElement(By.name("submit_job")).click();
        driver.findElement(By.id("job_preview_submit_button")).click();
        Thread.sleep(8000);
        driver.findElement(By.linkText("Jobs")).click();
    }
    @Test(priority=7,groups = {"activity7"})
    public void searchforcreatedjob() throws InterruptedException {
        boolean job=false;
        driver.findElement(By.id("search_keywords")).sendKeys("Tester Job");
        driver.findElement(By.xpath("//*[@value='Search Jobs']")).click();
        Thread.sleep(6000);
        // WebElement ele= driver.findElement(By.xpath("//*[@class='job_listings']/li[1]/a"));

        List<WebElement> ele=driver.findElements(By.xpath("//*[@class='job_listings']/li/a/div/h3"));
        for(WebElement el:ele){
           if(el.getText().equals("Tester Job")){
               job=true;
           }
        }
        Assert.assertTrue(job);
    }
@Test(priority = 8,groups={"activity8"})
public void logintosite(){
    driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    driver.findElement(By.id("user_login")).sendKeys("root");
    driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("wp-submit")).click();
    wait.until(ExpectedConditions.titleIs("Dashboard ‹ Alchemy Jobs — WordPress"));
    Assert.assertEquals(driver.getTitle(),"Dashboard ‹ Alchemy Jobs — WordPress");
}




    @AfterGroups(alwaysRun = true)
    public void closebrowser(){
        driver.quit();
    }
}
