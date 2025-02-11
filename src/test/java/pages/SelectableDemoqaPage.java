package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.SeleniumUtility;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SelectableDemoqaPage extends SeleniumUtility {
    @FindBy(xpath = "//div[contains(@class, 'top-card')]//h5[text()='Interactions']")
    WebElement cardInteractions;
    @FindBy(xpath = "//li[contains(.,'Selectable')]")
    WebElement selectableBtn;
    @FindBy(css = "#demo-tabpane-list ul.vertical-list-container > li")
    private List<WebElement> tabpaneList;
    @FindBy(xpath = "Dapibus ac facilisis in")
    WebElement btnForScroll;



    public void navigatedToSectable(){
        scrollToElementOnVariableHeight(cardInteractions);
        cardInteractions.click();
        scrollToElementOnVariableHeight(selectableBtn);
        selectableBtn.click();
    }

    private List<String> getTabpaneList(){
        return tabpaneList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getElementFromListByText(String text){
        scrollToElementOnVariableHeight(selectableBtn);
        return tabpaneList.stream()
                        .filter(elemet -> elemet.getText().trim().equals(text))
                                .findFirst()
                                        .orElseThrow(() -> new NoSuchElementException("No se encontro el elemento con testo" + text));




    }



}
