package com.vimo.pages.ExternalWebsites;

import org.openqa.selenium.By;

import com.vimo.base.BaseClass;

public class GetInsuredPage {

    // Unique element on external website
   final private By getInsuredpageHeading = By.xpath("//b[normalize-space()='SaaS']");

    public boolean isPageOpened() {
        BaseClass.getActionDriver().waitForUrlContains("getinsured");
        return BaseClass.getActionDriver().isDisplayed(getInsuredpageHeading);
    }
}