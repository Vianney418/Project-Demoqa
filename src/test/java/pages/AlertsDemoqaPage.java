package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.SeleniumUtility;

public class AlertsDemoqaPage extends SeleniumUtility {
    @FindBy (xpath = "//div[@class='card mt-4 top-card'][contains(.,'Alerts, Frame & Windows')]")
    WebElement cardAlertsFrameWindows;
    @FindBy (xpath = "//li[@class='btn btn-light '][contains(.,'Alerts')]")
    WebElement alertsBtn;
    @FindBy (id = "alertButton")
    WebElement alertButton;
    @FindBy (id = "confirmButton")
    WebElement confirmButtom;
    @FindBy (id = "confirmResult")
    WebElement txtConfirmResult;

    public void cardAlertsFrameWindows(){
        scrollToElementOnVariableHeight(cardAlertsFrameWindows);
        cardAlertsFrameWindows.click();
    }

    public void goToAlerts() {
        alertsBtn.click();
    }

    public void alertButton() {
        scrollToElementOnVariableHeight(alertButton);
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String acceptConfirmButtom(){
        confirmButtom.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
        return alertText;
    }

    public String validateTextSelect(){
        return txtConfirmResult.getText();
    }

    public void cancelConfirmButtom(){
        confirmButtom.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
    }


}
