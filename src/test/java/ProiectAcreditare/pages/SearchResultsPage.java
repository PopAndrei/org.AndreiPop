package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class SearchResultsPage extends PageObject {




    //*
    //These are the methods and exercises from class
    //******************************************************************************************************



//    @FindBy (css = )
//    private WebElementFacade topSortByDropdown;
//
//    @FindBy (css = "")
//    private List<WebElementFacade> listOfProducts;
//
//
//    public void selectFromDropdown(String text){
//        topSortByDropdown.selectByVisibleText(text);
//    }
//
//    public boolean checkProductsPrices(){
//
//        int priceCurrent;
//        int priceNext;
//        for(int i = 0; i <= listOfProducts.size() - 2; i++ ){
//            try {
//                String priceI = listOfProducts.get(i)
//                        .findBy(By.cssSelector(".price:not([id*='old'])"))
//                        .getText()
//                        .replace(",00 RON", "")
//                        .trim();
//                priceCurrent = Integer.valueOf(priceI);
//
//                String priceI2 = listOfProducts.get(i + 1).findBy(By.cssSelector(".price:not([id*='old'])")).getText().replace(",00 RON", "").trim();
//                priceNext = Integer.valueOf(priceI2);
//
//                System.out.println("Int de i : " + i);
//
//                if (priceCurrent > priceNext) {
//                    return false;
//                }
//            }catch(NoSuchElementException e){
//                continue;
//            }
//        }
//        return true;
//    }

}
