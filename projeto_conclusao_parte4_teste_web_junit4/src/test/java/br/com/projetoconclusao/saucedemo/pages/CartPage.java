package br.com.projetoconclusao.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private By cartItem = By.className("cart_item");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getFirstCartItem() {
        return driver.findElement(cartItem);
    }

    public String getProductName() {
        return getFirstCartItem().findElement(productName).getText();
    }

    public String getProductPrice() {
        return getFirstCartItem().findElement(productPrice).getText();
    }
}