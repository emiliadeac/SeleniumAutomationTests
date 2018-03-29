package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart {


    @FindBy(xpath = "//div[@class=\"page-title title-buttons\"]//button")
    private WebElement proceedCheckout;

    @FindBy(id= "onepage-guest-register-button")
    private WebElement continueAsGuest;



    public WebElement getContinueAsGuest() {
        return continueAsGuest;
    }

    public WebElement getProceedCheckout() {
        return proceedCheckout;
    }
}

