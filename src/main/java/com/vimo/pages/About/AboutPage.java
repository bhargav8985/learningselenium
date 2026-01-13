package com.vimo.pages.About;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;


public class AboutPage {

    final By Abouth1 = By.tagName("h1");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("about/")
                &&
                BaseClass.getActionDriver().isDisplayed(Abouth1);
    }
}
