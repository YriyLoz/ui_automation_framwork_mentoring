package com.hm.ui_automation_framwork_mentoring;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import services.WebDriverService;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true, description = "Set up Browser")
    @Parameters("browser")
    public void startBrowser(@Optional("chrome") String browser) {
        driver = WebDriverService.startDriver(browser);
    }

    @AfterClass(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        WebDriverService.stopDriver();
    }

}
