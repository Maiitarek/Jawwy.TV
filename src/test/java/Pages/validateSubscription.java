package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class validateSubscription extends validateSubscriptionPO{


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

    public void choosePackage(String pkg){

        //wait for element to be visiable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //replace the Var in xpath upon user selection of package type
        pk = pk.replace("@Var", pkg);
    }

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


}
