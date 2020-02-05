package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/customer/account/")
public class DashboardTabPage extends PageObject {

    //*
    //These are the elements found on the "Dashboard" Tab on the "My Account" Page
    //*

    @FindBy ( css = "strong:first-child")
    private WebElementFacade helloUserName;


    //*
    //These are the methods for/interactions with the "Dashboard" Tab on the "My Account" Page
    //*

    public boolean checkHelloUserName (String text){
        return helloUserName.containsOnlyText(text);
    }



}
