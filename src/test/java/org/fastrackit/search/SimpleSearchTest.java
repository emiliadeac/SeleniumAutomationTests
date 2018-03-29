package org.fastrackit.search;

import org.fastrackit.AppConfig;
import org.fastrackit.TestBase;
import org.fastrackit.webviews.Header;
import org.fastrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)

public class SimpleSearchTest extends TestBase {

    private String keyword;

    public SimpleSearchTest(String keyword) {
        this.keyword = keyword;
    }

    @Parameterized.Parameters
    public static List<String> inputData(){
        return Arrays.asList("vase", "camera");
    }

    @Test
    public void simpleSearchWithOneKeyword() throws InterruptedException {
        Header header = initElements( Header.class);// initializare elementelor din prduct grid
        header.search(keyword);
        ProductsGrid productsGrid = initElements( ProductsGrid.class);
        System.out.println("Found" + productsGrid.getProductNames().size() + "product names");
        for (WebElement nameContainer : productsGrid.getProductNames()) {
            assertThat("Some of the products names do not contain the searched keyword.", nameContainer.getText(), containsString(keyword.toUpperCase()));
        }


    }

    @Test
    public void specialPriceDisplayedAferSimpleSearch() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);
        String oldPrice = driver.findElement(By.xpath("//p[contains(@class, \"old-price\")]//span[contains(@class, \"price\")]")).getText();
        String specialPrice = driver.findElement(By.xpath("//p[contains(@class, \"special-price\")]//span[contains(@class, \"price\")]")).getText();

        //li[contains(@a \"https://fasttrackit.org/selenium-test/vip.html?apparel_type=36")]

        //driver.findElement(By.name("q")).sendKeys("vase"+Keys.ENTER);
        //driver.findElement(By.className("input-text")).sendKeys("vase"+Keys.ENTER);
    }

    @Test
    public void specialPriceDisplayedAferSimpleSearch2() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("vase"+ Keys.ENTER);
        String imageSource = driver.findElement(By.cssSelector("#product-collection-image-437")).getAttribute("src");
        driver.findElement(By.name("black")).click();
        Thread.sleep(1000);
        String newIamgeSource= driver.findElement(By.cssSelector(".product-collection-image-437")).getAttribute("src");
}




}
