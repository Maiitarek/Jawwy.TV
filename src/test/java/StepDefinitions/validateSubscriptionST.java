package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import Pages.validateSubscription;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validateSubscriptionST {
    Base setBr = new Base();
    validateSubscription picker = new Pages.validateSubscription();

    @Given("I navigated to Jawwy.TV URL")
    public void reachURL() {
        setBr.setupApplication();
    }

    @Given("I select {string}")
    public void selectCountry(String arg0) {
        picker.selectCountry(arg0);
    }



    @Then("{string} is shown as {string}")
    public void currencyIs(String arg0, String arg1) {

        picker.validateCurrency(arg0,arg1);

    }



    @And("{string} per month is {string}")
    public void perMonthIs(String arg0, String arg1) {

        picker.validatePrice(arg0, arg1);
    }

    @When("I scroll to {string}")
    public void iChoose(String arg0) {

        picker.choosePackage(arg0);
    }
}
