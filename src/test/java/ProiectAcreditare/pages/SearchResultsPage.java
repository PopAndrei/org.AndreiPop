package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy (css = ".category-products>.toolbar select[title='Sort By']")
    private WebElementFacade topSortByDropdown;

    @FindBy (css = ".products-grid .item.last")
    private List<WebElementFacade> listOfProducts;


    public void selectFromDropdown(String text){
        topSortByDropdown.selectByVisibleText(text);
    }

    public boolean checkProductsPrices(){

        int priceCurrent;
        int priceNext;
        for(int i = 0; i <= listOfProducts.size() - 2; i++ ){
            try {
                String priceI = listOfProducts.get(i)
                        .findBy(By.cssSelector(".price"))
                        .getText()
                        .replace(",00 RON", "")
                        .trim();
                priceCurrent = Integer.valueOf(priceI);

                String priceI2 = listOfProducts.get(i + 1).findBy(By.cssSelector(".price")).getText().replace(",00 RON", "").trim();
                priceNext = Integer.valueOf(priceI2);

                if (priceCurrent > priceNext) {
                    return false;
                }
            }catch(NoSuchElementException e){
                continue;
            }
        }
        return true;
    }

}
