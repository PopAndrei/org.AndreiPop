package ProiectAcreditare.pages;

import jnr.ffi.annotations.In;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ClearContents;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")
public class CartPage extends PageObject {

    private WebDriver driver;

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

    @FindBy (css = "#post-5 > div > div > div > div > form > table > tbody > tr:nth-child(2) > td.product-price > span")
    private WebElementFacade product28PriceFromCart;

    @FindBy(css = ".remove[data-product_id='28']")
    private WebElementFacade product28RemoveButton;

    @FindBy(css = ".product-name a[href*='belt']")
    private WebElementFacade product27NameFromCart;

    @FindBy(css = ".woocommerce .amount:first-child")
    private WebElementFacade product27PriceFromCart;

    @FindBy (css = ".remove[data-product_id='27']")
    private WebElementFacade product27RemoveButton;

    @FindBy(css = ".input-text.qty[aria-labelledby*='Cap']")
    private WebElementFacade prod28QuantitySelector;

    @FindBy(css = ".input-text.qty[aria-labelledby*='Belt']")
    private WebElementFacade prod27QuantitySelector;

    @FindBy(css = ".actions [name='update_cart']")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".order-total strong")
    private WebElementFacade orderTotal;

    @FindBy(css = ".wc-proceed-to-checkout .checkout-button")
    private WebElementFacade proceedToCheckoutButton;



    //*
    //These are the methods/ interactions with the elements from the Cart Page
    //*

    public void clickProduct28RemoveButton(){
        clickOn(product28RemoveButton);
    }

    public void clickProduct27RemoveButton(){
        clickOn(product27RemoveButton);
    }

    public void setProd28Quantity(String newQauantity){
        withAction().doubleClick(prod28QuantitySelector);
        //clickOn(prod28QuantitySelector);
       // ClearContents.ofElement(prod28QuantitySelector);
        typeInto(prod28QuantitySelector, newQauantity);
    }

    public void setProd27Quantity(String newQauantity){
        withAction().doubleClick(prod27QuantitySelector);
        // clickOn(prod27QuantitySelector);
       // ClearContents.ofElement(prod27QuantitySelector);
        typeInto(prod27QuantitySelector, newQauantity);
    }

    public void clickOnUpdateCartButton(){
        clickOn(updateCartButton);
    }

    public String getTotalPriceFromCart() {
        return orderTotal.getText();
    }

    public void clickOnProceedToCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }



    // I can't seem to find the right CSS for the Price element if this item, in the Cart.
//    @FindBy (css =  )
//    private WebElementFacade product27PriceFromCart;


    public String product28NameFromCart(){
        return product28NameFromCart.getText();
    }

    public String product27NameFromCart(){
        return product27NameFromCart.getText();
    }

    //*
    //This is the method for checking the added product name.
    //*

    public boolean verifyProduct28NameFromCart(String productName){
        return product28NameFromCart.containsOnlyText(productName);
    }


    //*
    //This is the method for checking the empty cart page
    //*

    public boolean checkCartIsEmpty(){
        waitABit(350);
        return emptyCartMessage.isCurrentlyVisible();
    }

    //*
    //This is the method for checking the current URL
    //*

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }


    //*
    //This is the method for checking the product quantities and total
    //*

    public boolean checkTotalSum(String prod28Qty, String prod27Qty){
        waitABit(3000);
        String prod28Price = product28PriceFromCart.getText().replace("lei","").replace(".00","").trim();
        String prod27Price = product27PriceFromCart.getText().replace("lei","").replace(".00","").trim();

        int firstProductPrice = Integer.parseInt(prod28Price);
        int secondProductPrice = Integer.parseInt(prod27Price);

//        String prod28Quantity = prod28Qty;
//        String prod27Quantity = prod27Qty;

        int firstProdQuantity = Integer.parseInt(prod28Qty);
        int secondProdQuantity = Integer.parseInt(prod27Qty);

        int calculatedSum = (firstProductPrice * firstProdQuantity) + (secondProductPrice * secondProdQuantity);

        String displayedTotal = orderTotal.getText().replace("lei","").replace(".00","").trim();
        int displayedSum = Integer.parseInt(displayedTotal);

        if(calculatedSum == displayedSum){
            return true;
        }
        else return false;

    }


}
