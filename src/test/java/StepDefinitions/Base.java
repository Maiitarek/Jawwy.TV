package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class Base {


    public static WebDriver driver;
    public static  WebDriver getDriver(){
        return driver;
    };

    @Before(order = 1)
    public void setupApplication(){


        Reporter.log("=====Browser Session Started=====", true);

        System.setProperty("webdriver.chrome.driver","./Tools\\chromedriver.exe");



        driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("https://subscribe.stctv.com/");

        Reporter.log("=====Application Started=====", true);

    }

    @Before(order = 2)
    public void convertToEnglish(){
        driver.findElement(By.xpath("//a[@id='translation-btn']")).click();
    }


    @After
    public void closeApplication()
    {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);

    }
}
