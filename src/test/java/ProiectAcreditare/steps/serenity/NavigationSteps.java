package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.CartPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private ShopPage shopPage;

    private WebDriver driver;

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }


    //*
    //These are the Steps for the navigation Menu from the header
    //*

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


    //*
    //These are the steps for checking the navigation menu
    //*

    @Step
    public void checkMyAccountTitleIsVisible(){
        Assert.assertTrue(loginPage.checkMyAccountTitleIsVisible());
    }


    @Step
    public void checkEmptyCartMessageIsVisible(){
        Assert.assertTrue(cartPage.checkCartIsEmpty());
    }

    @Step
    public void checkShopTitleIsVisible(){
        Assert.assertTrue(shopPage.checkShopTitleIsVisible());
    }

    @Step
    public void checkHomePageTitleIsVisible(){
        Assert.assertTrue(homePage.checkLogOutMessage("Hello world!"));
    }


    //*
    //These are the steps for checking the redirect from Checkout(When Empty) to Cart Page
    //*

    @Step
    public void verifyRedirect(String currentURL, String cartURL){
        Assert.assertTrue(currentURL.contentEquals(cartURL));
    }


    //*
    //This is the step for the Logo Test
    //*


    @Step
    public void clickLogo(){
        homePage.clickLogo();
    }

}
