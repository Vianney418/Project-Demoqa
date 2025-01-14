package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TableCyclePage;

public class TableCycleSteps {
    TableCyclePage tableCyclePage = new TableCyclePage();

    @Given("the user visits W3School Page {string}")
    public void starBrowser(String url) {tableCyclePage.starBrowser(url);}
    @When("the user look that country is in the table")
    public void verificarUbicacionPais(){tableCyclePage.verificarUbicacionPais("Country");}
    @Then("the user verifies that Germany is in the table")
    public void imprimirelementos(){tableCyclePage.verificarPais("germany");}
}
