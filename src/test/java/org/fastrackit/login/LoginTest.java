package org.fastrackit.login;

import org.fastrackit.TestBase;
import org.fastrackit.webviews.Header;
import org.fastrackit.webviews.LoginForm;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest  extends TestBase{

    @Test
    public void loginSuccessfully () throws InterruptedException {
        Header header= PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();
        LoginForm loginForm =PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("emiliadeac95@gmail.com");
        loginForm.getPasswordField().sendKeys("asdfghjkl");
        loginForm.getLoginButton().click();
        Thread.sleep(5000);
        String expectedLoginMessage= "Hello, Emilia Deac!";
        String actualLoginMessage = driver.findElement(By.className("hello")).getText();
        assertThat ("Login messages do not match", expectedLoginMessage, is (actualLoginMessage));
    }

    @Test
    public void emptyLoginForm () {
        Header header= PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();
        LoginForm loginForm =PageFactory.initElements(driver, LoginForm.class);
        loginForm.getLoginButton().click();
        String expectedRequiredFieldError= "This is a required field.";
        String actualRequiredEmailError= driver.findElement(By.id("advice-required-entry-email")).getText();
        String actualRequiredPasswordError= driver.findElement(By.id("advice-required-entry-pass")).getText();
        assertThat("Error text do not match with email error", expectedRequiredFieldError, is (actualRequiredEmailError));
        assertThat("Error text do not match with the password error", expectedRequiredFieldError, is (actualRequiredPasswordError));
    }

    @Test
    public void passwordTooShort () {
        Header header= PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();
        LoginForm loginForm =PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("abc@gmail.com");
        loginForm.getPasswordField().sendKeys("123");
        loginForm.getLoginButton().click();
        String expectedTooShortError= "Please enter 6 or more characters without leading or trailing spaces.";
        String actualTooShortError=driver.findElement(By.id("advice-validate-password-pass")).getText();
        assertThat("Short password messages do not match", expectedTooShortError, is(actualTooShortError));
    }

    //@Before
    //private void getObjectClass (){
    //driver=PageFactory.initElements(Header);
    private Header header;

    @Before
    public void getObjectClass ()
    {
        header= PageFactory.initElements(driver, Header.class);
    }

    @Test
    public void incorrectPassAndEmail () {

        header.getAccountLink().click();
        header.getLoginLink().click();
        LoginForm loginForm =PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("abc@gmail.com");
        loginForm.getPasswordField().sendKeys("1234567");
        loginForm.getLoginButton().click();
        String expectedInvalidCredentialsError= "Invalid login or password.";
        String actualInvalidCredentialsError= driver.findElement(By.className("error-msg")).getText();
        assertThat("Invalid credentials errors do not match", expectedInvalidCredentialsError, is (actualInvalidCredentialsError));
    }

    @Test
    public void logoutSuccesfully () {
        Header header= PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();
        LoginForm loginForm =PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("emiliadeac95@gmail.com");
        loginForm.getPasswordField().sendKeys("asdfghjkl");
        loginForm.getLoginButton().click();
        header.getAccountLink().click();
        header.getLogoutLink().click();
        String expectedLogoutMessage= "YOU ARE NOW LOGGED OUT";
        String actualLogoutMessage= driver.findElement(By.className("page-title")).getText();
        assertThat("User is not logged out", expectedLogoutMessage, is(actualLogoutMessage));
    }



}
