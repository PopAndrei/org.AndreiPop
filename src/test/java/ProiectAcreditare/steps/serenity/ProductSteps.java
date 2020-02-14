package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ProductPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductSteps {

    LoginPage loginPage;
    ShopPage shopPage;
    ProductPage productPage;


    //*
    //These are the Steps for the
    //*




    //*
    //This is the Step for checking a product page
    //*

    @Step
    public void checkAccessToProductPage(){
        Assert.assertTrue(productPage.checkIfDescriptionIsVisible());
    }

}
