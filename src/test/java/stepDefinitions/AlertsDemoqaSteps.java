package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AlertsDemoqaPage;

public class AlertsDemoqaSteps {
    AlertsDemoqaPage alertsDemoqaPage = new AlertsDemoqaPage();

    @And("the user goes to Alerts, Frame & Windows")
    public void cardAlertsFrameWindows() {alertsDemoqaPage.cardAlertsFrameWindows();}
    @And("the user clicks on Alerts")
    public void goToAlerts() {alertsDemoqaPage.goToAlerts();}
    @And("the user click button to see alert and he clicks in aceptar")
    public void alertButton() {alertsDemoqaPage.alertButton();}
    @And("the user on button click, confirm box will appear and Aceptar")
    public void acceptConfirmButtom() {
        String alertText = alertsDemoqaPage.acceptConfirmButtom();
        System.out.println("Texto de la alerta es: " + alertText);
        assert alertText.equals("Do you confirm action?");
    }
    @Then("the user should see {string}")
    public void validateTextSelect(String txtResultadoEsperado) {
        Assert.assertEquals(txtResultadoEsperado, alertsDemoqaPage.validateTextSelect());
    }

    @And("the user on button click, confirm box will appear and Cancelar")
    public void cancelConfirmButtom() {alertsDemoqaPage.cancelConfirmButtom();}

}
