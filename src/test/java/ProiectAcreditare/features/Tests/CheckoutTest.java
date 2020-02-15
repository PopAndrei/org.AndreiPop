package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.CheckoutSteps;
import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.ShopSteps;
import com.google.inject.internal.cglib.core.$WeakCacheKey;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximizeWindow(){
        driver.manage()
                .window()
                .maximize();
    }

    @Steps
    LogInSteps logInSteps;

    @Steps
    ShopSteps shopSteps;

    @Steps
    CheckoutSteps checkoutSteps;

    private String email = "stan_frostmorn@yahoo.com";
    private String pass = "fasttracki";

    private String firstName = "Andrei";
    private String lastName = "Pop";
    private String country = "Romania";
    private String street = "Str. Popilor, nr. 56";
    private String city = "Cluj-Napoca";
    private String zipcode = "400398";
    private String phoneNumber = "0751193900";

    @Test
    public void simpleCheckoutTest(){
        logInSteps.login(email,pass);
        shopSteps.navigateToShopPage();
        shopSteps.addOneProductToCart();
        checkoutSteps.navigateToCheckoutPage();
        checkoutSteps.fillInAllCheckoutFields();
        checkoutSteps.clickOnPlaceOrderButton();

    }


    @Test
    public void verifyAddedProductCheckoutTest(){
        logInSteps.login(email,pass);
        shopSteps.navigateToShopPage();
        String prod28Name = shopSteps.getNameOfProduct28();
        shopSteps.addOneProductToCart();
        checkoutSteps.navigateToCheckoutPage();
        checkoutSteps.enterFirstAndLastName(firstName, lastName);
        checkoutSteps.selectCountry(country);
        checkoutSteps.enterStreetAddress(street);
        checkoutSteps.enterTownCity(city);
        checkoutSteps.enterPostZIPCode(zipcode);
        checkoutSteps.enterPhoneNumber(phoneNumber);
        checkoutSteps.enterEmail(email);
        checkoutSteps.clickOnPlaceOrderButton();
        checkoutSteps.checkOrderIsPlaced("ORDER RECEIVED");
        checkoutSteps.checkThankYouMessage("Thank you. Your order has been received.");
        checkoutSteps.compareAddedToPlacedOrderProduct(prod28Name);

    }
}
