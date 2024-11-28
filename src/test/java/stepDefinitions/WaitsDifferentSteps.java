package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.WaitsDifferentPage;

public class WaitsDifferentSteps {
    WaitsDifferentPage waitsDifferentPage = new WaitsDifferentPage();

    @Given("user visits Dinamically Loaded Page Elements {string}")
    public void starBrowser(String url) {waitsDifferentPage.starBrowser(url);}
    @When("the user on click in the button Star")
    public void clickBtnStart() {waitsDifferentPage.clickBtnStart();}
    @Then("the user should see the following text {string}")
            public void validationtext(String txtExpectedResult) {
        Assert.assertEquals(txtExpectedResult, waitsDifferentPage.validationText());
    }
}
