package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.DashboardPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LogInSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public void goToLogin(){
        homePage.clickAccountLink();
        homePage.clickLogInLink();
    }

    @Step
    public void enterCredentials(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
    }

    @Step
    public void clickLogin(){
        loginPage.clickloginButton();
    }

    @Step
    public void checkLoggedIn(String user){
       Assert.assertTrue(dashboardPage.checkHelloText(user));
    }

}
