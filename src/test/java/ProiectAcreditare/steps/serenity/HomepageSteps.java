package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomepageSteps {

    private HomePage homePage;

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public void clickOnHomeMenuButton(){
        homePage.clickHomeNavigationButton();
    }

    @Step
    public void clickOnMyAccountMenuButton(){
        homePage.clickMyAccountNavigationButton();
    }

    @Step
    public void clickOnCheckoutMenuButton(){
        homePage.clickCheckoutNavigationButton();
    }

    @Step
    public void clickOnCartMenuButton(){
        homePage.clickCartNavigationButton();
    }

    @Step
    public void clickOnShopMenuButton(){
        homePage.clickShopNavigationButton();
    }

}
