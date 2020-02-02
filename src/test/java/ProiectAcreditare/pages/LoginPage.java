package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    @FindBy (id = "email")
    private WebElementFacade emailField;

    @FindBy (id = "pass")
    private WebElementFacade passField;

    @FindBy (id = "send2")
    private WebElementFacade loginButton;

    public void setEmailField (String email){
        typeInto(emailField, email);
    }

    public void setPassField (String password){
        typeInto(passField, password);
    }

    public void clickloginButton (){
        clickOn(loginButton);
    }
}
