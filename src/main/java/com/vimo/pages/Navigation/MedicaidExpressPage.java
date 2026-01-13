package com.vimo.pages.Navigation;

import com.vimo.base.BaseClass;
import org.openqa.selenium.By;

public class MedicaidExpressPage {

    final By MedicaidExpressh1 = By.tagName("h1");

    public boolean isLoaded() {
        return BaseClass.getActionDriver()
                .waitForUrlContains("medicaid-express/")
                &&
                BaseClass.getActionDriver().isDisplayed(MedicaidExpressh1);
    }
}
