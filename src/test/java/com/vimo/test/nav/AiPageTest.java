package com.vimo.test.nav;

import com.vimo.base.BaseClass;
import com.vimo.pages.Navigation.AiPage;
import com.vimo.pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AiPageTest extends BaseClass {
    HomePage home = new HomePage();

    @Test
    public void verifyHomeToAITransition() {
        //  Transition
        AiPage aiPage = home.clickNavAi();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(aiPage.isLoaded(),
                "Failed to navigate from Home page to AI page");
    }

}
