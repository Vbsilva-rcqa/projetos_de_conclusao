package br.com.projetoconclusao.mobile.calculadora;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Classe base para os testes mobile com Appium.
 * Configura o AndroidDriver apontando para o app da Calculadora do Google.
 */
public abstract class BaseTest {

    protected AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        // Capabilities no padrão Appium 2 / W3C
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Ajuste estes dois se o seu "adb devices" mostrar outro valor
        options.setDeviceName("emulator-5554");
        options.setUdid("emulator-5554");

        // App da calculadora do Google
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        // não reinstalar/limpar o app toda vez
        options.setNoReset(true);

        // Appium 2: URL sem /wd/hub
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(appiumServerUrl, options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
