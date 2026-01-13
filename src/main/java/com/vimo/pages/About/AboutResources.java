package com.vimo.pages.About;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;

public class AboutResources {

    final By Resourcesh1 = By.tagName("h1");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("resources/")
                &&
                BaseClass.getActionDriver().isDisplayed(Resourcesh1);
    }
}
