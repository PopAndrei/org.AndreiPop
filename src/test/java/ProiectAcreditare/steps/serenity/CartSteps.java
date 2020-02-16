package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.CartPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CartSteps {

    private ShopPage shopPage;
    private CartPage cartPage;


    //*
    //These are the Steps for checking the added Products
    //*

    @Step
    public void compareNameOfProductAddedToCart(String productNameFromShop){
       Assert.assertTrue(cartPage.product28NameFromCart().contentEquals(productNameFromShop));
    }

    @Step
    public void compareNamesOfTwoProductsAddedToCart(String product28Name, String product27Name){
        Assert.assertTrue(cartPage.product28NameFromCart().contentEquals(product28Name)
                &&
                cartPage.product27NameFromCart().contentEquals(product27Name));
    }

    @Step
    public void verifyNameOfAddedProductToCart(String productName){
        Assert.assertTrue(cartPage.verifyProduct28NameFromCart(productName));
    }

    @Step
    public void verifyTotalSumFromCart(String prod28QTY, String prod27QTY){
        Assert.assertTrue(cartPage.checkTotalSum(prod28QTY,prod27QTY));
    }

    @Step
    public String getTotalSumPriceFromCart(){
        return cartPage.getTotalPriceFromCart();
    }



    //*
    //These are the Steps for changing the quantity of the products in the cart
    //*

    @Step
    public void setProd28Quantity(String newQuantity){
        cartPage.setProd28Quantity(newQuantity);
    }

    @Step
    public void setProd27Quantity(String newQuantity){
        cartPage.setProd27Quantity(newQuantity);
    }

    @Step
    public void clickOnUpdateCartButton(){
        cartPage.clickOnUpdateCartButton();
    }


    //*
    //These are the removing products Steps
    //*

    @Step
    public void removeOneProductFromCart() {
        cartPage.clickProduct28RemoveButton();
    }

    @Step
    public void removeTwoProductsFromCart(){
        cartPage.clickProduct28RemoveButton();
        cartPage.clickProduct27RemoveButton();
    }


    //*
    //These are the Verifying / Asserting methods for the Empty Cart
    //*

    @Step
    public void checkCartIsEmpty(){
        Assert.assertTrue(cartPage.checkCartIsEmpty());
    }

}
