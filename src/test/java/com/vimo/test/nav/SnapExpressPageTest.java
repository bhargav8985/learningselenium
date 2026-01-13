package com.vimo.test.nav;

import com.vimo.base.BaseClass;
import com.vimo.pages.Home.HomePage;
import com.vimo.pages.Navigation.SnapExpressPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SnapExpressPageTest extends BaseClass {

    @Test
    public void verifyHomeToSnapExpressTransition() {
        //  Transition
        HomePage home = new HomePage();
        SnapExpressPage snapExpressPage = home.clickSnapExpress();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(snapExpressPage.isLoaded(),
                "Failed to navigate from Home page to Snap Express page");
    }

}
