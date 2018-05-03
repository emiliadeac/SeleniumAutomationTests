package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboard {
    @FindBy(xpath = "//div[contains(@class,\"page-title\")]//h1")
    private WebElement pageTitle;

    @FindBy (xpath= "//div[@class= \"box-title\"]//a")
    private WebElement editContactLink;

    @FindBy (className = "hello")
    private WebElement helloName;

    public WebElement getHelloName() {
        return helloName;
    }

    public WebElement getEditContactLink() {
        return editContactLink;
    }

    public WebElement getPageTitle() { return pageTitle; }

}
