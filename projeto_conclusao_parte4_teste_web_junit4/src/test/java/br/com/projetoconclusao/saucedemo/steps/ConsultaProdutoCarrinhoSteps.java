package br.com.projetoconclusao.saucedemo.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.com.projetoconclusao.saucedemo.pages.CartPage;
import br.com.projetoconclusao.saucedemo.pages.LoginPage;
import br.com.projetoconclusao.saucedemo.pages.ProductDetailsPage;
import br.com.projetoconclusao.saucedemo.pages.ProductsPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ConsultaProdutoCarrinhoSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;

    private String nomeProdutoEsperado;
    private String precoProdutoEsperado;

    private String precoNaLista;
    private String precoNaDetalhe;
    private String precoNoCarrinho;

    @Dado("que estou logado na SauceDemo")
    public void que_estou_logado_na_sauce_demo() {
        driver = Hooks.getDriver();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);

        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Quando("eu consulto o produto {string} com preco {string} ate o carrinho")
    public void eu_consulto_o_produto_com_preco_ate_o_carrinho(String nomeProduto, String precoProduto) {
        this.nomeProdutoEsperado = nomeProduto;
        this.precoProdutoEsperado = precoProduto;

        precoNaLista = productsPage.getProductPriceByName(nomeProdutoEsperado);
        assertEquals(precoProdutoEsperado, precoNaLista);

        productsPage.openProductDetails(nomeProdutoEsperado);

        String nomeNaDetalhe = productDetailsPage.getProductName();
        precoNaDetalhe = productDetailsPage.getProductPrice();

        assertEquals(nomeProdutoEsperado, nomeNaDetalhe);
        assertEquals(precoProdutoEsperado, precoNaDetalhe);

        productDetailsPage.addToCart();
        productDetailsPage.goToCart();

        String nomeNoCarrinho = cartPage.getProductName();
        precoNoCarrinho = cartPage.getProductPrice();

        assertEquals(nomeProdutoEsperado, nomeNoCarrinho);
        assertEquals(precoProdutoEsperado, precoNoCarrinho);
    }

    @Entao("o nome e o preco devem permanecer os mesmos em todas as telas")
    public void o_nome_e_o_preco_devem_permanecer_os_mesmos_em_todas_as_telas() {
        assertEquals(precoProdutoEsperado, precoNaLista);
        assertEquals(precoProdutoEsperado, precoNaDetalhe);
        assertEquals(precoProdutoEsperado, precoNoCarrinho);
    }
}