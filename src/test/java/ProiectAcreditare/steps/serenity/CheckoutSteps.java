package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps {

    HomePage homePage;
    CheckoutPage checkoutPage;
    ShopPage shopPage;

    @Step
    public void navigateToCheckoutPage(){
        homePage.clickCheckoutNavigationButton();
    }

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

    @Step
    public void clickOnPlaceOrderButton(){
        checkoutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void checkOrderIsPlaced(String orderIsPlacedText){
        Assert.assertTrue(checkoutPage.checkOrderIsPlacedText(orderIsPlacedText));
    }

    @Step
    public void compareAddedToPlacedOrderProduct(String product28NameFromShop){
        Assert.assertTrue(checkoutPage.product28NameFromOrder().contentEquals(product28NameFromShop));
    }
}
