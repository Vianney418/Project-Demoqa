package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SelectableDemoqaPage;

import java.util.List;

public class SelectableDemoqaSteps {
    SelectableDemoqaPage selectableDemoqaPage = new SelectableDemoqaPage();

    @When("the user goes to Interaction and Selectable")
    public void navigatedToSectable(){selectableDemoqaPage.navigatedToSectable();}

    @And("the user will select an items:")
    public void getElementFromListByText(DataTable dataTable){
        List<String> texts = dataTable.asList(String.class);
        texts.forEach(text ->{
            selectableDemoqaPage.getElementFromListByText(text).click();
        });
   }
}
