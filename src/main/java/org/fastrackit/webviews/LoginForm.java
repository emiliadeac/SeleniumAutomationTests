package org.fastrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm {

    @FindBy (xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy (xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy (name = "send")
    private WebElement loginButton;



    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getEmailField() {
        return emailField;
    }
}
