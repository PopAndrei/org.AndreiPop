package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.CartPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps {

    ShopPage shopPage;
    CartPage cartPage;

    @Step
    public void checkNameOfProductAddedToCart(){
       Assert.assertEquals(shopPage.getProduct28Name(), cartPage.product28NameFromCart());
    }

    @Step
    public void displayNameOfProductAddedToCart(){
        System.out.println(shopPage.getProduct28Name() + cartPage.product28NameFromCart());
    }

    @Step
    public void verifyNameOfAddedProductToCart(String productName){
        Assert.assertTrue(cartPage.verifyProduct28NameFromCart(productName));
    }

}
