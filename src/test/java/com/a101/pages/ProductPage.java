package com.a101.pages;

import com.a101.utility.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    Utility utility;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility = new Utility(driver);
    }

    @FindBy(css = "input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    WebElement searchBox;

    @FindBy(xpath = "//div[contains(text(),'ARA')]")
    WebElement searchButton;

    @FindBy(xpath = "//h3[contains(text(),'iPhone 14 Pro Max 256 GB')]")
    WebElement specificProduct;

    @FindBy(xpath = "//*[@class='optionsLength']")
    WebElement allSellers;

    @FindBy(xpath = "(//*[@class='add-to-basket button'])[3]")
    WebElement addFirstProduct;

    @FindBy(xpath = "(//*[@class='add-to-basket button'])[4]")
    WebElement addSecondProduct;

    @FindBy(id = "shoppingCart")
    WebElement goToCartButton;

    @FindBy(xpath = "(//a[.='iPhone 14 Pro Max 256 GB'])[1]")
    WebElement checkFirstProduct;

    @FindBy(xpath = "(//a[.='iPhone 14 Pro Max 256 GB'])[2]")
    WebElement checkSecondProduct;

    public void fillSearchBox(String productName){
        utility.waitForElementPresent(searchBox);
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public void clickSpecificProduct(){
        String originalWindow = driver.getWindowHandle();
        utility.waitForElementPresent(specificProduct);
        specificProduct.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickAllSellers(){
        utility.waitForElementPresent(allSellers);
        allSellers.click();
    }

    public void clickAddFirstProduct(){
        utility.waitForElementPresent(addFirstProduct);
        addFirstProduct.click();
    }

    public void clickAddSecondProduct(){
        utility.waitForElementPresent(addSecondProduct);
        addSecondProduct.click();
    }

    public void clickAddGoToCartButton(){
        utility.waitForElementPresent(goToCartButton);
        goToCartButton.click();
    }

    public boolean verifyIsSelectedCorrect(){
        utility.waitForElementPresent(checkFirstProduct);
        utility.waitForElementPresent(checkSecondProduct);
        if (checkFirstProduct.getText().contains("iPhone") && checkSecondProduct.getText().contains("iPhone")){
            System.out.println("Selected Products were correct");
            return true;
        }else {
            return false;
        }
    }

}
