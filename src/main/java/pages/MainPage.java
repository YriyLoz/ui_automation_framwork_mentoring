package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(css = "div.Header-module--logo__uvR9z")
    protected WebElement headerLogo;
    @FindAll(@FindBy(css = ".CTA-module--action__AdoYs.CTA-module--large__P5b7N"))
    protected List<WebElement> elements;
    @FindBy(css = "input.BaseInput-module--input__TeCcB")
    protected WebElement searchField;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(APP_URL);
    }

    @Step("Press navigation button {0} ")
    public void pressNavigationButton(String button) {
        elements.stream()
                .filter(webElement -> webElement.getText().equalsIgnoreCase(button))
                .findAny().orElse(null).click();
    }

    public void searchProduct(String productName) {
        searchField.click();
        searchField.sendKeys("hi");
        searchField.sendKeys(productName);
        searchField.submit();
    }
}
