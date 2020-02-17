package ProiectAcreditare.pages;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.text.RandomStringGenerator;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;


@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class RegisterPage extends PageObject {


    //*
    //These are the elements of the Register Section Page
    //*

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailField;;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPassField;

    @FindBy(css = ".button[name='register']")
    private WebElementFacade registerButton;

    //*
    //These are the interactions/elements of the Register Section Page
    //*

    public void inputRegisterEmail(String randomEmail){
        typeInto(registerEmailField,randomEmail);
    }

    public void inputRegisterPassword(String pass){
        typeInto(registerPassField, pass);
    }

    public void clickOnRegisterButton(){
        clickOn(registerButton);
    }

    public String getNameToCheck(String email){
        String nameToCheck = email.replace("@fasttrackit.org","");
        return nameToCheck;
    }

    //*
    //This is a method to generate a random email
    //*


    public String generateRandomEmail(){

        byte[] array = new byte[8];
        new Random().nextBytes(array);

        String firstPartOfEmail = new String(array, Charset.forName("Unicode"));
        String randomEmail = firstPartOfEmail + "@fasttrackit.org";

        return randomEmail;
    }

}
