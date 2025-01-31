package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.SeleniumUtility;

public class InteractionsDemoqaPage extends SeleniumUtility {

    @FindBy(xpath = "//div[contains(@class, 'top-card')]//h5[text()='Interactions']")
    WebElement cardInteractions;
    @FindBy(xpath = "//li[@class='btn btn-light '][contains(.,'Sortable')]")
    WebElement sortableBtn;
    @FindBy(xpath = "(//div[contains(.,'One')])[10]")
    WebElement btnOne;
    @FindBy(xpath = "(//div[contains(.,'Three')])[10]")
    WebElement btnthree;


    public void navigateToSortable() {
        scrollToElementOnVariableHeight(cardInteractions);
        cardInteractions.click();
        scrollToElementOnVariableHeight(sortableBtn);
        sortableBtn.click();

    }

    public void clickAndHold() {
        scrollToElementOnVariableHeight(btnOne);
        actions.clickAndHold(btnOne)
                .moveToElement(btnthree)
                .release()
                .build()
                .perform();
       // verifyElementMoved();


    }

    /*public void verifyElementMoved() {
        String newPositionText = btnthree.getCssValue(String.valueOf(btnthree));
        Assert.assertEquals(newPositionText, "One", "El elemento 'One' no se movió a la posición correcta.");
    }*/
}