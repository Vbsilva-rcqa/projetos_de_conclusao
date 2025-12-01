package br.com.projetoconclusao.saucedemo.simple;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 4.1 - Script simples usando Selenium WebDriver (JUnit 4).
 */
public class ConsultaProdutoCarrinhoSimplesTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deveValidarNomeEPrecoDoProdutoAteCarrinho() {
        String nomeProdutoEsperado = "Sauce Labs Backpack";
        String precoProdutoEsperado = "$29.99";

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement produtoNaLista = driver.findElements(By.className("inventory_item"))
                .stream()
                .filter(item -> item.findElement(By.className("inventory_item_name"))
                        .getText()
                        .equals(nomeProdutoEsperado))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado na lista: " + nomeProdutoEsperado));

        String nomeNaLista = produtoNaLista.findElement(By.className("inventory_item_name")).getText();
        String precoNaLista = produtoNaLista.findElement(By.className("inventory_item_price")).getText();

        assertEquals(nomeProdutoEsperado, nomeNaLista);
        assertEquals(precoProdutoEsperado, precoNaLista);

        produtoNaLista.findElement(By.className("inventory_item_name")).click();

        String nomeDetalhes = driver.findElement(By.className("inventory_details_name")).getText();
        String precoDetalhes = driver.findElement(By.className("inventory_details_price")).getText();

        assertEquals(nomeProdutoEsperado, nomeDetalhes);
        assertEquals(precoProdutoEsperado, precoDetalhes);

        driver.findElement(By.cssSelector("button[id^='add-to-cart']")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        WebElement itemCarrinho = driver.findElement(By.className("cart_item"));

        String nomeCarrinho = itemCarrinho.findElement(By.className("inventory_item_name")).getText();
        String precoCarrinho = itemCarrinho.findElement(By.className("inventory_item_price")).getText();

        assertEquals(nomeProdutoEsperado, nomeCarrinho);
        assertEquals(precoProdutoEsperado, precoCarrinho);
    }
}