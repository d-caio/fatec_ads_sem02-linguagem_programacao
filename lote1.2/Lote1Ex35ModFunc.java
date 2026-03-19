/*
OBJETIVO: Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e mostre o resultado da somatória dos números ímpares entre esses valores.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 16/03/2026
*/

import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex35ModFunc {
    private static int num1, num2, maior, menor, resultado;
    StringBuilder msgBuilder = new StringBuilder();

    public static void main(String[] args) {
        try {
            num1 = EntradaSaida.entradaInteger("Primeiro número: ");
            num2 = EntradaSaida.entradaInteger("Segundo número: ");

            maiorMenor();

            resultado = somaImpares(menor, maior);

            JOptionPane.showMessageDialog(null, "A soma dos ímpares entre " + menor + " e " + maior + " é " + resultado);

        } catch (NumberFormatException e) {
            EntradaSaida.excecao("Os números precisam ser inteiros.", "erro");

        } catch (IllegalArgumentException e) {
            EntradaSaida.excecao(e.getMessage(), "erro");

        } catch (NullPointerException e) {
            EntradaSaida.excecao(e.getMessage(), "warning");

        }
    }

    private static void maiorMenor() {
        if (num1 == num2)
            throw new IllegalArgumentException("Os números precisam ser diferentes.");

        maior = Math.max(num1, num2);
        menor = Math.min(num1, num2);
    }

    private static int somaImpares(int menor, int maior) {
        if (menor % 2 != 0) {
            if (menor == maior)
                return menor;

            return menor + somaImpares(menor + 1, maior);
        }

        return somaImpares(menor + 1, maior);

    }
}
