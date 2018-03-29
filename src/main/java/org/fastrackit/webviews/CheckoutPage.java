package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy (id= "billing:firstname")
    private WebElement firstNameField;

    @FindBy(id= "billing:lastname")
    private WebElement lastNameField;

    @FindBy(id="billing:email")
    private WebElement emailField;

    @FindBy (id= "billing:street1")
    private WebElement addressField;

    @FindBy (id= "billing:city")
    private WebElement cityField;

    @FindBy (id= "billing:region_id")
    private WebElement statedropdownField;

    @FindBy (id= "billing:country_id")
    private WebElement coutryDropdownField;

    @FindBy (id= "billing:postcode")
    private WebElement postcodeField;

    @FindBy (id= "billing:telephone")
    private WebElement telephoneField;

    @FindBy (xpath= "//button[@title= \"Continue\"]")
    private WebElement continueButton;

    @FindBy (xpath = "//label[@for= \"s_method_ups_XPD\"]")
    private WebElement worldwideCheckbox;

    @FindBy (className = "btn-checkout")
    private WebElement placeOrderButton;

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getContinueStep4() {
        return continueStep4;
    }


    @FindBy (xpath = "//li[contains(@class, 'section allow active')]//button")
    private WebElement continueStep4;



    public WebElement getWorldwideCheckbox() {
        return worldwideCheckbox;
    }

    public WebElement getTelephoneField() {
        return telephoneField;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getPostcodeField() {
        return postcodeField;
    }

    public WebElement getStatedropdownField() {
        return statedropdownField;
    }

    public WebElement getCoutryDropdownField() {
        return coutryDropdownField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }
}
