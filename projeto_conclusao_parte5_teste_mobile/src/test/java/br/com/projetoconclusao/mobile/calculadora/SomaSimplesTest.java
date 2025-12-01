package br.com.projetoconclusao.mobile.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 5.1 - Script simples que realiza a operação de soma de dois números.
 */
public class SomaSimplesTest extends BaseTest {

    @Test
    public void deveSomarDoisNumerosSimples() {
        // 2 + 3 = 5
        clicarDigito(2);
        clicarSoma();
        clicarDigito(3);
        clicarIgual();

        String resultadoTexto = obterResultado();

        assertEquals("5", resultadoTexto);
    }

    private void clicarDigito(int numero) {
        String id = "com.google.android.calculator:id/digit_" + numero;
        WebElement digito = driver.findElement(By.id(id));
        digito.click();
    }

    private void clicarSoma() {
        WebElement botaoSoma =
                driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        botaoSoma.click();
    }

    private void clicarIgual() {
        WebElement botaoIgual =
                driver.findElement(By.id("com.google.android.calculator:id/eq"));
        botaoIgual.click();
    }

    private String obterResultado() {
        WebElement campoResultado =
                driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String texto = campoResultado.getText();
        return texto.replace("=", "").trim();
    }
}
