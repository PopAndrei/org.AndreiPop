package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")
public class CartPage extends PageObject {

    //*
    //These are the elements that are present when the Cart is Empty
    //*

    @FindBy(css = ".cart-empty")
    private WebElementFacade emptyCartMessage;

    @FindBy (css = ".button.wc-backward[href*='page_id']")
    private WebElementFacade returnToShopButton;


    //*
    //These are the elements that are present when the Cart is NOT Empty.
    //Although I must say that I did not find a way to correctly get the css for the prices - it is a very big mess there with the prices!!!
    //In a real situation like this, I would definitely talk to the Devs to ask them to fix the css.
    //*

    @FindBy(css = ".product-name [href*='=cap']")
    private WebElementFacade product28NameFromCart;

    @FindBy (css = ".woocommerce .amount:first-child")
    private WebElementFacade product28PriceFromCart;

    @FindBy(css = ".remove[data-product_id='28']")
    private WebElementFacade product28RemoveButton;

    @FindBy(css = ".product-name [href*='belt']")
    private WebElementFacade product27NameFromCart;

    @FindBy (css = ".remove[data-product_id='27']")
    private WebElementFacade product27RemoveButton;



    //*
    //These are the methods/ interactions with the elements from the Cart Page
    //*

    public void clickProduct28RemoveButton(){
        clickOn(product28RemoveButton);
    }

    public void clickProduct27RemoveButton(){
        clickOn(product27RemoveButton);
    }

    public boolean checkCartIsEmpty(){
        waitABit(350);
        return emptyCartMessage.isCurrentlyVisible();
    }


    // I can't seem to find the right CSS for the Price element if this item, in the Cart.
//    @FindBy (css =  )
//    private WebElementFacade product27PriceFromCart;

    //*
    //This is the method I wrote while trying to get the text out of the WebElementFacade.
    //*

    public String product28NameFromCart(){
        return product28NameFromCart.getText();
    }

    //*
    //This is the method for checking the added product name.
    //*

    public boolean verifyProduct28NameFromCart(String productName){
        return product28NameFromCart.containsOnlyText(productName);
    }



}
