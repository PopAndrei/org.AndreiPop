package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;

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
        shopPage.clickProduct27AddToCartButton();
        shopPage.clickProduct28AddToCartButton();
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
    //These are the Steps for getting the name of a product
    //*

    @Step
    public String getNameOfProduct28(){
        return shopPage.getProduct28Name();
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

}
