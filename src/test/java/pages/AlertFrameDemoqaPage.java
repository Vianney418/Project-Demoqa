package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.SeleniumUtility;

public class AlertFrameDemoqaPage extends SeleniumUtility {
    @FindBy (xpath = "//div[@class='header-wrapper'][contains(.,'Alerts, Frame & Windows')]")
    WebElement alertsFrameBtn;
    @FindBy (xpath = "//li[@class='btn btn-light '][contains(.,'Browser Windows')]")
    WebElement browserWindowsBtn;
    @FindBy (id = "tabButton")
    WebElement tabButton;
    @FindBy (id = "sampleHeading")
    WebElement txtValidation;
    @FindBy (xpath = "//h1[@class='text-center'][contains(.,'Browser Windows')]")
    WebElement txtValidation2;

    public void alertsFrameBtn(){
        scrollToElementOnVariableHeight(alertsFrameBtn);
        alertsFrameBtn.click();
        browserWindowsBtn.click();
    }
    public String newTabBtn(){
        tabButton.click();
        switchToNewTab();
        return txtValidation.getText();

    }

    public void closedWindowsHandle(){
        switchToNewTab();
        closeNewTabAndSwitchBack();
    }

    public String txtValidation(){
        return txtValidation2.getText();
    }


}
