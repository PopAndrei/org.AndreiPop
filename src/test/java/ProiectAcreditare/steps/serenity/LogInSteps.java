package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.DashboardTabPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LogInSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardTabPage dashboardTabPage;


    //*
    //These are the Steps for the "valid login test"
    //*

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public void goToLogin(){
        homePage.clickLoginLink();
    }

    @Step
    public void enterCredentials(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
    }

    @Step
    public void clickLoginButton (){
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoggedIn(String username){
       Assert.assertTrue(dashboardTabPage.checkHelloUserName(username));
    }


    //*
    //These are the extra Steps for the "Invalid login test"
    //*

    @Step
    public void enterInvalidCredentials(String user, String wrongPass){
        enterCredentials(user,wrongPass);
    }

    @Step
    public void checkIfErrorMessageVisible(){
        Assert.assertTrue(loginPage.checkLoginErrorMessage());
    }

    @Step
    public void checkLostYourPasswordQuestion(String lostPassQuestion){
        Assert.assertTrue(loginPage.checkLostPasswordError(lostPassQuestion));
    }


    //*
    //This is the login process in One Step
    //*

    @Step
    public void login(String user, String pass){
        navigateToHomepage();
        goToLogin();
        enterCredentials(user, pass);
        clickLoginButton();
    }



}
