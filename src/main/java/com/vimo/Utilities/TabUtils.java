package com.vimo.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class TabUtils {

    public static String switchToNewTab(WebDriver driver, int timeoutSeconds) {

        String parentTab = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        // wait until new tab opens
        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                return parentTab; // return parent so we can switch back
            }
        }
        throw new RuntimeException("New tab not found");
    }
}
