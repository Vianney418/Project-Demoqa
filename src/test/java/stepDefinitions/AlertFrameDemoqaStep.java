package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AlertFrameDemoqaPage;


public class AlertFrameDemoqaStep {

    AlertFrameDemoqaPage alertFrameDemoqaPage = new AlertFrameDemoqaPage();

    @And("the user clicks on Browser Windows")
    public void alertsFrameBtn() {alertFrameDemoqaPage.alertsFrameBtn();}
    @And("the user clicks on new tap")

    @Then("the user clicks on new tap and should see the text {string}")
    public void nombreInput(String txtResultadoEperado) {
        Assert.assertEquals(txtResultadoEperado, alertFrameDemoqaPage.newTabBtn());
    }
    @And("the user closes window handle")
    public void closedWindowsHandle(){alertFrameDemoqaPage.closedWindowsHandle();}

    @Then("The user returns to the browser page and should see the following text {string}")
    public void txtValidation(String txtResultadoEsperado1) {
        Assert.assertEquals(txtResultadoEsperado1, alertFrameDemoqaPage.txtValidation());
    }

}
