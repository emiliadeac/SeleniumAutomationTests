package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy(className= "option-pink")
    private WebElement pinkColor;

    @FindBy(className= "option-s")
    private WebElement size;

    @FindBy(className = "add-to-cart-buttons")
    private WebElement addToCart;

    @FindBy(xpath = "//input[@id=\"qty\"]")
    private WebElement quantityField;

    @FindBy (xpath = "//button[@title=\"Update Cart\"]")
    private WebElement updateCartButton;

    @FindBy(xpath = "//div[@class=\"product-name\"]//span[@class=\"h1\"]")
    private WebElement pageTitle;

    @FindBy (xpath = "//a[contains(@id, \"swatch21\")]")
    private WebElement colorName;

    @FindBy (xpath = "//a[contains(@id,'swatch80')]")
    private WebElement sizeOption;

    public WebElement getSizeOption() {
        return sizeOption;
    }

    public WebElement getColorName() {
        return colorName;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getUpdateCartButton() {
        return updateCartButton;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public WebElement getAddToCart() { return addToCart; }

    public WebElement getSize() {
        return size;
    }

    public WebElement getPinkColor() {
        return pinkColor;
    }
}
