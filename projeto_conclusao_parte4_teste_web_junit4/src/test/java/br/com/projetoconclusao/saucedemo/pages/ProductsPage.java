package br.com.projetoconclusao.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private By inventoryItem = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPriceByName(String productNameText) {
        WebElement product = findProductByName(productNameText);
        return product.findElement(productPrice).getText();
    }

    public void openProductDetails(String productNameText) {
        WebElement product = findProductByName(productNameText);
        product.findElement(productName).click();
    }

    public void goToCart() {
        clickCartIcon();
    }

    private WebElement findProductByName(String productNameText) {
        List<WebElement> products = driver.findElements(inventoryItem);

        return products.stream()
                .filter(item -> item.findElement(productName).getText().equals(productNameText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado na lista: " + productNameText));
    }
}