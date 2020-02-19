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

        int n = 16;
        byte[] array = new byte[n];
        new Random().nextBytes(array);

        //I wanted to try something with a for loop here, but I got another idea in the process --
//        for(int i = 0; i <= n; i++){
//            if(array[i] != )
//        }

        String firstPartOfEmail = new String(array, Charset.defaultCharset());
        String randomEmail = firstPartOfEmail + "@fasttrackit.org";

        return randomEmail;
    }

    //*
    //This is the NEW method to generate a more reliable random email
    //*

    //I got the idea to create a more reliable random email method, but with a controlled pool of char to select from -
    // this will lead to a more normal looking email address.

    public String getRandomValidEmail() {
        String charContainer = "A1aB2bC3cD4dE5eF6G7H8I9J1K2L3M4N5O6P7Q8R9STUVWXYZabcdefghijlmnopqrstuvwxyz1234567890abcdefghijlmnopqrstuvwxyz1234567890";
        StringBuilder emailName = new StringBuilder();
        Random randomChar = new Random();
            while (emailName.length() < 12) {
                int position = (randomChar.nextInt(10) * emailName.length());
                emailName.append(charContainer.charAt(position));
            }
        String newEmail = emailName.toString();
        //System.out.println(newEmail + "@fasttrackit.org");
        return newEmail+"@fasttrackit.org";

    }

}
