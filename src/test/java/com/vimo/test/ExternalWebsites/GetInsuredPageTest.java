package com.vimo.test.ExternalWebsites;

import com.vimo.base.BaseClass;
import com.vimo.pages.Home.HomePage;
import com.vimo.pages.ExternalWebsites.GetInsuredPage;
import com.vimo.Utilities.TabUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetInsuredPageTest extends BaseClass {

    @Test
    public void verifyGetInsuredPageInNewTab() {

        HomePage homePage = new HomePage();
        homePage.clickGetInsured();

        String parentTab = TabUtils.switchToNewTab(BaseClass.getDriver(), 10);
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());
        GetInsuredPage getInsuredPage = new GetInsuredPage();
        Assert.assertTrue(
                getInsuredPage.isPageOpened(),
                "GetInsured website did not open in new tab"
        );

        getDriver().close();
        getDriver().switchTo().window(parentTab);
    }
}