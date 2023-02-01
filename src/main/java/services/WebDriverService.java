package services;

import com.google.common.base.Preconditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public final class WebDriverService {
    private static WebDriver driver;
    private static final String OS = System.getProperty("os.name").toLowerCase();

    private WebDriverService() {
    }

    public static WebDriver startDriver(String browser) {
        Preconditions.checkNotNull(browser, "Target browser parameter is null");
        if (driver != null) {
            return driver;
        }


        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                /*chromeOptions.addArguments("-headless");*/
                chromeOptions.addExtensions(new File("src/test/resources/browser_extension/CookiesExtension.crx"));
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                /*firefoxOptions.addArguments("-headless");*/
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "ie":
                if (!OS.startsWith("win")) throw new AssertionError(
                        "ie browser on supported on current OS " + OS);
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            case "htmlunit":
                driver = new HtmlUnitDriver();
                break;
            default:
                throw new AssertionError(browser + " not supported");
        }

        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
