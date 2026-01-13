package com.vimo.pages.About;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;


public class AboutNewsroom {

    final By Newsroomh1 = By.xpath("//h1[text()='Newsroom']");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("newsroom/")
                &&
                BaseClass.getActionDriver().isDisplayed(Newsroomh1);
    }
}
