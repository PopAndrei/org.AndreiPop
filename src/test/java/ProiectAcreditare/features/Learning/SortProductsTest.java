package ProiectAcreditare.features.Learning;

import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.SortProductsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith (SerenityRunner.class)
public class SortProductsTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LogInSteps logInSteps;

    @Steps
    private SortProductsSteps sortProductsSteps;

    @Test
    public void validSearchTest (){
        logInSteps.navigateToHomepage();
        sortProductsSteps.searchForProduct("shirt");
    }

    @Test
    public void checkSortByPriceFunctionality(){
        logInSteps.navigateToHomepage();
        sortProductsSteps.searchForProduct("necklace");
        sortProductsSteps.sortByPrice();
        sortProductsSteps.checkPriceAscending();
    }


}
