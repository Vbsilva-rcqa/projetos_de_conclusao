package br.com.projetoconclusao.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private By productName = By.className("inventory_details_name");
    private By productPrice = By.className("inventory_details_price");
    private By addToCartButton = By.cssSelector("button[id^='add-to-cart']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    /**
     * Vai diretamente para a página do carrinho.
     * Isso evita problemas com pop-ups do navegador (como aviso de senha comprometida)
     * que podem bloquear o clique no ícone do carrinho.
     */
    public void goToCart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
}
