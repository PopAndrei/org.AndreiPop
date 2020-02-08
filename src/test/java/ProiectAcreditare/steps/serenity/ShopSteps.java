package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;

public class ShopSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private LoginPage loginPage;

    @Step
    public void navigateToShopPage(){
        homePage.clickShopNavigationButton();
    }

    @Step

}
