package util;

import drivers.WebDrivers;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class TakeScreenshot {

    public static void takeScreenshot(Scenario scenario) {
        try {
            WebDriver currentDriver = WebDrivers.currentDriver.get();
            if (currentDriver != null) {
                String screenshotName = "screenshot_" + UUID.randomUUID() + ".png";
                final byte[] screenshot = ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
