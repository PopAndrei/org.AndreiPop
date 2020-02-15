package ProiectAcreditare.features.Tests;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.steps.serenity.HomepageSteps;
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
public class SortProductsTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maxwin(){
        driver.manage().window().maximize();
    }

    @Steps
    HomepageSteps homepageSteps;

    @Steps
    ShopSteps shopSteps;


    @Test
    public void sortProductsByPriceLow2HighTest(){
        homepageSteps.navigateToHomepage();
        homepageSteps.clickOnShopMenuButton();
        shopSteps.clickOnSortDropdown();
        shopSteps.selectSortProductByPriceLow2High();
        shopSteps.checkPricesOrderedLowToHigh();
    }

}
