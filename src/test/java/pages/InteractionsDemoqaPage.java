package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;
import util.SeleniumUtility;

import java.util.List;
import java.util.stream.Collectors;

public class InteractionsDemoqaPage extends SeleniumUtility {

    @FindBy(xpath = "//div[contains(@class, 'top-card')]//h5[text()='Interactions']")
    WebElement cardInteractions;
    @FindBy(xpath = "//li[@class='btn btn-light '][contains(.,'Sortable')]")
    WebElement sortableBtn;
    @FindBy(xpath = "(//div[contains(.,'One')])[10]")
    WebElement btnOne;
    @FindBy(xpath = "(//div[contains(.,'Three')])[10]")
    WebElement btnthree;
    @FindBy(css = "#demo-tabpane-list .list-group-item")
    List<WebElement> listOfNumber;


    @FindBy(id = "demo-tab-grid")
    WebElement gridBtn;
    @FindBy(css = ".create-grid .list-group-item")
    List<WebElement> gridOfNumber;
    @FindBy(xpath = "(//div[contains(.,'Two')])[14]")
    WebElement btnTwo;
    @FindBy(xpath = "(//div[contains(.,'Eight')])[11]")
    WebElement btnEight;


    public void navigateToSortable() {
        scrollToElementOnVariableHeight(cardInteractions);
        cardInteractions.click();
        scrollToElementOnVariableHeight(sortableBtn);
        sortableBtn.click();

    }

    public void testList(){
        System.out.println("listas encontradas" + listOfNumber.size());
        Assert.assertFalse(listOfNumber.isEmpty(), "No se encontratos listas");
    }


    public void clickAndHold() {

        List<String> itemsBefore = getListItems();
        System.out.println("Orden antes del cambio: " + itemsBefore);


        moveElement(btnOne,btnthree);

        List<String> itemsAfter = getListItems();
        System.out.println("Orden después del cambio: " + itemsAfter);


        boolean movedToThirdPosition =
                itemsBefore.indexOf("One") == 0 &&
                        itemsAfter.indexOf("One") == 2;

        Assert.assertTrue(movedToThirdPosition, "El elemento 'One' no se movió a la posición 3.");
    }

    private List<String> getListItems(){
        return listOfNumber.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public void changeSectionGrid() {
        gridBtn.click();
        System.out.println("cantidad de lementos encontrados " + gridOfNumber.size());

    }

    public void clickAndHoldElementGrid(){
        List<String> itemsBefore = getGridItems();
        System.out.println("Orden antes del cambio: " + itemsBefore);

        moveElement(btnTwo, btnEight);

        List<String> itemsAfter = getGridItems();
        System.out.println("Orden despues del cambio: " + itemsAfter);

        boolean movedToThirdPosition =
                itemsBefore.indexOf("Two") == 1 &&
                        itemsAfter.indexOf("Two") == 7;

        Assert.assertTrue(movedToThirdPosition, "El elemento 'Two' no se movió a la posición 8.");
    }

    private List<String> getGridItems(){
        return gridOfNumber.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}