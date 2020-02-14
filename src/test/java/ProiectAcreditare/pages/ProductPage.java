package ProiectAcreditare.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {

    //*
    //These are the elements of the Product Pages
    //*

    @FindBy(id = "tab-description")
    private WebElementFacade descriptionTitle;

    @FindBy(css = ".entry-summary .product_title")
    private WebElementFacade productTitle;


    //*
    //These are the methods for/interactions with the elements of the Product Page
    //*

    public boolean checkIfDescriptionIsVisible(){
        return descriptionTitle.isCurrentlyVisible();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }


}
