package com.vimo.test.nav;

import com.vimo.base.BaseClass;
import com.vimo.pages.Home.HomePage;
import com.vimo.pages.Navigation.HrPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HrPageTest extends BaseClass {

    @Test
    public void verifyHomeToHrPageTransition() {
        //  Transition
        HomePage home = new HomePage();
        HrPage hrPage = home.clickHr();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(hrPage.isLoaded(),
                "Failed to navigate from Home page to H.R page");
    }
}
