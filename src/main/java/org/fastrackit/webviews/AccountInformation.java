package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInformation {
    @FindBy (xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitle;

    public WebElement getPageTitle() {
        return pageTitle;
    }
}
