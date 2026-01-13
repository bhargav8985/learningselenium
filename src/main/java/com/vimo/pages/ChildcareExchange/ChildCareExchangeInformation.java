package com.vimo.pages.ChildcareExchange;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;

public class ChildCareExchangeInformation {

    final By ChildCareExchangeh1 = By.xpath("//h1[contains(text(),'Reimagine Child Care')]\n");

    public boolean isLoadedforChildCareExchange() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("child-care-exchange-ccx/")
                &&
                BaseClass.getActionDriver().isDisplayed(ChildCareExchangeh1);
    }

    public boolean isLoadedforChildCareExchangeInformation() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("child-care-exchange-ccx/")
                &&
                BaseClass.getActionDriver().isDisplayed(ChildCareExchangeh1);
    }
}
