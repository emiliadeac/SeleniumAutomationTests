package org.fastrackit.cart;

import org.fastrackit.TestBase;
import org.fastrackit.webviews.Header;
import org.fastrackit.webviews.PopupCart;
import org.fastrackit.webviews.ProductPage;
import org.fastrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.fastrackit.webviews.Header.driver;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CartPopup extends TestBase{
    @Test
    public void checkNumberAndPrice () throws InterruptedException {
        By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
        By eyewearCategoryLocator = By.xpath("//a[text()='Eyewear']");
        mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, eyewearCategoryLocator));
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String expectedPrice = productsGrid.getProductPrice().getText();
        productsGrid.getAddToCartButton().click();
        Header header = PageFactory.initElements(driver, Header.class);
        header.getCartLink().click();
        String expectedCartNoItems = "1";
        PopupCart popupCart = PageFactory.initElements(driver, PopupCart.class);
        String actualPrice = popupCart.getProductPrice().getText();
        String actualCartNoItems = popupCart.getCartValue().getAttribute("value");
        assertThat("The value does not match", actualCartNoItems, is(expectedCartNoItems));
        assertThat("Product prices does not match", actualPrice, is(expectedPrice));
    }
    @Test
    public void changeProductValue () throws InterruptedException {
        By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
        By eyewearCategoryLocator = By.xpath("//a[text()='Eyewear']");
        mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, eyewearCategoryLocator));
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getAddToCartButton().click();
        Header header = PageFactory.initElements(driver, Header.class);
        header.getCartLink().click();
        PopupCart popupCart = PageFactory.initElements(driver, PopupCart.class);
        popupCart.getCartValue().clear();
        popupCart.getCartValue().sendKeys("2");
        Thread.sleep(1000);
        popupCart.getOkButton().click();
        String expectedQtn = "2";
        String actualQtn = popupCart.getCartValue().getAttribute("value");

        assertThat("The quantity does dot match", expectedQtn, is(actualQtn));
    }

    @Test
    public void verifyNotificationMessageIsDisplayedWheChangingCartValue() throws InterruptedException {
        By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
        By eyewearCategoryLocator = By.xpath("//a[text()='Eyewear']");
        mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, eyewearCategoryLocator));
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getAddToCartButton().click();
        Header header = PageFactory.initElements(driver, Header.class);
        header.getCartLink().click();
        PopupCart popupCart = PageFactory.initElements(driver, PopupCart.class);
        popupCart.getCartValue().clear();
        popupCart.getCartValue().sendKeys("2");
        popupCart.getOkButton().click();
        Thread.sleep(3000);

        String expectedMessage = "Item was updated successfully.";
        String actualMessage= popupCart.getCartSuccesfullyUpdatedMessage().getText();

        assertThat("The notification messages do not match", actualMessage, is(expectedMessage) );

    }



        @Test
     public void checkingCartTotalAmount () throws InterruptedException {
            By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
            By eyewearCategoryLocator = By.xpath("//a[text()='Eyewear']");
            mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, eyewearCategoryLocator));
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            productsGrid.getAddToCartButton().click();
            Header header = PageFactory.initElements(driver, Header.class);
            header.getCartLink().click();
            PopupCart popupCart = PageFactory.initElements(driver, PopupCart.class);
            popupCart.getCartValue().clear();
            popupCart.getCartValue().sendKeys("2");
            Thread.sleep(1000);
            popupCart.getOkButton().click();
            Thread.sleep(5000);

            String price=popupCart.getProductPrice().getText();
            String[] priceParts =price.split(" ");
            String priceNumber=priceParts[0];
            priceNumber=priceNumber.replace(",",".");
            double parsedPrice = Double.parseDouble(priceNumber);

            String subtotal=popupCart.getSubtotal().getText();
            String [] subtotalParts=subtotal.split(" ");
            String subtotalNumber=subtotalParts [0];
            subtotalNumber=subtotalNumber.replace(",", ".");
            double parsedSubtotal = Double.parseDouble(subtotalNumber);


            assertThat("The total amounts does not match", parsedSubtotal, is((2*parsedPrice)));
        }
        @Test
    public void productValueChangedUsingEditLink () throws InterruptedException {
            By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
            By eyewearCategoryLocator = By.xpath("//a[text()='Eyewear']");
            mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, eyewearCategoryLocator));

            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            productsGrid.getAddToCartButton().click();

            Header header = PageFactory.initElements(driver, Header.class);
            header.getCartLink().click();

            PopupCart popupCart = PageFactory.initElements(driver, PopupCart.class);
            popupCart.getEditItemLink().click();
            Thread.sleep(5000);

            ProductPage productPage= PageFactory.initElements(driver, ProductPage.class);
            productPage.getQuantityField().clear();
            productPage.getQuantityField().sendKeys("3");
            productPage.getUpdateCartButton().click();

            header.getCartLink().click();
            String actualCartValue= popupCart.getCartValue().getText();
            String expectedCartValue= "3";
            assertThat("The popup cart did not updated", actualCartValue, is(expectedCartValue));






        }




    }












