package com.vimo.test.about;

import com.vimo.base.BaseClass;
import com.vimo.pages.About.AboutLeaderShip;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutLeaderShipTest extends BaseClass {

    @Test
    public void verifyHomeToAboutLeaderShipTransition() {
        //  Transition
        HomePage home = new HomePage();
        AboutLeaderShip aboutLeaderShip = home.clickAboutLeaderShip();
BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());
        Assert.assertTrue(aboutLeaderShip.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
