package com.vimo.test.about;

import com.vimo.base.BaseClass;
import com.vimo.pages.About.AboutNewsroom;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutNewsroomTest extends BaseClass {

    @Test
    public void verifyHomeToAboutNewsroomTransition() {
        //  Transition
        HomePage home = new HomePage();
        AboutNewsroom aboutNewsroom = home.clickAboutNewsroom();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(aboutNewsroom.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
