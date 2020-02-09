package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.CartPage;
import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps {

    HomePage homePage;
    ShopPage shopPage;
    CartPage cartPage;

    @Step
    public boolean checkCorrectProductAddedToCart(String productFromShop, String productFromCart){
        productFromShop = shopPage.getProduct28Name();
        productFromCart = cartPage.product28NameFromCart();
        Assert.assertEquals(productFromShop, productFromCart);
    }
}
