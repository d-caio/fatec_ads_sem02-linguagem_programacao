/*
OBJETIVO: Receba um número. Calcule e mostre os resultados da tabuada desse número.
PROGRAMADOR: Caio Dias (d-caio).
DATA: 16/03/2026
*/

import javax.swing.JOptionPane;

import entrada_saida.EntradaSaida;

public class Lote1Ex34ModFunc {
    public static void main(String[] args) {
        int num;
        
        try {
            num = EntradaSaida.entradaInteger("Número entre 1 e 10: ");

            String msg = tabuada(num, "");

            JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            EntradaSaida.excecao("O valor precisa ser um número inteiro.", "erro");

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            EntradaSaida.excecao(e.getMessage(), "erro");

        } catch (NullPointerException e) {
            EntradaSaida.excecao(e.getMessage(), "warning");
            
        }
    }

    private static String tabuada(int num, String msg) {
        if (num < 1 || num > 10)
            throw new IllegalArgumentException("O número precisa ser entre 1 e 10.");

        int maxLinhas = 10;
        
        int numLinhas = (msg.isBlank()) ? 0 : (int) msg.lines().count();

        StringBuilder msgBuilder = new StringBuilder();

        int fator = numLinhas + 1;

        if (numLinhas > 0) {
            String[] linhas = msg.split("\\R");

            for (int i = 0; i < linhas.length; i++) {
                String regexLinha = num + "x" + (i + 1) + "=" + (num * (i + 1));

                if (!linhas[i].matches(regexLinha))
                    throw new IllegalArgumentException("As linhas devem ter o formato AxB=(A*B).");
            }
        }

        if (numLinhas == maxLinhas)
            return msg;

        if (numLinhas > maxLinhas)
            throw new ArrayIndexOutOfBoundsException("A mensagem de resultado deve ter exatamente dez linhas.");

        if (numLinhas > 0 && numLinhas < maxLinhas)
            msgBuilder.append(msg);

        msgBuilder.append(num).append("x").append(fator).append("=").append((num * fator)).append("\n");

        String msgParcial = msgBuilder.toString();

        return tabuada(num, msgParcial);

    }
}