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
public class VerifiedCheckoutTest {

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

    @Test
    public void verifyAddedProductCheckoutTest(){
        logInSteps.login("stan_frostmorn@yahoo.com","fasttracki");
        shopSteps.navigateToShopPage();
        String prod28Name = shopSteps.getNameOfProduct28();
        shopSteps.addOneProductToCart();
        checkoutSteps.navigateToCheckoutPage();
        checkoutSteps.enterFirstAndLastName("Andrei", "Pop");
        checkoutSteps.selectCountry("Romania");
        checkoutSteps.enterStreetAddress("Popilor, nr.56");
        checkoutSteps.enterTownCity("Cluj-Napoca");
        checkoutSteps.enterPostZIPCode("400379");
        checkoutSteps.enterPhoneNumber("0751193900");
        checkoutSteps.enterEmail("stan_frostmorn@yahoo.com");
        checkoutSteps.clickOnPlaceOrderButton();
        checkoutSteps.checkOrderIsPlaced("ORDER RECEIVED");
        checkoutSteps.checkThankYouMessage("Thank you. Your order has been received.");
        checkoutSteps.compareAddedToPlacedOrderProduct(prod28Name);

    }
}
