package com.vimo.pages.ChildcareExchange;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;


public class ChildCareExchangeResources {

    final By ChildCareExchangeResourcesh1 = By.xpath("//h1[contains(text(),'Implementing a Child Care')]");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("child-care-exchange-ccx/child-care-exchange-resources-ccx/")
                &&
                BaseClass.getActionDriver().isDisplayed(ChildCareExchangeResourcesh1);
    }
}
