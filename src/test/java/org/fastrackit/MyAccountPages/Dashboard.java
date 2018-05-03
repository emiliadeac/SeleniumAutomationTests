package org.fastrackit.MyAccountPages;

import org.fastrackit.TestBase;
import org.fastrackit.webviews.AccountInformation;
import org.fastrackit.webviews.Header;
import org.fastrackit.webviews.LoginForm;
import org.fastrackit.webviews.MyDashboard;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class Dashboard extends TestBase {


    @Test
    public void viewDashboardPage () throws InterruptedException {
        Header header=PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();

        LoginForm loginForm = PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("emiliadeac95@gmail.com");
        loginForm.getPasswordField().sendKeys("asdfghjkl");
        loginForm.getLoginButton().click();

        String expectedMessage = "MY DASHBOARD";
        MyDashboard myDashboard = PageFactory.initElements(driver, MyDashboard.class);
        String actualMessage = myDashboard.getPageTitle().getText();
        assertThat ("Page titles do not match", expectedMessage, is (actualMessage));

    }

    @Test
    public void clickEditContactLink(){
        Header header=PageFactory.initElements(driver, Header.class);
        header.getAccountLink().click();
        header.getLoginLink().click();

        LoginForm loginForm = PageFactory.initElements(driver, LoginForm.class);
        loginForm.getEmailField().sendKeys("emiliadeac95@gmail.com");
        loginForm.getPasswordField().sendKeys("asdfghjkl");
        loginForm.getLoginButton().click();

        MyDashboard myDashboard = PageFactory.initElements(driver, MyDashboard.class);
        myDashboard.getEditContactLink().click();

        AccountInformation accountInformation= PageFactory.initElements(driver, AccountInformation.class);
        String actualRedirectedPage =accountInformation.getPageTitle().getText();
        String expectedRedirectedPage= "EDIT ACCOUNT INFORMATION";
        assertThat ("Page titles do not match", actualRedirectedPage, is (expectedRedirectedPage));


    }







}
