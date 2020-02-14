package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps {

    HomePage homePage;
    CheckoutPage checkoutPage;
    ShopPage shopPage;

    //*
    //This is the Step for getting to the Checkout Page
    //*

    @Step
    public void navigateToCheckoutPage(){
        homePage.clickCheckoutNavigationButton();
    }


    //*
    //These are the Steps for Filling all of the fields and drop downs from the Checkout Page
    //*

    @Step
    public void enterFirstAndLastName(String firstName, String lastName){
        checkoutPage.fillFirstNameField(firstName);
        checkoutPage.fillLastNameField(lastName);
    }

    @Step
    public void selectCountry(String countryName){
        checkoutPage.setCountryDropdown(countryName);
    }

    @Step
    public void enterStreetAddress(String streetAddress){
        checkoutPage.fillStreetAddressField(streetAddress);
    }

    @Step
    public void enterTownCity(String cityName){
        checkoutPage.fillTownCityField(cityName);
    }

    @Step
    public void enterPostZIPCode(String postZipCode){
        checkoutPage.fillPostalCodeField(postZipCode);
    }

    @Step
    public void enterPhoneNumber(String phoneNumber){
        checkoutPage.fillPhoneField(phoneNumber);
    }

    @Step
    public void enterEmail(String email){
        checkoutPage.fillEmailField(email);
    }


    //*
    //These are the Steps for clicking on buttons
    //*

    @Step
    public void clickOnPlaceOrderButton(){
        checkoutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void checkOrderIsPlaced(String orderIsPlacedText){
        Assert.assertTrue(checkoutPage.checkOrderIsPlacedTitle(orderIsPlacedText));
    }

    @Step
    public void compareAddedToPlacedOrderProduct(String product28NameFromShop){
        Assert.assertTrue(checkoutPage.product28NameFromOrder().contentEquals(product28NameFromShop));
    }

    @Step
    public void checkThankYouMessage(String thankYouText){
        Assert.assertTrue(checkoutPage.checkThankYouMessage(thankYouText));
    }


    //*
    //This is the filling of the checkoutPage process in ONE SINGLE STEP
    //*

    @Step
    public void fillInAllCheckoutFields(){
        checkoutPage.fillFirstNameField("Andrei");
        checkoutPage.fillLastNameField("Pop");
        checkoutPage.setCountryDropdown("Romania");
        checkoutPage.fillStreetAddressField("Popilor, nr. 56");
        checkoutPage.fillTownCityField("Cluj-Napoca");
        checkoutPage.fillPostalCodeField("329003");
        checkoutPage.fillPhoneField("0751193900");
        checkoutPage.fillEmailField("stan_frostmorn@yahoo.com");






    }



}
