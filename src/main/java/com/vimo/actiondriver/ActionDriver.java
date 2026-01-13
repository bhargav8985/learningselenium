package com.vimo.actiondriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vimo.base.BaseClass;

import java.time.Duration;

public class ActionDriver {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger logger = BaseClass.logger;
    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        int explicitwait = Integer.parseInt(BaseClass.getProp().getProperty("ExplicitWait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait));
    }

    // ---------------- CLICK ----------------
    public void click(By locator) {
        try {
            applyBorder(locator,"green");
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            BaseClass.logger.info("Clicked element: " + locator);
        } catch (Exception e) {
            applyBorder(locator,"red");
            BaseClass.logger.error("Failed to click element: " + locator, e);
            throw e; // VERY IMPORTANT
        }
    }

    // ---------------- TYPE ----------------
    public void type(By locator, String value) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            applyBorder(locator,"green");
            element.clear();
            element.sendKeys(value);
            BaseClass.logger.info("Typed element: " + locator);
        } catch (Exception e) {
            applyBorder(locator,"red");
              BaseClass.logger.error("Failed to type element: " + locator, e);
            throw e;
        }
    }

    // ---------------- GET TEXT ----------------
    public String getText(By locator) {
        try {
            applyBorder(locator,"green");
            BaseClass.logger.info("Getting text from: " + locator);
            return wait.until(
                            ExpectedConditions.visibilityOfElementLocated(locator))
                    .getText();

        } catch (Exception e) {
            applyBorder(locator,"green");
       BaseClass.logger.error("Failed to get text from: " + locator, e);
            throw e;
        }
    }

    // ---------------- IS DISPLAYED ----------------
    public boolean isDisplayed(By locator) {
        try {
            BaseClass.logger.info("Checking if element is displayed: " + locator);
            return wait.until(
                            ExpectedConditions.visibilityOfElementLocated(locator))
                    .isDisplayed();
        } catch (Exception e) {
            BaseClass.logger.error("Failed to check if element is displayed: " + locator, e);
            return false;
        }
    }

    // ---------------- IS CLICKABLE ----------------
    public boolean isClickable(By locator) {
        try {
            applyBorder(locator,"green");
            BaseClass.logger.info("Checking if element is clickable: " + locator);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            applyBorder(locator,"red");
          BaseClass.logger.error("Failed to check if element is clickable: " + locator, e);
            return false;
        }

    }

    // ---------------- JS CLICK ----------------
    public void jsClick(By locator) {
        try {
            applyBorder(locator,"green");
            BaseClass.logger.info("JS clicking element: " + locator);
            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            applyBorder(locator,"red");
            BaseClass.logger.error("Failed to click element: " + locator, e);
            throw e;
        }
    }

    // ---------------- SCROLL ----------------
    public void scrollToElement(By locator) {
        try {
            BaseClass.logger.info("Scrolling to element: " + locator);
            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", element);
            applyBorder(locator,"green");
        } catch (Exception e) {
            applyBorder(locator,"red");
           BaseClass.logger.error("Failed to scroll to element: " + locator, e);
            throw e;
        }
    }

    // ---------------- HOVER ----------------
    public void hover(By locator) {
        try {
            BaseClass.logger.info("Hovering element: " + locator);
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            new Actions(driver).moveToElement(element).perform();
            applyBorder(locator,"green");
        } catch (Exception e) {
            applyBorder(locator,"red");
       BaseClass.logger.error("Failed to hover element: " + locator, e);
            throw e;
        }
    }

    // ---------------- DROPDOWN ----------------
    public void selectByVisibleText(By locator, String value) {
        try {
            BaseClass.logger.info("Selecting element by Text: " + locator);
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            new Select(element).selectByVisibleText(value);
        } catch (Exception e) {
            BaseClass.logger.error("Failed to select element: " + locator, e);
            throw e;
        }
    }

    // ---------------- PAGE TITLE ----------------
    public String getPageTitle() {
        return driver.getTitle();
    }

    // ---------------- CURRENT URL ----------------
    public String getCurrentUrl() {
        BaseClass.logger.info("Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // ---------------- WAIT FOR URL CONTAINS----------------
    public boolean waitForUrlContains(String partialUrl) {
        try {
            BaseClass.logger.info("Waiting for URL to contain: " + partialUrl);
            wait.until(ExpectedConditions.urlContains(partialUrl));
            return true;
        } catch (Exception e) {
            BaseClass.logger.error("Failed to wait for URL to contain: " + partialUrl, e);
            return false;
        }
    }
    public String getElementDescription(By locator) {
        // Check for null driver or locator to avoid NullPointerException
        if (driver == null) {
            return "Driver is not initialized.";
        }
        if (locator == null) {
            return "Locator is null.";
        }

        try {
            // Find the element using the locator
            WebElement element = driver.findElement(locator);

            // Get element attributes
            String name = element.getDomProperty("name");
            String id = element.getDomProperty("id");
            String text = element.getText();
            String className = element.getDomProperty("class");
            String placeholder = element.getDomProperty("placeholder");

            // Return a description based on available attributes
            if (isNotEmpty(name)) {
                return "Element with name: " + name;
            } else if (isNotEmpty(id)) {
                return "Element with ID: " + id;
            } else if (isNotEmpty(text)) {
                return "Element with text: " + truncate(text, 50);
            } else if (isNotEmpty(className)) {
                return "Element with class: " + className;
            } else if (isNotEmpty(placeholder)) {
                return "Element with placeholder: " + placeholder;
            } else {
                return "Element located using: " + locator.toString();
            }
        } catch (Exception e) {
            // Log exception for debugging
            e.printStackTrace(); // Replace with a logger in a real-world scenario
            return "Unable to describe element due to error: " + e.getMessage();
        }
    }

    // Utility method to check if a string is not null or empty
    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    // Utility method to truncate long strings
    private String truncate(String value, int maxLength) {
        if (value == null || value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, maxLength) + "...";
    }

    //Utility Method to Border an element
    public void applyBorder(By by,String color) {
        try {
            //Locate the element
            WebElement element = driver.findElement(by);
            //Apply the border
            String script = "arguments[0].style.border='3px solid "+color+"'";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, element);
            logger.info("Applied the border with color "+color+ " to element: "+getElementDescription(by));
        } catch (Exception e) {
            logger.warn("Failed to apply the border to an element: "+getElementDescription(by),e);
        }
    }
}
