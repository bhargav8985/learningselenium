package com.vimo.test.ChildCareExchange;

import com.vimo.base.BaseClass;
import com.vimo.pages.ChildcareExchange.ChildCareExchangeResources;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChildCareExchangeResourcesTest extends BaseClass {

    @Test
    public void verifyHomeToChildCareExchangeResourcesTransition() {
        //  Transition
        HomePage home = new HomePage();
        ChildCareExchangeResources childCareExchangeResources = home.clickChildCareExchangeResources();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(childCareExchangeResources.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }

}
