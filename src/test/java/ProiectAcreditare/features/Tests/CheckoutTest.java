package ProiectAcreditare.features.Tests;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.steps.serenity.*;
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
    private LogInSteps logInSteps;

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private NavigationSteps navigationSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private CheckoutSteps checkoutSteps;

    private String email = "stan_frostmorn@yahoo.com";
    private String pass = "fasttracki";

    private String firstName = "Andrei";
    private String lastName = "Pop";
    private String country = "Romania";
    private String street = "Str. Popilor, nr. 56";
    private String city = "Cluj-Napoca";
    private String zipcode = "400398";
    private String phoneNumber = "0751193900";

    private String qty1 = "3";
    private String qty2 = "4";

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

    @Test
    public void verifyTotalSumAtCheckoutTest(){
        navigationSteps.navigateToHomepage();
        logInSteps.login(email,pass);
        shopSteps.addTwoProductsToCart();
        navigationSteps.clickOnCartMenuButton();
        cartSteps.setProd28Quantity(qty1);
        cartSteps.setProd27Quantity(qty2);
        cartSteps.clickOnUpdateCartButton();
        cartSteps.verifyTotalSumFromCart(qty1,qty2);
        String cartTotal = cartSteps.getTotalSumPriceFromCart();
        checkoutSteps.checkTotalAndProceedToCheckout(cartTotal);
        checkoutSteps.checkPlacedOrderTotal(cartTotal);
        logInSteps.clickLogOutButton();

    }


}
