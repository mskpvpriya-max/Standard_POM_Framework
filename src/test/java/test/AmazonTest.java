package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AmazonPage;

public class AmazonTest extends BaseTest {

    @Test
    public void searchTest() {
        // Initialize AmazonPage passing the active driver from BaseTest
        AmazonPage amazonPage = new AmazonPage(driver);

        // Perform search
        amazonPage.searchProduct("laptop");

        // Verify that the URL changed to include search keyword
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains("laptop"), 
            "URL does not contain the searched product keyword!");

        // Click the first product
        amazonPage.clickFirstProduct();
    }

}
