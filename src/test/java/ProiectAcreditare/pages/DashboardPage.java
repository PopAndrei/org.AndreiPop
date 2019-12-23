package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/customer/account/")
public class DashboardPage extends PageObject {

    @FindBy ( css = ".hello strong")
    private WebElementFacade helloTextParagraph;

    public boolean checkHelloText (String text){
        return helloTextParagraph.containsOnlyText(text);
    }



}
