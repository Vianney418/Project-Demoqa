package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ElementsDemoqaPage;
import util.ConfigManager;

public class ElementsDemoqaSteps {
    ElementsDemoqaPage elementsDemoqaPage = new ElementsDemoqaPage();

    @Given("user visits Demoqa page")
    public void starBrowser() {
        String demoqaUrl = ConfigManager.getProperty("url.demoqa");
        elementsDemoqaPage.starBrowser(demoqaUrl);}
    @When("the user goes to Elements")
    public void userGoesElements() {elementsDemoqaPage.userGoesElements();}
    @And("the user clicks on Text Box")
    public void textBoxBtn() {elementsDemoqaPage.textBoxBtn();}
    @And("the user fills out the text box form with the following details:")
    public void textBoxForm(DataTable dataTable) {elementsDemoqaPage.textBoxForm(dataTable);}
    @And("the user clicks on Submit")
    public void submitBtn() {elementsDemoqaPage.submitBtn();}
    @Then("user will see the following message {string}")
    public void validateTxt(String txtResultadoEperado){
        Assert.assertEquals(txtResultadoEperado, elementsDemoqaPage.validateTxt());}
}
