package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.ProductSteps;
import ProiectAcreditare.steps.serenity.ShopSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ProductPageTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    public void manageWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    LogInSteps logInSteps;

    @Steps
    ShopSteps shopSteps;

    @Steps
    ProductSteps productSteps;

    @Test
    public void openProductPageTest(){
        logInSteps.login("stan_frostmorn@yahoo.com","fasttracki");
        shopSteps.navigateToShopPage();
        shopSteps.clickOnProduct27();
        productSteps.checkAccessToProductPage();
    }

}
