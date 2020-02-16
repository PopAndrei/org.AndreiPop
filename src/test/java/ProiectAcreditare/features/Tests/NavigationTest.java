package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.NavigationSteps;
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
public class NavigationTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maxWin(){
        driver.manage().window().maximize();
    }

    @Steps
    private NavigationSteps navigationSteps;

    @Steps
    private LogInSteps logInSteps;

    @Steps
    private ShopSteps shopSteps;


    @Test
    public void logoTest(){
        navigationSteps.navigateToHomepage();
        shopSteps.navigateToShopPage();
        shopSteps.clickOnProduct27();
        navigationSteps.clickLogo();
        logInSteps.checkDashBoardMessage("Hello world!");
    }

    @Test
    public void headerMenuNavigationTest(){
        navigationSteps.navigateToHomepage();
        navigationSteps.clickOnMyAccountMenuButton();
        navigationSteps.checkMyAccountTitleIsVisible();
        navigationSteps.clickOnCartMenuButton();
        navigationSteps.checkEmptyCartMessageIsVisible();
        String cartURL = driver.getCurrentUrl();
        navigationSteps.clickOnCheckoutMenuButton();
        String currentURL = driver.getCurrentUrl();
        navigationSteps.verifyRedirect(currentURL,cartURL);
        navigationSteps.clickOnShopMenuButton();
        navigationSteps.checkShopTitleIsVisible();
        navigationSteps.clickOnHomeMenuButton();
        navigationSteps.checkHomePageTitleIsVisible();
    }

}
