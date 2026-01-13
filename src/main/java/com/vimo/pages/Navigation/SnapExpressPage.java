package com.vimo.pages.Navigation;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;

public class SnapExpressPage extends BaseClass {

    final By SnapExpressh1 = By.tagName("h1");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("snap-express/")
                &&
                BaseClass.getActionDriver().isDisplayed(SnapExpressh1);
    }
}
