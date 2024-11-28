package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.SeleniumUtility;

public class WaitsDifferentPage extends SeleniumUtility {

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    WebElement btnStart;
    @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
    WebElement txtvalidate;

    public void starBrowser(String url) {driver.get(url);}
    public void clickBtnStart(){
        btnStart.click();
        waitUntilElementVisible(txtvalidate);
    }
    public String validationText(){
        return txtvalidate.getText();
    }
}
