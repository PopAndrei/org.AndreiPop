package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.NavigationSteps;
import ProiectAcreditare.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    public void maxWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private NavigationSteps navigationSteps;

    @Steps
    private SearchSteps searchSteps;


    @Test
    public void searchTest(){
        navigationSteps.navigateToHomepage();
        String searchedText = "Belt";
        searchSteps.insertSearchText(searchedText);
        searchSteps.clickSearchButton();
        searchSteps.checkSearchedProductResult(searchedText);

    }


}
