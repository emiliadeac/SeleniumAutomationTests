package org.fastrackit.cart;

import org.fastrackit.AppConfig;
import org.fastrackit.TestBase;
import org.fastrackit.webviews.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

import org.fastrackit.webviews.ProductsGrid;
import org.fastrackit.webviews.ProductsGrid;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest extends TestBase {


    @Test
    public void addProductToCart() {
        By womenCategoryLocator = By.xpath("//a[text()='Women']");
        By newArrivalsCategoryLocator = By.xpath("//a[text()='New Arrivals']");
        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalsCategoryLocator));

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getProductLink().click();

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.getPinkColor().click();
        productPage.getSize().click();
        productPage.getAddToCart().click();

        ShoppingCart shoppingCart=PageFactory.initElements(driver, ShoppingCart.class);
        String actualSuccesMessage=shoppingCart.getSuccessMessage().getText();
        String expectedSuccesMessage="Elizabeth Knit Top was added to your shopping cart.";

        String actualProductAddedToCart= shoppingCart.getProductName().getText();
        String expectedProductAddedToCart= "ELIZABETH KNIT TOP";
        assertThat ("Wrong product was added in the cart", actualProductAddedToCart, is(expectedProductAddedToCart));
        assertThat ("Incorrect message displayed", actualSuccesMessage, is(expectedSuccesMessage));

    }

    @Test
    public void addProductWithSpecificSizeAndColorToCart() {
        By womenCategoryLocator = By.xpath("//a[text()='Women']");
        By newArrivalsCategoryLocator = By.xpath("//a[text()='New Arrivals']");
        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalsCategoryLocator));

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getProductLink().click();

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        String colorname = productPage.getColorName().getAttribute("title");
        String sizeOption = productPage.getSizeOption().getAttribute("title");

        productPage.getPinkColor().click();
        productPage.getSize().click();
        productPage.getAddToCart().click();

        ShoppingCart shoppingCart=PageFactory.initElements(driver, ShoppingCart.class);
        String newColorname = shoppingCart.getColorName().getText();
        String confirmationSizeOption = shoppingCart.getSize().getText();

        assertThat("The color do not match", colorname, is(newColorname));
        assertThat("The size do not match", sizeOption, is(confirmationSizeOption) );
    }

    @Test
    public void checkoutSuccessfully () throws InterruptedException {
        By womenCategoryLocator = By.xpath("//a[text()='Women']");
        By newArrivalsCategoryLocator = By.xpath("//a[text()='New Arrivals']");
        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalsCategoryLocator));
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getProductLink().click();
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.getPinkColor().click();
        productPage.getSize().click();
        productPage.getAddToCart().click();
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        shoppingCart.getProceedCheckout().click();
        shoppingCart.getContinueAsGuest().click();
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.getFirstNameField().sendKeys("Emilia");
        checkoutPage.getLastNameField().sendKeys("Deac");
        checkoutPage.getEmailField().sendKeys("emiliadeac95@gmail.com");
        checkoutPage.getCityField().sendKeys("Cluj- Napoca");
        checkoutPage.getCoutryDropdownField().click();
        driver.findElement(By.xpath("//select[contains(@id, 'billing:country_id')]//option[text ()= 'România']")).click();
        checkoutPage.getPostcodeField().sendKeys("438793");
        Thread.sleep(1000);
        checkoutPage.getStatedropdownField().click();
        driver.findElement(By.xpath("//select[contains(@id, 'billing:region_id')]//option[text ()= 'Cluj']")).click();
        checkoutPage.getTelephoneField().sendKeys("07514387297");
        checkoutPage.getAddressField().sendKeys("test");
        checkoutPage.getContinueButton().click();
        Thread.sleep(8000);
        checkoutPage.getWorldwideCheckbox().click();
        checkoutPage.getContinueStep4().click();
        Thread.sleep(1000);
        checkoutPage.getContinueStep4().click();
        Thread.sleep(3000);
        checkoutPage.getPlaceOrderButton().click();
        checkoutPage.getPlaceOrderButton().click();
        Thread.sleep(3000);
        String expectedMessage = "YOUR ORDER HAS BEEN RECEIVED.";
        String actualMessage = driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1")).getText();
        assertThat("Actual results is different than the expected", expectedMessage, is(actualMessage));
    }
    @Test
    public void errorWhenSizeIsNotSelected () {
        By womenCategoryLocator = By.xpath("//a[text()='Women']");
        By newArrivalsCategoryLocator = By.xpath("//a[text()='New Arrivals']");
        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalsCategoryLocator));
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getProductLink().click();
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.getPinkColor().click();
        productPage.getAddToCart().click();
        String expectedError= "This is a required field.";
        String actualError= driver.findElement(By.id("advice-required-entry-attribute180")).getText();
        assertThat("The errors do not match", expectedError, is (actualError));
    }




        
        





    }




