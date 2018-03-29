package org.fastrackit.webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    public static WebDriver driver;
    @FindBy (id= "search")
    private WebElement searchField;

    @FindBy (id= "select-language")
    private WebElement languageDropdownList;

    @FindBy (className = "skip-account")
    private WebElement accountLink;

    @FindBy (xpath = "//a[@title=\"Log In\"]")
    private WebElement loginLink;

    @FindBy (xpath = "//a[@title= 'Log Out']")
    private WebElement logoutLink;

    @FindBy (className = "header-minicart")
    private WebElement cartLink;

    @FindBy (className= "nav-6")
    private WebElement VipLink;

    public WebElement getVipLink() {
        return VipLink;
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getAccountLink() {
        return accountLink;
    }

    public void search (String keyword){
        searchField.sendKeys(keyword+ Keys.ENTER);
        System.out.println("Pressed Enter in Search key");
    }
    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getLanguageDropdownList() {
        return languageDropdownList;
    }


}
