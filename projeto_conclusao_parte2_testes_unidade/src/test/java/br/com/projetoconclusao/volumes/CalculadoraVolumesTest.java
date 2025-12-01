package br.com.projetoconclusao.volumes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Testes de unidade para a classe CalculadoraVolumes.
 */
public class CalculadoraVolumesTest {

    // 2.2 - Teste de unidade simples para o volume de um cubo
    @Test
    @DisplayName("Deve calcular corretamente o volume de um cubo com lado 2")
    void deveCalcularVolumeCuboSimples() {
        // arrange
        double lado = 2.0;
        double volumeEsperado = 8.0; // 2 * 2 * 2

        // act
        double volumeCalculado = CalculadoraVolumes.volumeCubo(lado);

        // assert
        assertEquals(volumeEsperado, volumeCalculado, 0.0001,
                "O volume do cubo de lado 2 deve ser 8.");
    }

    // Fonte de dados para o teste parametrizado do paralelepípedo
    static Stream<Arguments> fornecerDadosParalelepipedo() {
        return Stream.of(
                Arguments.of(2.0, 3.0, 4.0, 24.0),   // 2 * 3 * 4
                Arguments.of(1.5, 2.0, 3.0, 9.0),    // 1.5 * 2 * 3
                Arguments.of(10.0, 0.5, 2.0, 10.0)); // 10 * 0.5 * 2
    }

    // 2.2 - Teste lendo uma lista de valores para o volume de um paralelepípedo
    @ParameterizedTest(name = "Paralelepípedo {0} x {1} x {2} deve ter volume {3}")
    @MethodSource("fornecerDadosParalelepipedo")
    @DisplayName("Deve calcular corretamente o volume de vários paralelepípedos")
    void deveCalcularVolumeParalelepipedoComLista(double comprimento, double largura, double altura,
            double volumeEsperado) {

        double volumeCalculado = CalculadoraVolumes.volumeParalelepipedo(comprimento, largura, altura);

        assertEquals(volumeEsperado, volumeCalculado, 0.0001);
    }

    // 2.3 - Teste com CSV para o volume da esfera
    @ParameterizedTest(name = "Esfera de raio {0} deve ter volume aproximado {1}")
    @CsvFileSource(resources = "/esfera_dados.csv", numLinesToSkip = 1, delimiter = ';')
    @DisplayName("Deve calcular corretamente o volume de esferas usando massa de teste de um CSV")
    void deveCalcularVolumeEsferaComCsv(double raio, double volumeEsperado) {

        double volumeCalculado = CalculadoraVolumes.volumeEsfera(raio);

        assertEquals(volumeEsperado, volumeCalculado, 0.0001);
    }
}