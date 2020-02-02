package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    //*
    //These are the header navigation buttons:
    //*

    @FindBy (id = "menu-item-69")
    private WebElementFacade homeNavigationButton;

    @FindBy (id = "menu-item-70")
    private WebElementFacade myAccountNavigationButton;

    @FindBy (id = "menu-item-71")
    private WebElementFacade checkoutNavigationButton;

    @FindBy (id = "menu-item-72")
    private WebElementFacade cartNavigationButton;

    @FindBy (id = "menu-item-73")
    private WebElementFacade shopNavigationButton;

    //*
    //These are the remaining elements from the Homepage header:
    //*

    @FindBy (css = "a.account")
    private WebElementFacade loginLink;

    @FindBy (css = ".headertwo-wrap input[name = 's']")
    private WebElementFacade searchField;

    @FindBy (css = ".headertwo-wrap button")
    private WebElementFacade searchButton;

    @FindBy (css = "a.cart-contents")
    private WebElementFacade yourCartLink;

    @FindBy (css = ".site-title")
    private WebElementFacade logo;

    //*
    //These are the methods for/interactions with the navigation buttons:
    //*

    public void clickHomeNavigationButton(){
        clickOn(homeNavigationButton);
    }

    public void clickMyAccountNavigationButton(){
        clickOn(myAccountNavigationButton);
    }

    public void clickCheckoutNavigationButton(){
        clickOn(checkoutNavigationButton);
    }

    public void clickCartNavigationButton(){
        clickOn(cartNavigationButton);
    }

    public void clickShopNavigationButton(){
        clickOn(shopNavigationButton);
    }

    //*
    //These are the methods for/interactions with the rest of the elements from the Homepage header:
    //*

    public void clickLogo(){
        clickOn(logo);
    }

    public void setSearchField(String searchedText){
        typeInto(searchField, searchedText);
    }

    public void clickSearchButton() { clickOn(searchButton); }

    public void clickLoginLink() { clickOn(loginLink); }

    public void clickYourCartLink() { clickOn(yourCartLink); }




}
