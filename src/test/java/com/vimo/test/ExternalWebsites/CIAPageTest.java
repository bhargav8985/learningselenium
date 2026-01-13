package com.vimo.test.ExternalWebsites;

import com.vimo.base.BaseClass;
import com.vimo.pages.Home.HomePage;
import com.vimo.pages.ExternalWebsites.CIAPage;
import com.vimo.Utilities.TabUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CIAPageTest extends BaseClass {

    @Test
    public void verifyCIAPageInNewTab() {

        HomePage homePage = new HomePage();
        homePage.clickCIAPage();

        String parentTab = TabUtils.switchToNewTab(BaseClass.getDriver(), 10);
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());
        CIAPage ciaPage = new CIAPage();
        Assert.assertTrue(
                ciaPage.isPageOpened(),
                "GetInsured website did not open in new tab"
        );

        getDriver().close();
        getDriver().switchTo().window(parentTab);
    }
}