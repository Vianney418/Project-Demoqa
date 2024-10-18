package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.SeleniumUtility;

import java.util.List;
import java.util.Map;

public class ElementsDemoqaPage extends SeleniumUtility {

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement userGoesElementsBoton;
    @FindBy(xpath = "//li[@class='btn btn-light '][contains(.,'Text Box')]")
    WebElement textBoxBtn;
    @FindBy(id = "userName")
    WebElement inputFullName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "currentAddress")
    WebElement inputCurrentAddress;
    @FindBy(id = "permanentAddress")
    WebElement inputPermanentAddres;
    @FindBy(id = "submit")
    WebElement submitBtn;
    @FindBy(xpath = "//p[@class='mb-1'][contains(.,'Name:Vianney Perdomo')]")
    WebElement txtContains;



    public void starBrowser(String url) {driver.get(url);}

    public void userGoesElements(){
        scrollToElementOnVariableHeight(userGoesElementsBoton);
        userGoesElementsBoton.click();

    }
    public void textBoxBtn(){
        textBoxBtn.click();
    }
    public void textBoxForm(DataTable dataTable){
        List<Map<String, String>> textBoxDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> details : textBoxDetails){
            //scrollToElementOnVariableHeight(inputPermanentAddres);
            inputFullName.sendKeys(details.get("Full Name"));
            inputEmail.sendKeys(details.get("Email"));
            inputCurrentAddress.sendKeys(details.get("Current Address"));
            inputPermanentAddres.sendKeys(details.get("Permanent Address"));
        }

    }
    public void submitBtn(){
        scrollToElementOnVariableHeight(submitBtn);
        submitBtn.click();
    }
    public String validateTxt(){
        return txtContains.getText();
    }



}
