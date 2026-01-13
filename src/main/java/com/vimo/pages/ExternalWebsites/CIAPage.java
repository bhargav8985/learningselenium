package com.vimo.pages.ExternalWebsites;

import org.openqa.selenium.By;

import com.vimo.base.BaseClass;

public class CIAPage {

    // Unique element on external website
    final private By CIApageHeading = By.xpath("//h1[contains(normalize-space(),'Doing More Good')]");

    public boolean isPageOpened() {
        BaseClass.getActionDriver().waitForUrlContains("changeagents.info");
        return BaseClass.getActionDriver().isDisplayed(CIApageHeading);
    }
}