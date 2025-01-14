package runners;

import drivers.WebDrivers;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepDefinitions",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/", "json:target/cucumber.json", "html:target/cucumber-reports.html"},
        monochrome = true,
        publish = true,
        tags =  "@AlertsDemoqa or @ElementsDemoqa or @AlertFrameWindowsDemoqa"
)


public class ParallelRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {return  super.scenarios();}

    @AfterSuite
    public void tearDownSuite() {
        WebDrivers.quitAllDrivers();
    }

}
