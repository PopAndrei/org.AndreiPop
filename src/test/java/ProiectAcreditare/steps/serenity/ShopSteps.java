package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ShopSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private LoginPage loginPage;

    //*
    //These are the Steps for Navigating
    //*

    @Step
    public void navigateToShopPage(){
        homePage.clickShopNavigationButton();
    }



    //*
    //These are the Steps for adding products
    //*

    @Step
    public void addOneProductToCart() {shopPage.clickProduct28AddToCartButton();
    }

    @Step
    public void addTwoProductsToCart() {
        homePage.clickShopNavigationButton();
        shopPage.clickProduct27AddToCartButton();
        shopPage.clickProduct28AddToCartButton();
    }


    //*
    //These are the Steps for viewing the products in Product Page
    //*

    @Step
    public void clickOnProduct27(){
        shopPage.clickOnProduct27();
    }

    @Step
    public void clickOnProduct28(){
        shopPage.clickOnProduct28();
    }



    //*
    //These are the Steps for viewing added product in Cart Page
    //*

    @Step
    public void clickViewCartButton() {
        shopPage.clickProduct28ViewCartButton();
    }

    @Step
    public String getNameAndClickViewCartButton() {
        String prod28Name = shopPage.getProduct28Name();
        shopPage.clickProduct28ViewCartButton();
    return prod28Name;
    }

    //*
    //These are the Steps for getting the name of a products
    //*

    @Step
    public String getNameOfProduct28(){
        return shopPage.getProduct28Name();
    }

    @Step
    public String getNameOfProduct27(){
        return shopPage.getProduct27Name();
    }




    //*
    //This is One Step for getting to Shop Page + adding a product + Navigating to the Cart Page
    //*

    @Step
    public void navigateAddViewOneProductInCart(){
        homePage.clickShopNavigationButton();
        shopPage.clickProduct28AddToCartButton();
        shopPage.clickProduct28ViewCartButton();
    }

    //*
    //These are the Steps for the "Sort By Price: Low to High" Tests
    //*

    @Step
    public void clickOnSortDropdown(){
        shopPage.clickOnSortDropdown();
    }

    @Step
    public void selectSortProductByPriceLow2High(){
        shopPage.selectSortByPriceLowToHigh();
    }

    @Step
    public void checkPricesOrderedLowToHigh(){
        Assert.assertTrue(shopPage.checkPricesOrderedLowToHigh());
    }


}
