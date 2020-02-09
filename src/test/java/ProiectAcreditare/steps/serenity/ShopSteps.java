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
    public void addOneProductToCart() {shopPage.clickProduct28AddToCartButton();
    }

    @Step
    public void addTwoProductsToCart() {
        shopPage.clickProduct27AddToCartButton();
        shopPage.clickProduct28AddToCartButton();
    }

    @Step
    public void clickViewCartButton() { shopPage.clickProduct28ViewCartButton();}
}