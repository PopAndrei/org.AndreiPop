package ProiectAcreditare.steps.serenity;

import ProiectAcreditare.pages.HomePage;
import ProiectAcreditare.pages.LoginPage;
import ProiectAcreditare.pages.ProductPage;
import ProiectAcreditare.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps {

    HomePage homePage;
    ShopPage shopPage;
    ProductPage productPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void insertSearchText(String searchText){
        homePage.setSearchField(searchText);
    }

    @Step
    public void clickSearchButton(){
        homePage.clickSearchButton();
    }

    @Step
    public void checkSearchedProductResult(String searchText){
        Assert.assertTrue(productPage.getProductTitle().contentEquals(searchText));
    }
}
