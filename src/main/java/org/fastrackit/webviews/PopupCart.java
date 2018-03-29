package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupCart {
    @FindBy(xpath = "//input[contains(@class,'qty cart-item-quantity')]")
    private WebElement cartValue;


    @FindBy (className = "price")
    private WebElement productPrice;

    @FindBy (className = "regular-price")
    private WebElement priceAmount;

    @FindBy (className = "quantity-button")
    private WebElement okButton;

    @FindBy (xpath = "//p[@class=\"subtotal\"]//span[@class=\"price\"]")
    private WebElement subtotal;

    @FindBy(id= "minicart-success-message")
    private WebElement cartSuccesfullyUpdatedMessage;

    @FindBy (xpath = "//a[@title=\"Edit item\"]")
    private WebElement editItemLink;

    public WebElement getEditItemLink() {
        return editItemLink;
    }

    public WebElement getCartSuccesfullyUpdatedMessage() {
        return cartSuccesfullyUpdatedMessage;
    }

    public WebElement getSubtotal() {
        return subtotal;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public WebElement getPriceAmount() {
        return priceAmount;}

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getCartValue() {
            return cartValue;
        }
    }

