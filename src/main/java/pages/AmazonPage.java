package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By firstProduct = By.xpath("(//h2//a)[1]");

    // Constructor to receive the WebDriver instance from the test
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}