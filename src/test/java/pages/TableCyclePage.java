package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.SeleniumUtility;

import java.util.List;

public class TableCyclePage extends SeleniumUtility {

    public void starBrowser(String url) {
        driver.get(url);
    }

    @FindBy(css = "table#customers > tbody > tr")
    List<WebElement> filas;


    public void verificarUbicacionPais(String pais) {


       // List<WebElement> top = filas.get(0).findElements(By.tagName("td"));

        boolean isGermanyFound = false;

        for (int i = 1; i < filas.size(); i++) {
            List<WebElement> cells = filas.get(i).findElements(By.tagName("td"));

            if (!cells.isEmpty() && cells.get(1).getText().equalsIgnoreCase(pais)) {
                isGermanyFound = true;
                break;
            }
        }
        if (isGermanyFound) {
            System.out.println("El pais " + pais + "esta presente en la columna `Country`");
        }else {
            System.out.println("El pais " + pais + " no esta presente en la columna `Country`");
        }
    }

    public void verificarPais(String pais) {
        boolean existe = filas.stream()
                .map(fila -> fila.findElements(By.cssSelector("td")))
                .anyMatch(columnas -> columnas.size() >= 2 && pais.equalsIgnoreCase(columnas.get(2).getText()));

        Assert.assertTrue(existe);
    }



}
