package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.CartSteps;
import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.ShopSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddProductToCartTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    LogInSteps logInSteps;

    @Steps
    ShopSteps shopSteps;

    @Steps
    CartSteps cartSteps;

    @Test
    public void cartTest(){

        logInSteps.login("stan_frostmorn@yahoo.com", "fasttracki");
        shopSteps.navigateToShopPage();


    }
}
