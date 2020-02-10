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
public class AddProductToCartTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    LogInSteps logInSteps;

    @Steps
    ShopSteps shopSteps;

    @Steps
    CartSteps cartSteps;

    @Test
    public void addProductToCartTest(){

        logInSteps.login("stan_frostmorn@yahoo.com", "fasttracki");
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
        logInSteps.login("stan_frostmorn@yahoo.com", "fasttracki");
        shopSteps.navigateToShopPage();
        shopSteps.addOneProductToCart();
        String prod28Name = shopSteps.getNameOfProduct28();
        shopSteps.clickViewCartButton();
        cartSteps.compareNameOfProductAddedToCart(prod28Name);
    }

}
