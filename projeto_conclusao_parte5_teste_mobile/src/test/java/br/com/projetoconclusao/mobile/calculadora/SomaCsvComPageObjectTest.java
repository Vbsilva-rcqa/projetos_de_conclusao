package br.com.projetoconclusao.mobile.calculadora;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.projetoconclusao.mobile.calculadora.pages.CalculadoraPage;

/**
 * 5.2 - Teste usando Page Objects e leitura de um CSV
 * com pelo menos 3 cálculos diferentes.
 */
@RunWith(Parameterized.class)
public class SomaCsvComPageObjectTest extends BaseTest {

    private final int a;
    private final int b;
    private final int resultadoEsperado;

    public SomaCsvComPageObjectTest(int a, int b, int resultadoEsperado) {
        this.a = a;
        this.b = b;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters(name = "{index}: {0} + {1} = {2}")
    public static Collection<Object[]> dados() throws IOException {
        List<Object[]> dados = new ArrayList<>();

        InputStream is = SomaCsvComPageObjectTest.class
                .getClassLoader()
                .getResourceAsStream("dados_soma.csv");

        if (is == null) {
            throw new IOException("Arquivo dados_soma.csv não encontrado em src/test/resources.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String linha = reader.readLine(); // pula o cabeçalho

            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linha.split(";");
                int a = Integer.parseInt(partes[0].trim());
                int b = Integer.parseInt(partes[1].trim());
                int resultado = Integer.parseInt(partes[2].trim());
                dados.add(new Object[] { a, b, resultado });
            }
        }

        return dados;
    }

    @Test
    public void deveSomarNumerosUsandoPageObjectELendoDoCsv() {
        CalculadoraPage page = new CalculadoraPage(driver);

        int resultadoObtido = page.somar(a, b);

        assertEquals("Resultado da soma está incorreto para " + a + " + " + b,
                resultadoEsperado, resultadoObtido);
    }
}