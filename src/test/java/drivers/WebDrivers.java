package drivers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebDrivers {

    public static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<>();

    private static final Set<WebDriver> allDrivers = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private static final ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--enable-automation");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        allDrivers.add(webDriver);
        currentDriver.set(webDriver);
        return webDriver;
    });

    public WebDriver createAndGetDriver() {
        WebDriver webDriver = driver.get();
        currentDriver.set(webDriver);
        return webDriver;
    }

    public static void quitAllDrivers() {
        for (WebDriver webDriver : allDrivers) {
            try {
                if (webDriver != null) {
                    webDriver.quit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        allDrivers.clear();
    }

}
