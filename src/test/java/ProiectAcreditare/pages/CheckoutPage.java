package ProiectAcreditare.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=6")
public class CheckoutPage extends PageObject {

    //*
    //These are the FIELD + DropDown elements on the Checkout Page / although the page can only be accessed if
    // there is a product already in the cart;
    //*

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameField;

    @FindBy(id = "select2-billing_country-container")
    private WebElementFacade countryDropdown;

    @FindBy(css = ".select2-search__field[role='combobox']")
    private WebElementFacade countryDropdownSearchField;

    @FindBy(id = "select2-billing_country-result-tnzp-RO")
    private WebElementFacade countryRomania;

    @FindBy(css = ".select2-results__option.select2-results__option--highlighted")
    private WebElementFacade countrySearchResult;

    @FindBy(id = "billing_address_1")
    private WebElementFacade streetAddressField;

    @FindBy(id = "billing_city")
    private WebElementFacade townCityField;

    @FindBy(id = "billing_postcode")
    private WebElementFacade postcodeField;

    @FindBy(id = "billing_phone")
    private WebElementFacade phoneField;

    @FindBy(id = "billing_email")
    private WebElementFacade emailField;

    @FindBy (css = ".order-total .amount")
    private WebElementFacade orderTotalFromCheckoutPage;

    //*
    //These are the elements that are present AFTER the Placing of the Order on the CheckoutPage;
    //*

    @FindBy(css = ".content-inner .post-title")
    private WebElementFacade orderReceivedText;

    @FindBy(css = ".product-name a")
    private WebElementFacade product28NameOnOrder;

    @FindBy(css = ".woocommerce-notice.woocommerce-thankyou-order-received")
    private WebElementFacade thankYouMessage;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span")
    private WebElementFacade orderReceivedTotal;


    //*
    //These are the button elements from the Checkout Page;
    //*

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;


    //*
    //These are the interactions/methods for COMPLETING the elements from the Checkout Page;
    //*

    public void fillFirstNameField(String firstName){
        typeInto(firstNameField, firstName);
    }

    public void fillLastNameField(String lastName){
        typeInto(lastNameField, lastName);
    }


    public void setCountryDropdown(String countryName){
        clickOn(countryDropdown);
        typeInto(countryDropdownSearchField, countryName);
        clickOn(countrySearchResult);
    }

    public void fillStreetAddressField(String streetAddress){
        typeInto(streetAddressField, streetAddress);
    }

    public void fillTownCityField(String cityName){
        typeInto(townCityField, cityName);
    }

    public void fillPostalCodeField(String postCode){
        typeInto(postcodeField, postCode);
    }

    public void fillPhoneField(String phoneNumber){
        typeInto(phoneField, phoneNumber);
    }

    public void fillEmailField(String email){
        typeInto(emailField, email);
    }

    //*
    //These are the interactions/methods for the Verifying of the Placed Order;
    //*

    public boolean checkOrderIsPlacedTitle(String text){
        waitABit(4000);
        waitFor(orderReceivedText);
        return orderReceivedText.containsOnlyText(text);
    }

    public String product28NameFromOrder(){
        return product28NameOnOrder.getText();
    }

    public boolean checkThankYouMessage(String thankYouText){
        waitFor(thankYouMessage);
        return thankYouMessage.containsOnlyText(thankYouText);
    }

    public boolean compareCartTotal2OrderTotal(String totalFromCart){
        String textTotalFromCart = totalFromCart.replace("lei","").replace(".00","").trim();
        int intTotalFromCart = Integer.parseInt(textTotalFromCart);

        String textOrderTotalFromCheckoutPage = orderTotalFromCheckoutPage.getText()
                .replace("lei","")
                .replace(".00","")
                .trim();
        int intOrderTotalFromCheckout = Integer.parseInt(textOrderTotalFromCheckoutPage);

        if(intTotalFromCart == intOrderTotalFromCheckout){
            return true;
        }
        else return false;
    }


    public boolean compareOrderTotal2OrderReceived(String totalFromCart){
        String textTotalFromCart = totalFromCart.replace("lei","").replace(".00","").trim();
        int intTotalFromCart = Integer.parseInt(textTotalFromCart);

        String textOrderReceivedTotal = orderReceivedTotal.getText()
                .replace("lei","")
                .replace(".00","")
                .trim();
        int intOrderReceivedTotal = Integer.parseInt(textOrderReceivedTotal);

        if(intOrderReceivedTotal == intTotalFromCart){
            return true;
        }
        else return false;
    }


    //*
    //These are the interactions/methods with the button elements from the Checkout Page;
    //*

    public void clickOnPlaceOrderButton(){
        clickOn(placeOrderButton);
    }



}
