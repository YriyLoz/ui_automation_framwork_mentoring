package com.hm.ui_automation_framwork_mentoring;

import pages.MainPage;
import org.testng.annotations.*;

public class MainPageTest extends BaseTest {
    @Test
    public void search() {

        new MainPage(driver).searchProduct("sadas");
    }

}
