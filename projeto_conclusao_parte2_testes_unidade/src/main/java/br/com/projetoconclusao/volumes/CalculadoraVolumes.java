package br.com.projetoconclusao.volumes;

/**
 * Classe utilitária para cálculo de volumes de sólidos geométricos simples.
 */
public class CalculadoraVolumes {

    /**
     * Calcula o volume de um cubo.
     *
     * @param lado comprimento da aresta do cubo (deve ser não negativo)
     * @return volume do cubo
     * @throws IllegalArgumentException se o lado for negativo
     */
    public static double volumeCubo(double lado) {
        if (lado < 0) {
            throw new IllegalArgumentException("O lado do cubo não pode ser negativo.");
        }
        return Math.pow(lado, 3);
    }

    /**
     * Calcula o volume de um paralelepípedo (caixa retangular).
     *
     * @param comprimento comprimento do paralelepípedo (deve ser não negativo)
     * @param largura     largura do paralelepípedo (deve ser não negativa)
     * @param altura      altura do paralelepípedo (deve ser não negativa)
     * @return volume do paralelepípedo
     * @throws IllegalArgumentException se qualquer medida for negativa
     */
    public static double volumeParalelepipedo(double comprimento, double largura, double altura) {
        if (comprimento < 0 || largura < 0 || altura < 0) {
            throw new IllegalArgumentException("As dimensões do paralelepípedo não podem ser negativas.");
        }
        return comprimento * largura * altura;
    }

    /**
     * Calcula o volume de uma esfera.
     *
     * @param raio raio da esfera (deve ser não negativo)
     * @return volume da esfera
     * @throws IllegalArgumentException se o raio for negativo
     */
    public static double volumeEsfera(double raio) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio da esfera não pode ser negativo.");
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }
}