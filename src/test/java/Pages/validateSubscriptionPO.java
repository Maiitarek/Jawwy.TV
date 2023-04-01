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
    String videoQ ="//div[contains(text(),'Video Qual')]/following::div[@Var]";
    String deviceAccess="//div[contains(text(),'Device Access')]/following::div[@Var]";
    String rewindCont="//div[contains(text(),'Rewind Con')]/following::div[@Var]";




}
