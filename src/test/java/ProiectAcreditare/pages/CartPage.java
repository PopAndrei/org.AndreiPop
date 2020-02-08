package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")
public class CartPage extends PageObject {

    //*
    //These are the elements that are present when the Cart is Empty
    //*


    @FindBy(css = ".cart-empty")
    private WebElementFacade emptyCartMessage;

    @FindBy (css = ".button.wc-backward[href*='page_id']")
    private WebElementFacade returnToShopButton;



}
