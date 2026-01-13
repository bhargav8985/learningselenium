package com.vimo.test.hp;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.vimo.pages.Home.HomePage;
import com.vimo.base.BaseClass;

public class HomePageTest1 extends BaseClass {

    //check whether the logo is visible and clickable
    @Test
    public void verifyHomePage() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.ChecklogoisVisibleandClickable(), "Logo is visible and clickable");
    }

    //check whether all the elements are visible
    @Test

    public void testnavbar() {
        HomePage home = new HomePage();
        String[] menuitems = {
                "AI",
                "Child Care Exchange",
                "Medicaid Express",
                "SNAP Express",
                "H.R. 1",
                "About"
        };
        for (String menu : menuitems) {
            Assert.assertNotNull(
                    home.getMenuItemByText(menu),
                    menu + " not found: " + menu
            );
        }
    }

    //check whether the footer is visible
    @Test
    public void testfooter() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.isfooterVisible(), "Footer is not visible");
    }
}
