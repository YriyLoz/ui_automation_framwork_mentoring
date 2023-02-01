package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected String APP_URL = "https://www2.hm.com/en_gb/index.html";
    protected WebDriver webDriver;

    @FindBy(css = "div.Header-module--logo__uvR9z")
    protected WebElement headerLogo;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
