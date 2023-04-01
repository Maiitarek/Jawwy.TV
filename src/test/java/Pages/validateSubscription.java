package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class validateSubscription extends validateSubscriptionPO{


    @Test(priority = 0)
    @Step("Select Specific Country")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Select country button and pick country")
    public void selectCountry(String country){

        //click on the countries button
        selectCountry.click();
        //chooseCountry
        switch (country){

            case "Egypt":
                Egypt.click();
                System.out.println("Egypt is selected");
                break;
            case "UAE":
                UAE.click();
                System.out.println("UAE is selected");
                break;
            case "Lebanon":
                Lebanon.click();
                System.out.println("Lebanon is selected");
                break;
            default: System.out.println("Please select from the following :( Egypt, UAE, Lebanon )");
        }


    }

@Test(priority = 1)
    public void choosePackage(String pkg){

        //wait for element to be visiable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //replace the Var in xpath upon user selection of package type
        pk = pk.replace("@Var", pkg);
    }


    @Test(priority = 2)
    @Step("Scroll down to packages and verify currency for selected country")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that currency matches expected result")
    public void validateCurrency(String currency, String coin){


        //replace the Var in currency xpath upon user selection of country + package
        curr = curr.replace("@Var1",currency);
        //create a webelement of currency xpath
        WebElement element = driver.findElement(By.id(pk));
        //create a webelement of currency value
        WebElement element1 = driver.findElement(By.xpath(curr));
        System.out.println(element.getText());
        System.out.println(element1.getText());
        //check if expected currency value is equal to actual value
        assertTrue(element1.getText().contains(coin));
        System.out.println("Test Passed");
    }

    @Test(priority = 3)
    @Step("Validate the price for each package per country")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the price for each package per selected country")
    public void validatePrice(String price, String amount){

        //replace the Var in price xpath upon user selection on package + country
        pr = pr.replace("@Var2", price);
        //create a webelement with the xpath of price
        WebElement element = driver.findElement(By.xpath(pr));
        //get the value of price xpath
        String actual = element.getText();
        //check if the expected amount is equal to the actual amount
        assertEquals(amount, actual);
        System.out.println("Amount per month for package "+price+" is "+amount+".");
        System.out.println("Test Passed");

    }

    @Test(priority = 4)
    @Step("Validate packages content")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate packages content")
    public void validatePackageContent(String pkg, String video, String videoExp, String device, String devExp, String rewind, String rewExp){

        //determine which package passed from feature file
        choosePackage(pkg);
        //get the video quality xpath as per selected package
        videoQ = videoQ.replace("@Var",video);
        WebElement Evideo = driver.findElement(By.xpath(videoQ));

        //get the device access xpath quality as per selected package
        deviceAccess = deviceAccess.replace("@Var", device);
        WebElement Edevice = driver.findElement(By.xpath(deviceAccess));

        //get the rewind content xpath as per selected package
        rewindCont = rewindCont.replace("@Var", rewind);
        WebElement Erewind = driver.findElement(By.xpath(rewindCont));

///////////////Trace Expected vs Actual////////////////////////////

//        if (videoExp == Evideo.getText()){
//            System.out.println("Test Passed");
//        }
//        else{
//            System.out.println("expected "+videoExp+" but got"+Evideo.getAttribute("innerText"));
//        }
////////////////////////////////////////////////////////////////////

        //ASSERTIONS
        assertEquals(videoExp, Evideo.getAttribute("innerText"),"VideoQuality for "+pkg+" matched successfully");
        assertEquals(devExp, Edevice.getAttribute("innerText"),"Device access for "+pkg+" matched successfully");
        assertEquals(rewExp, Erewind.getAttribute("innerText"),"Rewind Content for "+pkg+" matched successfully");


    }


}
