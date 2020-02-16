package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.CartSteps;
import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.ShopSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LogInSteps logInSteps;

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private CartSteps cartSteps;

    private String email = "stan_frostmorn@yahoo.com";
    private String pass = "fasttracki";

    @Test
    public void addProductToCartTest(){

        logInSteps.login(email, pass);
        shopSteps.navigateToShopPage();
        shopSteps.addOneProductToCart();
        shopSteps.clickViewCartButton();
        cartSteps.verifyNameOfAddedProductToCart("Cap");
    }

    //*
    // In the next test I tried to see if I could automatically check/compare the name of added the product
    // from the Shop Page and the (hopefully) same product displayed on the Cart Page.
    //*

    @Test
    public void addAndCheckProductToCartTest(){
        logInSteps.login(email,pass);
        shopSteps.navigateToShopPage();
        shopSteps.addOneProductToCart();
        String prod28Name = shopSteps.getNameOfProduct28();
        shopSteps.clickViewCartButton();
        cartSteps.compareNameOfProductAddedToCart(prod28Name);
    }

    @Test
    public void addTwoProductsToCartTest(){
        logInSteps.login(email,pass);
        shopSteps.addTwoProductsToCart();
        String prod28 = shopSteps.getNameOfProduct28();
        String prod27 = shopSteps.getNameOfProduct27();
        shopSteps.clickViewCartButton();
        cartSteps.compareNamesOfTwoProductsAddedToCart(prod28,prod27);

    }

    //*
    // These are the tests for Removing Products from cart -
    // Note that the cart must be empty before launching test!!!
    //*


    @Test
    public void removeProductFromCartTest(){
        logInSteps.login(email,pass);
        shopSteps.navigateAddViewOneProductInCart();
        cartSteps.removeOneProductFromCart();
        cartSteps.checkCartIsEmpty();
    }

}
