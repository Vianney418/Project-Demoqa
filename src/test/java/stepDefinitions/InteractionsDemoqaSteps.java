package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;
import pages.InteractionsDemoqaPage;

public class InteractionsDemoqaSteps {

    InteractionsDemoqaPage interactionsDemoqaPage = new InteractionsDemoqaPage();

    @When("the user goes to Interaction and Sortable")
    public void navigateToSortable() {
        interactionsDemoqaPage.navigateToSortable();
    }

    @And("the user must move the One three squares down and the Six five squares up")
    public void clickAndHold() {
        interactionsDemoqaPage.clickAndHold();
    }

    /*@Then("the user should see the following text")
    public void validationTxt() {
        interactionsDemoqaPage.verifyElementMoved();
    }*/
}
