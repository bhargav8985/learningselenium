package com.vimo.pages.Navigation;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;

public class AiPage {
    final private By aiHeading = By.xpath(
            "//h1[contains(normalize-space(.),'Transformative AI')]"
    );

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("ai")
                &&
                BaseClass.getActionDriver().isDisplayed(aiHeading);
    }

}

