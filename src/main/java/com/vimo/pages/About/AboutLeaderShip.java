package com.vimo.pages.About;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;


public class AboutLeaderShip {

    final By leadershiph1 = By.xpath("//h1[text()='Leadership']");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("leadership/")
                &&
                BaseClass.getActionDriver().isDisplayed(leadershiph1);
    }
}
