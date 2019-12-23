package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/")
public class HomePage extends PageObject {


    @FindBy (css = "a.skip-account")
    private WebElementFacade accountLink;

    @FindBy (css = "a[title = 'Log In']")
    private WebElementFacade logInLink;

    public void clickAccountLink(){
        clickOn(accountLink);
    }

    public void clickLogInLink(){
        clickOn(logInLink);
    }


}
