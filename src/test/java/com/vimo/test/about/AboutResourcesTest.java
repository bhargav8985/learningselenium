package com.vimo.test.about;

import com.vimo.base.BaseClass;
import com.vimo.pages.About.AboutResources;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutResourcesTest extends BaseClass {

    @Test
    public void verifyHomeToAboutResourcesTransition() {
        //  Transition
        HomePage home = new HomePage();
        AboutResources aboutResources = home.clickAboutResources();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(aboutResources.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
