package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.NavigationSteps;
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
    private NavigationSteps navigationSteps;

    @Steps
    private ShopSteps shopSteps;


    @Test
    public void sortProductsByPriceLow2HighTest(){
        navigationSteps.navigateToHomepage();
        navigationSteps.clickOnShopMenuButton();
        shopSteps.clickOnSortDropdown();
        shopSteps.selectSortProductByPriceLow2High();
        shopSteps.checkPricesOrderedLowToHigh();
    }

}
