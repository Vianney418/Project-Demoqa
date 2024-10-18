package util;

import drivers.WebDrivers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumUtility {
    public WebDriver driver = null;
    protected WebDriverWait wait;
    WebDrivers webDrivers;
    protected Actions actions;

    public SeleniumUtility() {
        webDrivers = new WebDrivers();

        driver = webDrivers.createAndGetDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    protected void scrollToElementOnVariableHeight(WebElement element) {
        try {
            // Obtener la ubicación del elemento
            int elementPosition = element.getLocation().getY();

            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                // Hacer scroll hasta la ubicación del elemento
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + elementPosition + ");");
                Thread.sleep(2000);

                // Obtener la nueva altura del documento
                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

                // Verificar si el elemento está en la vista
                boolean isElementInView = (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "var element = arguments[0];" +
                                "var rect = element.getBoundingClientRect();" +
                                "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",
                        element
                );

                if (isElementInView) {
                    break;
                }

                // Verificar si la altura del documento ha cambiado (para evitar bucles infinitos)
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchToNewTab() {
        // Guardar el identificador de la pestaña original
        String originalWindow = driver.getWindowHandle();

        // Esperar hasta que haya más de una pestaña abierta
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Obtener todas las pestañas abiertas
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                // Cambiar el foco a la nueva pestaña
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closeNewTabAndSwitchBack() {
        // Guardar el identificador de la pestaña original
        String originalWindow = driver.getWindowHandle();

        // Obtener todas las pestañas abiertas
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                // Cambiar el foco a la nueva pestaña
                driver.switchTo().window(windowHandle);

                // Cerrar la nueva pestaña
                driver.close();

                // Volver el foco a la pestaña original
                driver.switchTo().window(originalWindow);
                break;
            }
        }
    }

}
