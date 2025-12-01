package br.com.projetoconclusao.mobile.calculadora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

/**
 * Page Object da Calculadora do Google.
 * Encapsula as ações necessárias para realizar operações de soma.
 */
public class CalculadoraPage {

    private static final String APP_PACKAGE = "com.google.android.calculator";

    private final AndroidDriver driver;

    public CalculadoraPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public int somar(int a, int b) {
        limpar();

        digitarNumero(a);
        clicarSoma();
        digitarNumero(b);
        clicarIgual();

        String resultadoTexto = obterResultadoTexto();

        return Integer.parseInt(resultadoTexto);
    }

    public void limpar() {
        try {
            WebElement botaoClr = driver.findElement(By.id(APP_PACKAGE + ":id/clr"));
            botaoClr.click();
        } catch (Exception ignored) {
        }
    }

    public void digitarNumero(int numero) {
        String texto = String.valueOf(numero);
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                String id = APP_PACKAGE + ":id/digit_" + c;
                WebElement digito = driver.findElement(By.id(id));
                digito.click();
            }
        }
    }

    public void clicarSoma() {
        WebElement botaoSoma = driver.findElement(By.id(APP_PACKAGE + ":id/op_add"));
        botaoSoma.click();
    }

    public void clicarIgual() {
        WebElement botaoIgual = driver.findElement(By.id(APP_PACKAGE + ":id/eq"));
        botaoIgual.click();
    }

    public String obterResultadoTexto() {
        WebElement campoResultado =
                driver.findElement(By.id(APP_PACKAGE + ":id/result_final"));
        String texto = campoResultado.getText();
        return texto.replace("=", "").trim();
    }
}
