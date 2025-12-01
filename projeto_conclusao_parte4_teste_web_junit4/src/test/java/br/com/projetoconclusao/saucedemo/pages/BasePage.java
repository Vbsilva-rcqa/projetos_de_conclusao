package br.com.projetoconclusao.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}