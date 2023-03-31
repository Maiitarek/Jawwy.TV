package Pages;

import StepDefinitions.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class validateSubscriptionPO extends Base {

public validateSubscriptionPO()
    {
        driver = Base.driver;
    };

    WebElement selectCountry = driver.findElement(By.id("country-name"));
    WebElement Egypt = driver.findElement(By.id("eg-contry-lable"));
    WebElement UAE = driver.findElement(By.id("ae-contry-lable"));
    WebElement Lebanon = driver.findElement(By.id("lb-contry-lable"));
    String pk = "@Var";
    String curr = "//div[@id='@Var1']/child::i";
    String pr = "//div[@id='@Var2']/child::b";
//    WebElement priceLite = driver.findElement(By.xpath("//div[@id='currency-lite']/child::b"));
//    WebElement priceClassic = driver.findElement(By.xpath("//div[@id='currency-classic']/child::b"));
//    WebElement pricePrem = driver.findElement(By.xpath("//div[@id='currency-premium']/child::b"));


}
