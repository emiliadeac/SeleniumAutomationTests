package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart {


    @FindBy(xpath = "//div[@class=\"page-title title-buttons\"]//button")
    private WebElement proceedCheckout;

    @FindBy(id= "onepage-guest-register-button")
    private WebElement continueAsGuest;

    @FindBy (className = "success-msg")
    private WebElement successMessage;

    @FindBy (xpath = "//h2[@class=\"product-name\"]")
    private WebElement productName;

    @FindBy (xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/dl/dd[1]")
    private WebElement colorName;

    @FindBy (xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/dl/dd[2]")
    private WebElement size;

    public WebElement getSize() {
        return size;
    }

    public WebElement getColorName() {
        return colorName;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getContinueAsGuest() {
        return continueAsGuest;
    }

    public WebElement getProceedCheckout() {
        return proceedCheckout;
    }
}

