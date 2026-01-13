package com.vimo.pages.Navigation;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;


public class HrPage {

    final By hrh1 = By.tagName("h1");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("h-r-1-what-state-agencies-need-to-know-now/")
                &&
                BaseClass.getActionDriver().isDisplayed(hrh1);
    }

}
