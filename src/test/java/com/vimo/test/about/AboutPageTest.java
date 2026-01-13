package com.vimo.test.about;

import com.vimo.base.BaseClass;
import com.vimo.pages.About.AboutPage;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutPageTest extends BaseClass {

    @Test
    public void verifyHomeToAboutTransition() {
        //  Transition
        HomePage home = new HomePage();
        AboutPage aboutPage = home.clickAbout();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(aboutPage.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
