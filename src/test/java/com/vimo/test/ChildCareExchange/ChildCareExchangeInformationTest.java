package com.vimo.test.ChildCareExchange;

import com.vimo.base.BaseClass;
import com.vimo.pages.ChildcareExchange.ChildCareExchangeInformation;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChildCareExchangeInformationTest extends BaseClass {
    @Test
    public void verifyHomeToChildCareExchangeTransition() {
        //  Transition
        HomePage home = new HomePage();
        ChildCareExchangeInformation childCareExchangeInformation = home.clickChildCareExchange();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(childCareExchangeInformation.isLoadedforChildCareExchange(),
                "Failed to navigate from Home page to Medicaid Express page");
    }

    @Test
    public void verifyHomeToChildCareExchangeInformationTransition() {
        HomePage home = new HomePage();
        ChildCareExchangeInformation childCareExchangeInformation = home.clickChildCareExchangeInformation();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(childCareExchangeInformation.isLoadedforChildCareExchangeInformation(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
