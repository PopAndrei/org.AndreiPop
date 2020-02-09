package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?post_type=product")
public class ShopPage extends PageObject {

    //*
    //These are the elements from the Shop Page
    //*

    @FindBy(css = ".post-28.product")
    private WebElementFacade product28;

    @FindBy(css = ".post-28 h3")
    private WebElementFacade prodcut28Name;

    @FindBy(css = ".post-28 .price ins .amount")
    private WebElementFacade prodcut28Price;

    @FindBy(css = ".post-28 .add_to_cart_button")
    private WebElementFacade product28AddToCartButton;

    @FindBy(css = ".post-28 .added_to_cart")
    private WebElementFacade product28ViewCartButton;

    @FindBy(css = ".post-27.product")
    private WebElementFacade product27;

    @FindBy(css = ".post-28 h3")
    private WebElementFacade prodcut27Name;

    @FindBy(css = ".post-27 .price ins .amount")
    private WebElementFacade prodcut27Price;

    @FindBy(css = ".post-27 .add_to_cart_button")
    private WebElementFacade product27AddToCartButton;

    @FindBy(css = ".post-27 .added_to_cart")
    private WebElementFacade product27ViewCartButton;



    //*
    //These are the methods/interactions with the elements from the Shop Page
    //*

    public void clickProduct28AddToCartButton() {
        clickOn(product28AddToCartButton);
    }

    public void clickProduct28ViewCartButton() {
        clickOn(product28ViewCartButton);
    }

    public String getProduct28Name(){
        return prodcut28Name.getText();
    }

    public String getProduct28Price(){
        return prodcut28Price.getText();
    }

    public void clickProduct27AddToCartButton() {
        clickOn(product27AddToCartButton);
    }

    public void clickProduct27ViewCartButton() {
        clickOn(product27ViewCartButton);
    }

    public String getProduct27Name(){
        return prodcut27Name.getText();
    }

    public String getProduct27Price (){
        return prodcut27Price.getText();
    }


    //*
    //These are the methods/asserts that verify or check the elements from the Shop Page
    //*






}
