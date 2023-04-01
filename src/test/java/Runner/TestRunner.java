package Runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/"},
        plugin = {"pretty","io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"StepDefinitions"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass(ITestContext context) {

    }
}