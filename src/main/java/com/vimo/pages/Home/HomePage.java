package com.vimo.pages.Home;

import com.vimo.base.BaseClass;
import com.vimo.pages.About.AboutLeaderShip;
import com.vimo.pages.About.AboutNewsroom;
import com.vimo.pages.About.AboutPage;
import com.vimo.pages.About.AboutResources;
import com.vimo.pages.ChildcareExchange.ChildCareExchangeInformation;
import com.vimo.pages.ChildcareExchange.ChildCareExchangeResources;
import com.vimo.pages.Navigation.AiPage;
import com.vimo.pages.Navigation.HrPage;
import com.vimo.pages.Navigation.MedicaidExpressPage;
import com.vimo.pages.Navigation.SnapExpressPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    final private By vimologo = By.cssSelector(".et_pb_menu__logo");
    final private By navAi = By.xpath("//ul[@id='menu-main']//a[text()='AI']");
    final private By ChildcareExchange = By.xpath("//ul[@id='menu-main']//a[text()='Child Care Exchange']");
    final private By ChildcareExchangeInformation = By.xpath("//ul[@id='menu-main']//a[text()='Child Care Exchange Information']");
    final private By ChildcareExchangeResources = By.xpath("//ul[@id='menu-main']//a[text()='Child Care Exchange Resources']");
    final private By MedicaidExpress = By.xpath("//ul[@id='menu-main']//a[normalize-space()='Medicaid Express']");
    final private By SnapExpress = By.xpath("//ul[@id='menu-main']//a[text()='SNAP Express']");
    final private By HR = By.xpath("//ul[@id='menu-main']//a[text()='H.R. 1']");
    final private By About = By.xpath("//ul[@id='menu-main']//a[text()='About']");
    final private By LeaderShip = By.xpath("//ul[@id='menu-main']//a[text()='Leadership']");
    final private By NewsRoom = By.xpath("//ul[@id='menu-main']//a[text()='Newsroom']");
    final private By Resources = By.xpath("//ul[@id='menu-main']//a[text()='Resources']");
    final private By menuLinks = By.cssSelector("#menu-main a");
    final private By footer = By.cssSelector("#et-main-area > footer");
    final private By getInsuredlink=By.xpath("//a[contains(text(),'Find out more about GetInsured')]");
    final private By CIAlink=By.xpath("//a[contains(text(),'Find out more at changeagents')]");
    public boolean ChecklogoisVisibleandClickable() {
        BaseClass.logger.info("ChecklogoisVisibleandClickable");
        return BaseClass.getActionDriver().isDisplayed(vimologo) &&
                BaseClass.getActionDriver().isClickable(vimologo);
    }

    public WebElement getMenuItemByText(String menuName) {
        List<WebElement> links = BaseClass.getDriver().findElements(menuLinks);

        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(menuName)) {
                return link;
            }
        }
        BaseClass.logger.info(menuName + " not found");
        throw new RuntimeException("Menu item not found: " + menuName);
    }

    public boolean isfooterVisible() {
        BaseClass.logger.info("isfooterVisible method is running");
        BaseClass.getActionDriver().scrollToElement(footer);
        return BaseClass.getActionDriver().isDisplayed(footer);
    }

    public AiPage clickNavAi() {
        BaseClass.logger.info("clickNavAi method is running");
        BaseClass.getActionDriver().click(navAi);
        return new AiPage();
    }

    public MedicaidExpressPage clickMedicaidExpress() {
        BaseClass.logger.info("clickMedicaidExpress method is running");
        BaseClass.getActionDriver().click(MedicaidExpress);
        return new MedicaidExpressPage();
    }

    public SnapExpressPage clickSnapExpress() {
        BaseClass.logger.info("clickSnapExpress method is running");
        BaseClass.getActionDriver().click(SnapExpress);
        return new SnapExpressPage();
    }

    public HrPage clickHr() {
        BaseClass.logger.info("clickHr method is running");
        BaseClass.getActionDriver().click(HR);
        return new HrPage();
    }

    public AboutPage clickAbout() {
        BaseClass.logger.info("clickAbout method is running");
        BaseClass.getActionDriver().click(About);
        return new AboutPage();
    }

    public AboutLeaderShip clickAboutLeaderShip() {
        BaseClass.logger.info("clickAboutLeaderShip method is running");
        BaseClass.getActionDriver().hover(About);
        BaseClass.getActionDriver().click(LeaderShip);
        return new AboutLeaderShip();
    }

    public AboutNewsroom clickAboutNewsroom() {
        BaseClass.logger.info("clickAboutNewsroom method is running");
        BaseClass.getActionDriver().hover(About);
        BaseClass.getActionDriver().click(NewsRoom);
        return new AboutNewsroom();
    }

    public AboutResources clickAboutResources() {
        BaseClass.logger.info("clickAboutResources method is running");
        BaseClass.getActionDriver().hover(About);
        BaseClass.getActionDriver().click(Resources);
        return new AboutResources();
    }

    public ChildCareExchangeInformation clickChildCareExchange() {
        BaseClass.logger.info("clickChildCareExchange method is running");
        BaseClass.getActionDriver().click(ChildcareExchange);
        return new ChildCareExchangeInformation();
    }

    public ChildCareExchangeInformation clickChildCareExchangeInformation() {
        BaseClass.logger.info("clickChildCareExchangeInformation method is running");
        BaseClass.getActionDriver().hover(ChildcareExchange);
        BaseClass.getActionDriver().click(ChildcareExchangeInformation);
        return new ChildCareExchangeInformation();
    }

    public ChildCareExchangeResources clickChildCareExchangeResources() {
        BaseClass.logger.info("clickChildCareExchangeResources method is running");
        BaseClass.getActionDriver().hover(ChildcareExchange);
        BaseClass.getActionDriver().click(ChildcareExchangeResources);
        return new ChildCareExchangeResources();
    }
    public void clickCIAPage() {
        BaseClass.logger.info("clickCIAPage method is running");
        BaseClass.getActionDriver().click(CIAlink);

    }
    public void clickGetInsured() {
        BaseClass.logger.info("clickGetInsured method is running");
        BaseClass.getActionDriver().click(getInsuredlink);
    }
}
