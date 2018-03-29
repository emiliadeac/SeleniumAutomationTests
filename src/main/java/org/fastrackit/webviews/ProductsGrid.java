package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGrid {
    @FindBy (css = ".product-name a")
    private List <WebElement> productNames;

    public List<WebElement> getProductNames() {
        return productNames;
    }

    @FindBy (id= "product-collection-image-421")
    private WebElement productLink;

    @FindBy (xpath = "//div[@class='actions']//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy (className = "regular-price")
    private WebElement productPrice;

    @FindBy (xpath = "//h1")
    private WebElement pageTitle;

    @FindBy (xpath = "//select[@title=\"Results per page\"]")
    private WebElement selectDispayProductNumber;

    @FindBy (xpath = "//select[@title=\"Results per page\"]//option[@selected=\"selected\"]")
    private WebElement selectedShowValue;

    @FindBy (xpath = "//img[@title= \"Black\"]")
    private WebElement blackColorOption;

    @FindBy (xpath = "//div[@class=\"currently\"]//img[@title=\"Black\"]")
    private WebElement filterByBlackColor;

    @FindBy (xpath = "//a [@class= \"btn-remove\"]")
    private WebElement removeFilterIcon;

    @FindBy (xpath = "//div[@class=\"actions\"]//a[contains(text(), \"Clear All\")]")
    private WebElement clearAllFiltersLink;

    @FindBy (xpath = "//dl[@id=\"narrow-by-list\"]//dt[contains(text(),'Color')]")
    private WebElement colorHeadTable;

    @FindBy (xpath = "//select[@title= \"Sort By\"]//option[@selected=\"selected\"]")
    private WebElement selectedSortByOption;

    @FindBy (xpath = "//div[@class=\"sort-by\"]//a[@class=\"sort-by-switcher sort-by-switcher--asc\"]")
    private WebElement changeProductsOrder;

    @FindBy (className="list")
    private WebElement listIcon;

    @FindBy (xpath="//strong[@class=\"list\"]")
    private WebElement selectedListOption;

    @FindBy (xpath="//p[@class=\"amount amount--no-pages\"]")
    private WebElement numberOfProductsDisplayed;

    @FindBy (xpath = "//a[@class=\"link-compare\"]")
    private WebElement compareLinks;

    @FindBy (xpath = "//a[@title= \"Broad St. Flapover Briefcase\"]")
    private WebElement productImageLink;

    @FindBy (xpath = "//a[contains(text (), \"Leather\")]//span[@class=\"count\"]")
    private WebElement numberOfProductsOnFilter;

    @FindBy (xpath = "//a[contains(text (), \"Leather\")]")
    private WebElement leatherFilterLink;


    public WebElement getLeatherFilterLink() {
        return leatherFilterLink;
    }

    public WebElement getNumberOfProductsOnFilter() {
        return numberOfProductsOnFilter;
    }

    public WebElement getProductImageLink() { return productImageLink; }

    public WebElement getCompareLinks() { return compareLinks; }

    public WebElement getNumberOfProductsDisplayed() { return numberOfProductsDisplayed; }

    public WebElement getSelectedListOption() {
        return selectedListOption;
    }

    public WebElement getListIcon() {
        return listIcon;
    }

    public WebElement getChangeProductsOrder() {
        return changeProductsOrder;
    }

    public WebElement getSelectedSortByOption() {
        return selectedSortByOption;
    }

    public WebElement getClearAllFiltersLink() {
        return clearAllFiltersLink;
    }

    public WebElement getColorHeadTable() {
        return colorHeadTable;
    }

    public WebElement getRemoveFilterIcon() {
        return removeFilterIcon;
    }

    public WebElement getFilterByBlackColor() {
        return filterByBlackColor;
    }


    public WebElement getBlackColorOption() {
        return blackColorOption;
    }

    public WebElement getSelectedShowValue() {
        return selectedShowValue;
    }

    public WebElement getSelectDispayProductNumber() {
        return selectDispayProductNumber;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }





    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getProductLink() { return productLink;
    }
}
