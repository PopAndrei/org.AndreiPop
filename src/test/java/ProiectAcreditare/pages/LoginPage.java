package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Test;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    //*
    //These are the elements found in the "Login" section from the "My Account" Page
    //*

    @FindBy (id = "username")
    private WebElementFacade emailField;

    @FindBy (id = "password")
    private WebElementFacade passField;

    @FindBy (css = "button[name = 'login']")
    private WebElementFacade loginButton;

    @FindBy (css = "strong:first-child")
    private WebElementFacade loginErrorMessage;

    @FindBy (css = "#post-7 li a")
    private WebElementFacade lostPasswordError;

    //*
    //These are the methods for/interactions with the "Login" section:
    //*

    public void setEmailField (String email){
        typeInto(emailField, email);
    }

    public void setPassField (String password){
        typeInto(passField, password);
    }

    public void clickLoginButton (){
        clickOn(loginButton);
    }


    //*
    //These are the methods for/interactions with the Login Error from the "Login" section
    //*

//  ----- Here I tried to check if the word "ERROR" is visible on the error message,
//  ----- but I though I would probably learn more if I tried a different approach;
//  ----- As in trying to check if the error message is visible or not.

//    public boolean checkLoginErrorMessage (String errorMessage){
//        return loginErrorMessage.containsOnlyText(errorMessage);
//    }

    public boolean checkLoginErrorMessage(){
        return loginErrorMessage.isCurrentlyVisible();
    }

    public boolean checkLostPasswordError(String text){
        return lostPasswordError.containsOnlyText(text);
    }



}
