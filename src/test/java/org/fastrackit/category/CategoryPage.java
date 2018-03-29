package org.fastrackit.category;
import org.fastrackit.TestBase;
import org.fastrackit.webviews.Header;
import org.fastrackit.webviews.ProductPage;
import org.fastrackit.webviews.ProductsGrid;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CategoryPage  extends TestBase {

    @Test // 1. Open category page
    public void openCategoryPage() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();


        String expectedPageTitle = "VIP";

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String actualPageTitle = productsGrid.getPageTitle().getText();

        assertThat("The titles do not match", actualPageTitle, is(expectedPageTitle));
    }

    @Test //2. Filter products
    public void changeDisplayNumber() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        Select dispalyedProductsNumber = new Select(driver.findElement(By.xpath("//select[@title=\"Results per page\"]")));
        dispalyedProductsNumber.selectByVisibleText("24");

        String expectedShowValue = "                        24                    ";
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String actualShowValue = productsGrid.getSelectedShowValue().getText();

        assertThat("The show values do not match", actualShowValue, is(expectedShowValue));
    }

    @Test //3. Filter by color
    public void FilterByColor() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getBlackColorOption().click();

        String expectedColorFilter = "Black";
        String actualColorFilter = productsGrid.getFilterByBlackColor().getAttribute("title");

        assertThat("The filter colors do not match", actualColorFilter, is(expectedColorFilter));
    }


    @Test //4. Clear filter by using remove icon
    public void clearFilterUsingRemoveIcon() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getBlackColorOption().click();
        productsGrid.getRemoveFilterIcon().click();

        String expectedHeadTitle = "COLOR";
        String actualHeadTitle = productsGrid.getColorHeadTable().getText();

        assertThat("The head title is not displayed", actualHeadTitle, is(expectedHeadTitle));
    }


    @Test // 5. Clear filter using "Clear All" link
    public void clearFilterWithClearAll() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getBlackColorOption().click();
        productsGrid.getClearAllFiltersLink().click();


        String expectedHeadTitle = "COLOR";
        String actualHeadTitle = productsGrid.getColorHeadTable().getText();

        assertThat("The head title is not displayed", actualHeadTitle, is(expectedHeadTitle));
    }


    @Test //6. Sort by name
    public void SortByName() {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        Select oSelect = new Select(driver.findElement(By.cssSelector(".sort-by select")));
        oSelect.selectByVisibleText("Name");


        String actualSortByValue= "                            Name                        ";

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String expctedSortByValue= productsGrid.getSelectedSortByOption().getText();

        assertThat("The Sort by option do not match", actualSortByValue, is (expctedSortByValue));
    }



    @Test // 7. Change product order
    public void ChangeProductsOrder (){
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid= PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getChangeProductsOrder().click();
        String url = driver.getCurrentUrl();
        String[] urlParts= url.split("=");
        String secondUrlPart= urlParts [1];
        String[] finalPart= secondUrlPart.split("&");
        String order= finalPart [0];

        String expectedOrder= "desc";
        String actualOrder= order;
        assertThat("The product orders do not match", actualOrder, is (expectedOrder));
    }

    @Test //8. Change visualisation mode
    public void ViewAsList (){
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getListIcon().click();

        String expectedDisplayModel="List";
        String actualDisplayModel= productsGrid.getSelectedListOption().getAttribute("title");
        assertThat("The products model order does not match", actualDisplayModel, is (expectedDisplayModel));
    }

    @Test //9. Verify that the number of products displayed is equal to the displayed <no>Items
    public void checkNumberOfProductsDisplayed ()  {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();


        ProductsGrid productsGrid= PageFactory.initElements(driver, ProductsGrid.class);
        int actualProductNumber= driver.findElements(By.xpath("//a[@class=\"link-compare\"]")).size();
        Integer.toString (actualProductNumber);

        String initialProductNumber=productsGrid.getNumberOfProductsDisplayed().getText();
        String [] splitNumber= initialProductNumber.split(" ");
        String finalNumber= splitNumber [0];
        String expectedProductNumber= finalNumber;

        System.out.println( actualProductNumber + expectedProductNumber);
        assertThat("The number of products displayed do not match", actualProductNumber, Is.<Integer>is (Integer.valueOf(expectedProductNumber)));
    }


    @Test // 10. verify that user is redirected to product page when clicking the product image
    public void redirectToProductPageWhenClickingProductImage ()  {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid =PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.getProductImageLink().click();


        ProductPage productPage=PageFactory.initElements(driver, ProductPage.class);
        String expectedPageTitle= "BROAD ST. FLAPOVER BRIEFCASE";
        String actualPageTitle= productPage.getPageTitle().getText();
        assertThat("The titles does not match", actualPageTitle, is (expectedPageTitle));
    }

    @Test //11. Verify that the number mentioned next to the filetr link is reflecting the actual number of products
    public void verifyThatTheNUmberOfFilterIsReflectedOnProductGrid () {
        Header header = PageFactory.initElements(driver, Header.class);
        header.getVipLink().click();

        ProductsGrid productsGrid= PageFactory.initElements(driver, ProductsGrid.class);
        String productsValue= productsGrid.getNumberOfProductsOnFilter().getText();
        String [] split = productsValue.split("(");
        String updatedValue=split[1];
        //String [] removeSecondParanthese= updatedValue.split("\)");
        //String expectedNumberOfProducts = removeSecondParanthese[0];

        productsGrid.getLeatherFilterLink().click();

        String initialProductNumber=productsGrid.getNumberOfProductsDisplayed().getText();
        String [] splitNumber= initialProductNumber.split(" ");
        String finalNumber= splitNumber [0];
        String actualProductNumber= finalNumber;

        //assertThat("The products number do not match", actualProductNumber, is (expectedNumberOfProducts));

    }

}
