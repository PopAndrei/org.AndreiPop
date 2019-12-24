package ProiectAcreditare.features.Learning;

import ProiectAcreditare.steps.serenity.CartSteps;
import ProiectAcreditare.steps.serenity.LogInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    LogInSteps logInSteps;

    @Steps
    CartSteps cartSteps;

    @Test
    public void cartTest(){
        logInSteps.login("cosmin@fasttrackit.org", "123456");
    }
}
