package com.vimo.test.nav;

import com.vimo.base.BaseClass;
import com.vimo.pages.Home.HomePage;
import com.vimo.pages.Navigation.MedicaidExpressPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MedicaidExpressPageTest extends BaseClass {

    @Test
    public void verifyHomeToMedicaidExpressTransition() {
        //  Transition
        HomePage home = new HomePage();
        MedicaidExpressPage medicaidExpressPage = home.clickMedicaidExpress();
        BaseClass.logger.info("Current URL: " + BaseClass.getDriver().getCurrentUrl());

        Assert.assertTrue(medicaidExpressPage.isLoaded(),
                "Failed to navigate from Home page to Medicaid Express page");
    }
}
